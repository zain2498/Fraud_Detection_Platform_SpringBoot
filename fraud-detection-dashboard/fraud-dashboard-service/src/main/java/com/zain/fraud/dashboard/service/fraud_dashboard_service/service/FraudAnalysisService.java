package com.zain.fraud.dashboard.service.fraud_dashboard_service.service;

import com.zain.fraud.dashboard.service.fraud_dashboard_service.entity.FraudAnalysis;

import java.util.List;

public interface FraudAnalysisService {

    public List<FraudAnalysis> listOfFraudTransactions();
    public List<FraudAnalysis> listOfHighRiskTransactions(String request_type);
    public FraudSummary getFraudSummary();
}
