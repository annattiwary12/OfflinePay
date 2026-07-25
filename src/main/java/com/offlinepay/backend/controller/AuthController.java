package com.offlinepay.backend.controller;


import com.offlinepay.backend.dto.RegisterRequest;
import com.offlinepay.backend.dto.UserResponse;
import com.offlinepay.backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(
            @RequestBody @Valid RegisterRequest req){

        UserResponse res = userService.register(req);
        return ResponseEntity.status(201)
                .body(res);
    }

}
