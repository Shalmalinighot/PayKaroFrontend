package com.cg.paykaro.usermicroservice.exception;


public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException(String msg)
	{
		super(msg);
	}

}
