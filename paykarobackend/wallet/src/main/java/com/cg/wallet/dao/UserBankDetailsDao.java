package com.cg.wallet.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBankDetailsDao {

	private long accountNumber;
	private String accountHolderName;
    private String contactNumber;
	private int userId;
}
