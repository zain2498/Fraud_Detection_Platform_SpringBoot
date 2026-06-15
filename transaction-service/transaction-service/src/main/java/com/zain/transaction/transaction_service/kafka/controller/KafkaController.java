package com.zain.transaction.transaction_service.kafka.controller;

import com.zain.transaction.transaction_service.kafka.service.KafkaPublishService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@AllArgsConstructor
public class KafkaController {
    private final KafkaPublishService kafkaPublishService;

    @PostMapping("/publish")
    public String publish(){
        int count = kafkaPublishService.publishTransactions();
        return count + "Transactions count: "+count+" published successfully.";
    }
}
