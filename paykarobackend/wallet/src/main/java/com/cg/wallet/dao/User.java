package com.cg.wallet.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int id;
	private  String name;
	private String contact;
	private String emailId;
	private  String password;

}
