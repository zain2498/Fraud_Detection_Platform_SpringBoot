package com.zain.fraud.dashboard.service.fraud_dashboard_service.service.impl;

import com.zain.fraud.dashboard.service.fraud_dashboard_service.entity.FraudAnalysis;
import com.zain.fraud.dashboard.service.fraud_dashboard_service.service.FraudAnalysisService;

import java.util.List;

public class FraudAnalysisServiceImpl extends FraudAnalysisService {
    @Override
    public List<FraudAnalysis> listOfFraudTransactions() {
        return List.of();
    }

    @Override
    public List<FraudAnalysis> listOfHighRiskTransactions(String request_type) {
        return List.of();
    }

    @Override
    public FraudSummary getFraudSummary() {
        return null;
    }
}
