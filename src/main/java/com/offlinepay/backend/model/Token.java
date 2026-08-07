package com.offlinepay.backend.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name ="tokens")
public class Token {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

    private Long  id;

    @ManyToOne
    @JoinColumn(name = "wallet_id")

    private Wallet wallet;

    @Column(unique = true)
    private  String tokenValue;

    private double  amount;

    private  String status;

    private LocalDateTime  createdAt =  LocalDateTime.now();

    private  LocalDateTime expiresAt;
}
