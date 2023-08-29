package com.cg.transaction.exception;

public class WalletNotFoundException extends RuntimeException {

	public WalletNotFoundException(String msg)
	{
		super(msg);
	}
}
