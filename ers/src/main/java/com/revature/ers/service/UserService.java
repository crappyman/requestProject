package com.revature.ers.service;

import java.util.List;

import com.revature.ers.entity.UsersEntity;
import com.revature.ers.pojo.UserPojo;



public interface UserService {
	
	UsersEntity getUserById(int id);
	
	List<UserPojo> fetchAllAccounts();
	
	UserPojo fetchAAccount(int userId);
	
	UserPojo updateAccount(UserPojo userpojo);
	
	UserPojo login(UserPojo user);
}
