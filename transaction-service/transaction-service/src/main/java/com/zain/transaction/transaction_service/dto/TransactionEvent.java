package com.zain.transaction.transaction_service.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionEvent {

    private Long requestId;

    private String transactionId;

    private BigDecimal amount;

    private Integer customerAccountId;

    private String paymentType;

    private String cardType;

    private String entryMethod;

    private String responseCode;

    private Integer status;

    private  int merchantId;

    private String transactionTime;
    private Integer referenceTypeId;
    private Integer referenceId;
    private String requestType;
}
