package com.zain.fraud.fraud_detection_service.kafka.consumer;

import com.zain.fraud.fraud_detection_service.dto.FraudResultEvent;
import com.zain.fraud.fraud_detection_service.dto.TransactionEvent;
import com.zain.fraud.fraud_detection_service.kafka.producer.FraudResultProducer;
import com.zain.fraud.fraud_detection_service.kafka.ruleEngine.FraudRuleEngine;
import com.zain.fraud.fraud_detection_service.service.CustomerRiskTracker;
import com.zain.fraud.fraud_detection_service.service.RefundTracker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TransactionConsumer {

    private final FraudRuleEngine fraudRuleEngine;
    private final FraudResultProducer fraudResultProducer;
    private final CustomerRiskTracker customerRiskTracker;
    private final RefundTracker refundTracker;

    @KafkaListener(
            topics = "transactions",
            groupId = "fraud-group-v2"
    )
    public void consume(TransactionEvent event) {
        System.out.println("RECEIVED => " + event);
        log.info("Received Transaction {}",
                event.getTransactionId());
        FraudResultEvent fraud_results = fraudRuleEngine.evaluate(event,customerRiskTracker, refundTracker);

        fraudResultProducer.publish(fraud_results);
        log.info("Fraud Results Published Successfully {}",
                fraud_results);
    }
}
