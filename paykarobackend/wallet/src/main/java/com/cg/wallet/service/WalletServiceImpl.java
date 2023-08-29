package com.cg.wallet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.wallet.dao.User;
import com.cg.wallet.dao.UserBankDetailsDao;
import com.cg.wallet.dao.WalletDao;
import com.cg.wallet.dao.WalletDao2;
import com.cg.wallet.entity.Wallet;
import com.cg.wallet.exception.UserNotFoundException;
import com.cg.wallet.repository.WalletRepository;

@Service
public class WalletServiceImpl implements IWalletService {

	@Autowired
	public WalletRepository walletRepository;

	@Autowired
	public RestTemplate restTemplate;

	@Override
	public String addWallet(WalletDao walletDao) {

		
		Optional<Wallet> optionalWallet = walletRepository.findByUserId(walletDao.getUserId());
		
		//check user Is valid for operation or not
		User user = restTemplate.getForObject("http://USER-MODULE/user/getuserbyid/" +walletDao.getUserId(), User.class);
		
		
		
		UserBankDetailsDao userBankDeatailsDao = restTemplate.getForObject(
				"http://BANKDETAILS-MODULE/bankDetails/getByAccountNumber/" +walletDao.getAccountNumber(),UserBankDetailsDao.class);
		

		if(user==null && userBankDeatailsDao==null)
		{
			return "Enter Valid user id/Bank Account Number";
			
		}
		else
		{
					if(optionalWallet.isPresent())
					{
					      Wallet newWallet=optionalWallet.get();
					      
					if(walletDao.getUserId()==userBankDeatailsDao.getUserId())
					{
							double amount=newWallet.getBalance() + walletDao.getAmount();
							newWallet.setBalance(amount);
							Wallet wallet1 = walletRepository.save(newWallet);
						   return "Amount Added to wallet Succesfully !! Your Current Wallet Amount is "+amount;
					}
					else
						return "Enter valid Bank details ";
				}
					
					//if optional.is Empty 
				else
				{
					if(walletDao.getAccountNumber()==userBankDeatailsDao.getAccountNumber()) {
						Wallet wallet = new Wallet();
						wallet.setUserId(walletDao.getUserId());
						wallet.setBalance(walletDao.getAmount());
						 walletRepository.save(wallet);
						return "Amount Added to wallet Succesfully !! Your Current Wallet Amount is "+walletDao.getAmount();
					
						
					}
					
					else
					{
					return "Enter valid Bank details ";
					}
				}
					
			}
		
		
	}
	
	
	

	public Wallet checkWalletAmount(int userId) {
		
		Optional<Wallet> optionalWallet = walletRepository.findByUserId(userId);
		if(optionalWallet.isEmpty())
		{
			throw new UserNotFoundException("You have Not Register For Wallet");
		}
		
		return optionalWallet.get();
	}

	@Override
	public Wallet getByWalletId(int walletId) {
		
		Optional<Wallet> optionalWallet=walletRepository.findById(walletId);
		if(optionalWallet.isEmpty())
		{
		return null;
		}
		Wallet wallet=optionalWallet.get();
		
		return wallet;
	}

	@Override
	public String updateWalletAmount(WalletDao2 wallet) {
	    int userId = wallet.getUserId();

	    Optional<Wallet> optionalWallet = walletRepository.findByUserId(userId);
	    if (optionalWallet.isEmpty()) {
	        return "User Not valid !!! Failed Update";
	    }

	    Wallet existingWallet = optionalWallet.get();
	    existingWallet.setBalance(wallet.getBalance());

	    walletRepository.save(existingWallet); // Save the updated wallet information

	    return "Thank You !! Your current Balance is " + existingWallet.getBalance();
	}


}