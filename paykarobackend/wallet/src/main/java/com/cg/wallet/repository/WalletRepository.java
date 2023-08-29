package com.cg.wallet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.wallet.entity.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Integer> {

	Optional<Wallet> findByUserId(int userId );
}
