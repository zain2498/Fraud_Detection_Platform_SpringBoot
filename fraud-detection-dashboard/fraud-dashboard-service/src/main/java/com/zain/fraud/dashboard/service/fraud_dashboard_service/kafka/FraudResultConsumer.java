package com.zain.fraud.dashboard.service.fraud_dashboard_service.kafka;

import com.zain.fraud.dashboard.service.fraud_dashboard_service.entity.FraudAnalysis;
import com.zain.fraud.dashboard.service.fraud_dashboard_service.event.FraudResultEvent;
import com.zain.fraud.dashboard.service.fraud_dashboard_service.repository.FraudAnalysisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class FraudResultConsumer {

    private final FraudAnalysisRepository repository;

    @KafkaListener(
            topics = "fraud-results",
            groupId = "fraud-dashboard-group"
    )
    public void consume(
            FraudResultEvent event) {

        FraudAnalysis entity =
                new FraudAnalysis();

        entity.setRequestId(
                event.getRequestId());

        entity.setTransactionId(
                event.getTransactionId());

        entity.setRiskScore(
                event.getRiskScore());

        entity.setDecision(
                event.getDecision());

        entity.setReasons(
                String.join(
                        ",",
                        event.getReasons()));

        entity.setAnalyzedAt(
                LocalDateTime.parse(
                        event.getAnalyzedAt()));

        repository.save(entity);
    }
}
