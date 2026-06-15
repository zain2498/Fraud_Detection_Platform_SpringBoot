package com.zain.transaction.transaction_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TransactionProjection {
    Long getRequestId();

    String getTransactionId();

    BigDecimal getAmount();

    Integer getStatus();

    String getResponseCode();

    Integer getCustomerAccountId();

    String getReferenceNumber();

    String getPaymentType();

    String getReceiptCardType();

    String getReceiptEntryMethod();

    int getMerchantId();

    LocalDateTime getRecordCreatedDate();
}
