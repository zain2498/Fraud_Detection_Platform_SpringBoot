package com.zain.transaction.transaction_service.controller;

import com.zain.transaction.transaction_service.dto.TransactionEvent;
import com.zain.transaction.transaction_service.kafka.TransactionProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionProducer transactionProducer;

    @PostMapping
    public String createTransaciton(@RequestBody TransactionEvent event) {
        transactionProducer.publish(event);
        return "Transaction published successfully";
    }
}
