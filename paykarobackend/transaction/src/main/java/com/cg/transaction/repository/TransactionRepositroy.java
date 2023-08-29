package com.cg.transaction.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.transaction.entity.Transaction;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepositroy extends JpaRepository<Transaction, Integer>  {
	
	Page<Transaction> findByUserId(int userId, Pageable pageable);
	Optional<List<Transaction>> findByUserId(int userId);

}
