package com.offlinepay.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferResponse {

    private Long transactionId;

    private Long senderId;
    private Long receiverId;

    private double amount;
    private String status;
    private LocalDateTime createdAt;
}
