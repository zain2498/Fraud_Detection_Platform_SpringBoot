package com.zain.transaction.transaction_service.kafka.service;

import com.zain.transaction.transaction_service.dto.TransactionProjection;
import com.zain.transaction.transaction_service.kafka.producer.TransactionProducer;
import com.zain.transaction.transaction_service.mapper.TransactionMapper;
import com.zain.transaction.transaction_service.repository.TransactionRequestRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class KafkaPublishService {

    private final TransactionProducer transactionProducer;
    private final TransactionRequestRepository transactionRequestRepository;
    private final TransactionMapper transactionMapper;

    public int publishTransactions(){

        List<TransactionProjection> transactions = transactionRequestRepository.fraudTransactions();

        transactions.stream().map(transactionMapper::toEvent).forEach(transactionProducer::publish);

        return transactions.size();
    }

}
