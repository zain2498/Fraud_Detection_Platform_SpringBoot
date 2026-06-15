package com.zain.transaction.transaction_service.mapper;

import com.zain.transaction.transaction_service.dto.TransactionEvent;
import com.zain.transaction.transaction_service.dto.TransactionProjection;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransactionEvent toEvent(
            TransactionProjection p) {

        return TransactionEvent.builder()
                .requestId(p.getRequestId())
                .transactionId(p.getTransactionId())
                .amount(p.getAmount())
                .customerAccountId(p.getCustomerAccountId())
                .paymentType(p.getPaymentType())
                .cardType(p.getReceiptCardType())
                .entryMethod(p.getReceiptEntryMethod())
                .responseCode(p.getResponseCode())
                .status(p.getStatus())
                .merchantId(p.getMerchantId())
                .transactionTime(
                        p.getRecordCreatedDate() != null ? p.getRecordCreatedDate().toString() : null)
                .build();
    }
}
