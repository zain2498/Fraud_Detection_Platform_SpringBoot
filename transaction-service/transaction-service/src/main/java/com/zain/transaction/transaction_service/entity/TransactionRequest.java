package com.zain.transaction.transaction_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_transaction_request")
@Getter
@Setter
public class TransactionRequest {

    @Id
    @Column(name = "transaction_request_id")
    private Long transactionRequestId;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "amount")
    private BigDecimal amount;

    private String status;

    @Column(name = "response_code")
    private String responseCode;
}
