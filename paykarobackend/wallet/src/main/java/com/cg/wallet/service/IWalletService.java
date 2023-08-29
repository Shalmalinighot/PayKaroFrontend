package com.cg.wallet.service;

import com.cg.wallet.dao.WalletDao;
import com.cg.wallet.dao.WalletDao2;
import com.cg.wallet.entity.Wallet;

public interface IWalletService {

	public String addWallet(WalletDao walletDao);
	
	public Wallet checkWalletAmount(int userId);

	public Wallet getByWalletId(int walletId);

	public String updateWalletAmount(WalletDao2 wallet);
}
