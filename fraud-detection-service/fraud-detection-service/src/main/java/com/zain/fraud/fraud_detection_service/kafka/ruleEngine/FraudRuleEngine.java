package com.zain.fraud.fraud_detection_service.kafka.ruleEngine;

import com.zain.fraud.fraud_detection_service.dto.FraudResultEvent;
import com.zain.fraud.fraud_detection_service.dto.TransactionEvent;
import com.zain.fraud.fraud_detection_service.service.CustomerRiskTracker;
import com.zain.fraud.fraud_detection_service.service.RefundTracker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class FraudRuleEngine {

    public FraudResultEvent evaluate(TransactionEvent event, CustomerRiskTracker customerRiskTracker, RefundTracker refundTracker) {
        int risk_score = 0;
        List<String> reasons = new ArrayList<>();

        //---RULE - 1 - HIGH RISK ENTRY METHOD
        if (Set.of(
                        "MANUAL",
                        "FALLBACK",
                        "KEYED_CARD_NOT_PRESENT")
                .contains(event.getEntryMethod())) {

            risk_score += 25;

            reasons.add(
                    "High Risk Entry Method");
        }

        //---RULE 2 - FAILED TRANSACTION
        if (event.getStatus() == 4 && event.getCustomerAccountId() != null) {

            int failures = customerRiskTracker.recordFailure(event.getCustomerAccountId());
            log.info(
                    "Customer {} failure count {}",
                    event.getCustomerAccountId(),
                    failures
            );
            reasons.add("Transaction Declined");
            if (failures >= 3) {
                log.warn(
                        "Customer {} exceeded failed transaction threshold. Failures={}",
                        event.getCustomerAccountId(),
                        failures
                );
                risk_score += 40;
                reasons.add("Multiple Failed attempts");
            }

            reasons.add(
                    "Transaction Declined");
        } else if (event.getStatus() == 2) {
            customerRiskTracker.reset(event.getCustomerAccountId());
        }

        //---RULE 3 HIGH AMOUNT
        if (event.getAmount() != null &&
                event.getAmount().compareTo(
                        new BigDecimal("1000")) > 0) {

            risk_score += 50;

            reasons.add(
                    "High Amount Transaction");
        }

        // RULE 4 - REFUND TRANSACTION
        if ("CANCEL_CREDIT_CARD".equals(
                event.getRequestType())) {

            int refundCounts = refundTracker.refund(event.getCustomerAccountId());

            risk_score += 40;

            reasons.add(
                    "Refund Transaction");

            if (refundCounts >= 3) {
                risk_score += 30;
                reasons.add("Multiple Refund attempts");
            }
        }

        // RULE 5 - ADJUSTMENT TRANSACTION
        if ("ADJUST_CREDIT_CARD".equals(
                event.getRequestType())
                ||
                "ADJUST_AFTER_SETTLE".equals(
                        event.getRequestType())) {

            risk_score += 0;

            reasons.add(
                    "Adjustment Transaction");
        }

        //RULE 6 - NEGATIVE AMOUNT DETECTION
        if (event.getAmount() != null && event.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            risk_score += 50;
            reasons.add(
                    "Negative Amount Transaction");
        }

        //RULE 8 - LARGE REFUND
        if ("CANCEL_CREDIT_CARD".equals(event.getRequestType())
        && event.getAmount() != null && event.getAmount().compareTo(new BigDecimal("1000")) > 0) {
            risk_score += 50;
            reasons.add(
                    "Large Refund Amount");
        }

        String decision;
        if (risk_score >= 70) {

            decision = "HIGH_RISK";

        } else if (risk_score >= 30) {

            decision = "MEDIUM_RISK";

        } else {

            decision = "LOW_RISK";
        }
        return FraudResultEvent.builder()
                .requestId(event.getRequestId())
                .transactionId(event.getTransactionId())
                .riskScore(risk_score)
                .decision(decision)
                .reasons(reasons)
                .analyzedAt(LocalDateTime.now().toString())
                .build();
    }
}
