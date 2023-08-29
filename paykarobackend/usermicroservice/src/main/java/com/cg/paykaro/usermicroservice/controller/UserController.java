package com.cg.paykaro.usermicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.paykaro.usermicroservice.entity.UserTbl;
import com.cg.paykaro.usermicroservice.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:3000/")
public class UserController {
	
	@Autowired
	public IUserService iUserService;
	
	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody UserTbl user)
	{
		String str=iUserService.createUser(user);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(str, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getuserbyid/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable("userId") int userId)
	{
		UserTbl user=iUserService.getUserById(userId);
		ResponseEntity<UserTbl> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
		return responseEntity;
		
	}
	
	
	@GetMapping("/login")
	public ResponseEntity<?> userLogin(@RequestParam String emailId,@RequestParam String password)
	{
		
		UserTbl newUser =iUserService.login(emailId,password);
		ResponseEntity<UserTbl> responseEntity = new ResponseEntity<>(newUser, HttpStatus.OK);
		return responseEntity;
}

}
