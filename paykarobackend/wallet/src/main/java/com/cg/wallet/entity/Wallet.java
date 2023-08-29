package com.cg.wallet.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int walletId;

	private int userId;

	private double balance;

}
