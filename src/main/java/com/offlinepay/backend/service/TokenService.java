package com.offlinepay.backend.service;


import com.offlinepay.backend.dto.GenerateTokenRequest;
import com.offlinepay.backend.dto.TokenResponse;
import com.offlinepay.backend.dto.TokenValidationResponse;
import com.offlinepay.backend.dto.ValidateTokenRequest;
import com.offlinepay.backend.model.Token;
import com.offlinepay.backend.model.User;
import com.offlinepay.backend.model.Wallet;
import com.offlinepay.backend.repository.TokenRepository;
import com.offlinepay.backend.repository.UserRepository;
import com.offlinepay.backend.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TokenService {

    @Autowired
    private TokenRepository  tokenRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;

    public TokenResponse  generateToken(GenerateTokenRequest req){
         User user  = userRepository.findById(req.getUserId())
                 .orElseThrow(()-> new RuntimeException("User not found"));

         Wallet wallet  =   walletRepository.findByUser(user)
                 .orElseThrow(()-> new RuntimeException("Wallet noy found"));

         if(wallet.getBalance() < req.getAmount()){
              throw new RuntimeException("Insufficient funds");
         }

        Token token  = new Token();
          token.setWallet(wallet);
          token.setTokenValue(UUID.randomUUID().toString());
          token.setAmount(req.getAmount());
          token.setStatus("ACTIVE");
          token.setCreatedAt(LocalDateTime.now());
          token.setExpiresAt(LocalDateTime.now().plusMinutes(10));

          Token saved = tokenRepository.save(token);
           return  new TokenResponse(
                   saved.getTokenValue(),
                   saved.getAmount(),
                   saved.getExpiresAt(),
                   saved.getStatus()
           );

    }
     public TokenValidationResponse validateToken(ValidateTokenRequest req){
         Token token =  tokenRepository.findByTokenValue(req.getToken())
                 .orElseThrow(()->  new RuntimeException("Token not found"));

         if(!token.getStatus().equals("ACTIVE")){
             return new TokenValidationResponse(
                     false,
                     "Token already used or inactive",
                     token.getAmount()
             );
         }
         if(token.getExpiresAt().isBefore(LocalDateTime.now())){
             return new TokenValidationResponse(
                     false,
                     "Token expired",
                     token.getAmount()
             );
         }
            return  new TokenValidationResponse(
                    true,
                    "token is  valid",
                    token.getAmount()
            );
     }
     public void markTokenUsed(String tokenValue){

        Token token = tokenRepository.findByTokenValue(tokenValue)
                .orElseThrow(()-> new RuntimeException("Token not found"));

         if(!token.getStatus().equals("ACTIVE")){
              throw new RuntimeException("Token already  used ");
         }

        token.setStatus("USED");
        tokenRepository.save(token);
     }
}
