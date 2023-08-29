package com.cg.transaction.dao;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDao {

	

	private int userId;
	private int senderWalletId;
	private int receiverWalletId;
	private double amount;
	
}
