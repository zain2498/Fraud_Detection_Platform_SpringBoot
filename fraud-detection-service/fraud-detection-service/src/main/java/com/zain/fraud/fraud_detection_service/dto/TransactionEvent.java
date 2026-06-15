package com.zain.fraud.fraud_detection_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEvent {

    private Long requestId;

    private String transactionId;

    private BigDecimal amount;

    private Integer customerAccountId;

    private String paymentType;

    private String cardType;

    private String entryMethod;

    private String responseCode;

    private int merchantId;

    private Integer status;

    private String transactionTime;

    private Integer referenceTypeId;

    private Integer referenceId;

    private String requestType;
}
