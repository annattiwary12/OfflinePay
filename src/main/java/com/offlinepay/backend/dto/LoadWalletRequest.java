package com.offlinepay.backend.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class LoadWalletRequest {

    @NotNull( message = "UserId is required")
    private  Long userId;

    @Positive(message = "Amount must be greater than 0")
    private  double amount;

}
