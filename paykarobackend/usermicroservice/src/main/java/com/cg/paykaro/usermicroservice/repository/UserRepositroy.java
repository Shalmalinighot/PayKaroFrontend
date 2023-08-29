package com.cg.paykaro.usermicroservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.paykaro.usermicroservice.entity.UserTbl;

@Repository
public interface UserRepositroy extends JpaRepository<UserTbl,Integer> {
	public Optional<UserTbl> findByEmailIdAndPassword(String emailId,String password);
	public Optional<UserTbl> findByEmailId(String emailId);

}
