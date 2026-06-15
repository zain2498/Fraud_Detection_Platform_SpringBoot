package com.zain.fraud.fraud_detection_service.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RefundTracker {

    public final ConcurrentHashMap<Integer, AtomicInteger> refundTracker = new ConcurrentHashMap<>();

    public int refund(Integer customerId) {
        return refundTracker.computeIfAbsent(customerId, k -> new AtomicInteger()).incrementAndGet();
    }

}
