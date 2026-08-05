package com.offlinepay.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletResponse {

    private  Long walletId;
    private Long userId;
    private double balance ;

}
