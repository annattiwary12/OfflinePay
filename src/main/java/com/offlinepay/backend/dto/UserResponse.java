package com.offlinepay.backend.dto;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private Double walletBalance;
}
