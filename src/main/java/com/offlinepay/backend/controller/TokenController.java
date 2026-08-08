package com.offlinepay.backend.controller;


import com.offlinepay.backend.dto.GenerateTokenRequest;
import com.offlinepay.backend.dto.TokenResponse;
import com.offlinepay.backend.dto.TokenValidationResponse;
import com.offlinepay.backend.dto.ValidateTokenRequest;
import com.offlinepay.backend.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/generate")
     public TokenResponse generateToken(@RequestBody GenerateTokenRequest  request){
         return tokenService.generateToken(request);
    }

    @PostMapping("/validate")
    public TokenValidationResponse   validateToken(
            @RequestBody ValidateTokenRequest request
            ){
         return tokenService.validateToken(request);
    }
    @PostMapping("/use")
    public String useToken(@RequestBody ValidateTokenRequest request){
         tokenService.markTokenUsed(request.getToken());

         return  "Token marked as USED";
    }

}
