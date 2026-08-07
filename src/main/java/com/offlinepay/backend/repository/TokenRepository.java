package com.offlinepay.backend.repository;

import com.offlinepay.backend.model.Token;
import com.offlinepay.backend.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository  extends JpaRepository<Token, Long> {

    Optional<Token> findByTokenValue(String tokenValue);
    List<Token> findByWallet(Wallet wallet);
}
