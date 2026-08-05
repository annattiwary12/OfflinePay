package com.offlinepay.backend.service;


import com.offlinepay.backend.dto.LoadWalletRequest;
import com.offlinepay.backend.dto.WalletResponse;
import com.offlinepay.backend.model.User;
import com.offlinepay.backend.model.Wallet;
import com.offlinepay.backend.repository.UserRepository;
import com.offlinepay.backend.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepository  walletRepository;

    @Autowired
     private UserRepository userRepository;

    public WalletResponse loadMoney(LoadWalletRequest req) {

        // find User
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new RuntimeException("user not found"));

        // find wallet
        Wallet wallet = walletRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        // Add balance
        wallet.setBalance(wallet.getBalance() + req.getAmount());

        walletRepository.save(wallet);

        return new WalletResponse(
                wallet.getId(),
                user.getId(),
                wallet.getBalance()
        );
    }
    public  WalletResponse  getBalance(Long userId){
         User  user  = userRepository.findById(userId)
                 .orElseThrow(() -> new RuntimeException("user not found"));

         Wallet  wallet  =  walletRepository.findByUser(user)
                 .orElseThrow(()-> new RuntimeException("wallet not found"));

         return new WalletResponse(
                 wallet.getId(),
                 user.getId(),
                 wallet.getBalance()
         );
    }
}
