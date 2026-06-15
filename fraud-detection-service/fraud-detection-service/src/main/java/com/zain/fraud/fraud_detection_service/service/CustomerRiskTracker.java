package com.zain.fraud.fraud_detection_service.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CustomerRiskTracker {

    private ConcurrentHashMap<Integer, AtomicInteger> failedAttempts = new ConcurrentHashMap<>();

    public int recordFailure(Integer customerId){
        return failedAttempts.computeIfAbsent(customerId, k -> new AtomicInteger()).incrementAndGet();
    }

    public void  reset(Integer customerId){
        failedAttempts.remove(customerId);
    }
}
