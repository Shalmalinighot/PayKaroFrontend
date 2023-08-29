package com.cg.bankdetails.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bankdetails.dao.UserBankDetailsDao;
import com.cg.bankdetails.entity.UserBankDetails;
import com.cg.bankdetails.service.IUserBankDetailsService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/bankDetails")
public class UserBankDetailsController {
	
	@Autowired
	private IUserBankDetailsService iUserBankDetails;
	
	
	@PostMapping("/save")
	public ResponseEntity<UserBankDetails> addBankDetails( @RequestBody UserBankDetails userBankDetails )
	{
		 UserBankDetails newUserBankDetails = iUserBankDetails.saveBankDetails(userBankDetails);
		ResponseEntity<UserBankDetails> responseEntity = new ResponseEntity<>(newUserBankDetails, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/getByAccountNumber/{accountNo}")
	public ResponseEntity<UserBankDetailsDao> getByAccountNumber(@PathVariable("accountNo") long accountNumber)
	{
		UserBankDetailsDao userbankDetails=iUserBankDetails.getByAccountNumber(accountNumber);
		ResponseEntity<UserBankDetailsDao > responseEntity = new ResponseEntity<>(userbankDetails, HttpStatus.CREATED);
		return responseEntity;
	}
}	