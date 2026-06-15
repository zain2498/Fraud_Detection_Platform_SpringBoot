package com.zain.fraud.dashboard.service.fraud_dashboard_service.controller;

import com.zain.fraud.dashboard.service.fraud_dashboard_service.entity.FraudAnalysis;
import com.zain.fraud.dashboard.service.fraud_dashboard_service.service.impl.FraudAnalysisServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fraud-analysis")
@RequiredArgsConstructor
public class FraudAnalysisController {
    private FraudAnalysisServiceImpl fraudAnalysisService;

    @GetMapping
    public List<FraudAnalysis> getAllFraudTransactions() {
        return fraudAnalysisService.listOfFraudTransactions();
    }

    @GetMapping("/high-risk")
    public List<FraudAnalysis> getAllHighRiskTransactions(String request_type) {
        return fraudAnalysisService.listOfHighRiskTransactions("high-risk");
    }

    @GetMapping("/summary")
    public FraudSummary getFraudSummary(){

    }
}
