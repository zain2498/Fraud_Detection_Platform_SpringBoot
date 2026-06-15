package com.zain.transaction.transaction_service.repository;

import com.zain.transaction.transaction_service.dto.TransactionProjection;
import com.zain.transaction.transaction_service.entity.TransactionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRequestRepository extends JpaRepository<TransactionRequest, Long> {

    @Query(value = """
                   SELECT
                            ppr.request_id AS requestId,
                            ptr.transaction_id AS transactionId,
                            ptr.amount AS amount,
                            ptr.status AS status,
                            ptr.response_code AS responseCode,
                            ptr.merchant_id AS merchantId,
            
                            ppr.customer_account_id AS customerAccountId,
                            ppr.reference_number AS referenceNumber,
                            ppr.reference_type_id,
                            ppr.reference_id,
                                        
                            pprd.request_type,
                            pprd.payment_type AS paymentType,
                            pprd.receipt_card_type AS receiptCardType,
                            pprd.receipt_entry_method AS receiptEntryMethod,
                            pprd.record_created_date AS recordCreatedDate
            
                        FROM fraud_transaction_request ptr
            
                        LEFT JOIN fraud_payment_request ppr
                               ON ppr.transaction_id = ptr.transaction_id
            
                        LEFT JOIN fraud_payment_request_details pprd
                               ON pprd.request_id = ppr.request_id
                        ORDER BY 1 DESC
                        LIMIT 100
            """, nativeQuery = true)
    List<TransactionProjection> fraudTransactions();
}
