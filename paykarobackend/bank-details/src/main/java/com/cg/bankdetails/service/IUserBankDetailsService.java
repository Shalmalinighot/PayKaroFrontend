package com.cg.bankdetails.service;

import java.util.List;

import com.cg.bankdetails.dao.UserBankDetailsDao;
import com.cg.bankdetails.entity.UserBankDetails;



public interface IUserBankDetailsService
{
	
	
	public UserBankDetails saveBankDetails(UserBankDetails bankDetails) ;
	
	
	public List<UserBankDetails> getAllBankDetails();


	public UserBankDetailsDao getByAccountNumber(long accountNumber);
	
}