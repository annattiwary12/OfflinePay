package com.offlinepay.backend.dto;

import lombok.Data;

@Data
public class WalletResponse {

    private  Long walletId;
    private Long userId;
    private double balance = 0.0;

}
