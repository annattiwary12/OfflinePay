package com.offlinepay.backend.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String name;
    private String email;
    private Long userId;
    private String token;

}
