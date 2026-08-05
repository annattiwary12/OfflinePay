package com.offlinepay.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name  = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private  User sender;

    @ManyToOne
    @JoinColumn(name  = "receiver_id")
    private  User  receiver;


    private  double amount;


    private   String status;

    private LocalDateTime createdAt = LocalDateTime.now();

}
