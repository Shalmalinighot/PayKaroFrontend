package com.cg.paykaro.usermicroservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.paykaro.usermicroservice.entity.UserTbl;
import com.cg.paykaro.usermicroservice.exception.UserNotFoundException;
import com.cg.paykaro.usermicroservice.repository.UserRepositroy;

@Service
public class UserService implements IUserService{

	@Autowired
	public UserRepositroy userRepository;
	@Override
	public String createUser(UserTbl user)
	{
		Optional<UserTbl> optionalUserTbl=userRepository.findByEmailId(user.getEmailId());
		if(optionalUserTbl.isEmpty()) {
				
		UserTbl newUser=userRepository.save(user);
		
		return "You have Registered Succesfully";
		
		}
		return "You have Already Register!! Please Login";
		
		
	}
	@Override
	public UserTbl login(String emailId, String password) {
		Optional<UserTbl> optionalUser=userRepository.findByEmailIdAndPassword(emailId, password);
		if(optionalUser.isEmpty())
		{
			throw new UserNotFoundException("Enter Valid EmailId & Password");
		}
		UserTbl user=optionalUser.get();
		return user;
	}
	
	
	@Override
	public UserTbl getUserById(int userId) 
	{
		
		Optional<UserTbl> userTbl=userRepository.findById(userId);
		if(userTbl.isEmpty())
		{
			return null;
		}
		UserTbl user=userTbl.get();
		return user;
	}

}
