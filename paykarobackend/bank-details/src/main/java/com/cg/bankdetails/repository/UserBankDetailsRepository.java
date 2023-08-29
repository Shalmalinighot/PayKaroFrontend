package com.cg.bankdetails.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.bankdetails.entity.UserBankDetails;



@Repository
public interface UserBankDetailsRepository extends JpaRepository<UserBankDetails,Integer> {
	
	 Optional<UserBankDetails> findByAccountNumber(Long accountNumber);
	 
}

