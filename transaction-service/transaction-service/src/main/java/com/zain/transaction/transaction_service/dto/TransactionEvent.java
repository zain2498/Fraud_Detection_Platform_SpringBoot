package com.zain.transaction.transaction_service.dto;
import  lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionEvent {

    private String transactionId;
    private String userId;
    private Double amount;
    private String location;
    private String merchant;
}
