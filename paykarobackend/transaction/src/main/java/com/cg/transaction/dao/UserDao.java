package com.cg.transaction.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDao {
	private int id;
	private  String name;
	private String contact;
	private String emailId;
	private  String password;

}
