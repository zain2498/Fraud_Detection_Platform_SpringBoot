package com.zain.fraud.dashboard.service.fraud_dashboard_service.repository;

import com.zain.fraud.dashboard.service.fraud_dashboard_service.entity.FraudAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudAnalysisRepository extends JpaRepository<FraudAnalysis, Long> {
}
