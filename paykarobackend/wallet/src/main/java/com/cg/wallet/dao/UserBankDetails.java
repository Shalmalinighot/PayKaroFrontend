package com.cg.wallet.dao;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserBankDetails {
	
	@Column(unique=true)
	private long accountNumber;
	private String accountHolderName;
	private String bankName;
	private String ifscCode;
    private String contactNumber;
	private int userId;
  
   
	

}
	
	


