package com.offlinepay.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ValidateTokenRequest {

    @NotBlank(message =  "Token is Required")
    private String token;
}

