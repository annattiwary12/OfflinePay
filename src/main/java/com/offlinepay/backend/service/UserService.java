package com.offlinepay.backend.service;


import com.offlinepay.backend.dto.LoginRequest;
import com.offlinepay.backend.dto.LoginResponse;
import com.offlinepay.backend.dto.RegisterRequest;
import com.offlinepay.backend.dto.UserResponse;
import com.offlinepay.backend.model.User;
import com.offlinepay.backend.repository.UserRepository;
import com.offlinepay.backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public UserResponse register(RegisterRequest req) {


        // check duplicate email
        if (userRepo.existsByEmail(req.getEmail())) {
            throw new RuntimeException("Email already exist");
        }


        //create User
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(
                passwordEncoder.encode(req.getPassword())
        );

        //saved
        User saved = userRepo.save(user);

        // return DTO
        return mapToResponse(saved);

    }

    private UserResponse mapToResponse(User user) {
        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setName(user.getName());
        res.setEmail(user.getEmail());
        res.setWalletBalance(user.getWalletBalance());
        return res;

    }

    public LoginResponse login(LoginRequest req) {
        User user = userRepo.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));


        if (!passwordEncoder.matches(
                req.getPassword(), user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        String token = jwtUtil.generateJwt(user.getEmail());

        LoginResponse res = new LoginResponse();
        res.setToken(token);
        res.setUserId(user.getId());
        res.setName(user.getName());
        res.setEmail(user.getEmail());
        return res;


    }
}
