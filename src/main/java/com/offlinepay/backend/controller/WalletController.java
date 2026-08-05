package com.offlinepay.backend.controller;

import com.offlinepay.backend.dto.LoadWalletRequest;
import com.offlinepay.backend.dto.WalletResponse;
import com.offlinepay.backend.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
     private WalletService walletService;

    @PostMapping("/load")
    public WalletResponse loadWallet(@RequestBody LoadWalletRequest request){
         return walletService.loadMoney(request);
    }

    @GetMapping("/{userId}")
    public WalletResponse getBalance(@PathVariable Long userId){
         return walletService.getBalance(userId);
    }

}
