package com.offlinepay.backend.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class TransferRequest {


    @NotNull(message = "Sender ID is required")
    private Long senderId;
    @NotNull(message = "Receiver ID is required")
    private Long receiverId;
    @Positive(message =  "Amount must be  greater than 0")
    private double amount;
}
;