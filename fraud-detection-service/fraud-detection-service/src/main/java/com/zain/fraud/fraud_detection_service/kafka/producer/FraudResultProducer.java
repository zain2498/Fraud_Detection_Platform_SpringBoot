package com.zain.fraud.fraud_detection_service.kafka.producer;

import com.zain.fraud.fraud_detection_service.dto.FraudResultEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudResultProducer {

    private final KafkaTemplate<String, FraudResultEvent> kafkaTemplate;

    public void publish(FraudResultEvent event) {
        kafkaTemplate.send("fraud-results", event.getTransactionId(), event);
    }
}
