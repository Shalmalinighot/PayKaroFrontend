package com.cg.wallet.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String msg)
	{
		super(msg);
	}

}
