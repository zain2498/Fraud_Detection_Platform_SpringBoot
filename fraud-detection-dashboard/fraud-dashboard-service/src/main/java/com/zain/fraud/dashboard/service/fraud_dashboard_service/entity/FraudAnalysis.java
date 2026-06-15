package com.zain.fraud.dashboard.service.fraud_dashboard_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "fraud_analysis")
@Data
public class FraudAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requestId;

    private String transactionId;

    private Integer riskScore;

    private String decision;

    @Column(columnDefinition = "TEXT")
    private String reasons;

    private LocalDateTime analyzedAt;
}
