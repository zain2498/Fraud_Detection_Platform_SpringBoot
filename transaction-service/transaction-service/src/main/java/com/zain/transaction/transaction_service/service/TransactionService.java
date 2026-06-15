package com.zain.transaction.transaction_service.service;

import com.zain.transaction.transaction_service.dto.TransactionProjection;
import com.zain.transaction.transaction_service.entity.TransactionRequest;
import com.zain.transaction.transaction_service.repository.TransactionRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRequestRepository transactionRequestRepository;

    public List<TransactionProjection> getTransactions(){
        return transactionRequestRepository.fraudTransactions();
    }
}
