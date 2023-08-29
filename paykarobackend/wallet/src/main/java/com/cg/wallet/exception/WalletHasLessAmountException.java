 package com.cg.wallet.exception;

public class WalletHasLessAmountException extends RuntimeException {
	
public WalletHasLessAmountException(String str)
{
	super(str);
}
}
