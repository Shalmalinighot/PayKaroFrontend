package com.cg.paykaro.usermicroservice.service;

import com.cg.paykaro.usermicroservice.entity.UserTbl;

public interface IUserService {

	public String createUser(UserTbl user);

	public UserTbl login(String emailId, String password);

	public UserTbl getUserById(int userId);

}
