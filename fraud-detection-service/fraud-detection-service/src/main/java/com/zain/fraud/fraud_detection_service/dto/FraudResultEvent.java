package com.zain.fraud.fraud_detection_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudResultEvent {
    private Long requestId;

    private String transactionId;

    private Integer riskScore;

    private String decision;

    private List<String> reasons;

    private String analyzedAt;
}
