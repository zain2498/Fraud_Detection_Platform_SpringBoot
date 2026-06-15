package com.zain.transaction.transaction_service.controller;

import com.zain.transaction.transaction_service.dto.TransactionProjection;
import com.zain.transaction.transaction_service.entity.TransactionRequest;
import com.zain.transaction.transaction_service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionRequestController {

    private final TransactionService transactionService;

    @GetMapping("/fraud-data")
    public List<TransactionProjection> getTransactionRequests() {
        return transactionService.getTransactions();
    }
}
