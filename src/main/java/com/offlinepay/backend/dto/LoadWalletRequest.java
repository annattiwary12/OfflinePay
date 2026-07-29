package com.offlinepay.backend.dto;



import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoadWalletRequest {

    @NotBlank( message = "Required  userId")
    private  Long UserId;

    @NotBlank(message = " amount  is Required")
    private  double amount  = 0.0;
}
