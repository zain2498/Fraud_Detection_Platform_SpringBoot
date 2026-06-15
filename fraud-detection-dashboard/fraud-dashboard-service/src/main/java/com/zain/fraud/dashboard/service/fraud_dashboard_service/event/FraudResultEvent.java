package com.zain.fraud.dashboard.service.fraud_dashboard_service.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FraudResultEvent {
    private Long requestId;
    private String transactionId;
    private int riskScore;
    private String decision;
    private List<String> reasons;
    private String analyzedAt;
    private BigDecimal amount;
    private Integer customerAccountId;
    private Integer merchantId;
    private String entryMethod;
    private String requestType;
    private Integer referenceTypeId;
    private Integer referenceId;
}
