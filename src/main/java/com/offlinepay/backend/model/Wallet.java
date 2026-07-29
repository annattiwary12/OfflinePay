package com.offlinepay.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name  = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @OneToOne
    @JoinColumn(name  = "user_id")
    private User user;

    private  double  balance =0.0;

    private LocalDateTime createdAt = LocalDateTime.now();

}
