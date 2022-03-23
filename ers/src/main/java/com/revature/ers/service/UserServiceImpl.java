package com.revature.ers.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.ers.dao.UserDao;
import com.revature.ers.entity.RequestEntity;
import com.revature.ers.entity.UsersEntity;
import com.revature.ers.pojo.UserPojo;



@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
	

	public UserServiceImpl() {
		//userDao = new UserDaoImpl();
	}

	
	@Override
	public UsersEntity getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getById(id);
	}
	
	@Override
	public List<UserPojo> fetchAllAccounts() {
		List<UserPojo> allAccount = new ArrayList<UserPojo>();
		List<UsersEntity> alluserEntity = userDao.findAll();
		for(UsersEntity userEntity: alluserEntity) {
			// Pass the userEntity to your UserPojo
			//Controller you will return your POJO 
			//(int userID, String username, String password, String fullName, String email, int role_id)
			UserPojo userPojo = new UserPojo(userEntity.getUserId(), userEntity.getUserName(), userEntity.getPassword(), userEntity.getFullname(), userEntity.getEmail(), userEntity.getRole());
			
			allAccount.add(userPojo);
		}
		return allAccount;
	}
	

	@Override
	public UserPojo fetchAAccount(int userId) {
		Optional<UsersEntity> optional =  userDao.findById(userId);
		UserPojo userPojo = null;
		if(optional.isPresent()) {
			UsersEntity userEntity = optional.get();
			userPojo = new UserPojo(userEntity.getUserId(), userEntity.getUserName(), userEntity.getPassword(), userEntity.getFullname(), userEntity.getEmail(), userEntity.getRole());
		}
		return userPojo;
	}

	@Override
	public UserPojo updateAccount(UserPojo userpojo) {
		//int userID, String username, String password, String fullName, String email, int role_id
		UsersEntity userEntity = new UsersEntity(userpojo.getUserID(), userpojo.getUsername(), userpojo.getPassword(), userpojo.getFullName(), userpojo.getEmail(), userpojo.getRole_id());
		userDao.save(userEntity);
		return userpojo;
	}

	@Override
	public UserPojo login(UserPojo user) {
		//Search for a user that has the same username that is given in the POJO
		System.out.println(user.getUsername());
		UsersEntity optional = userDao.findByUserName(user.getUsername());
		
		UserPojo userPojo = new UserPojo();
		System.out.println(optional);
		if(optional != null ) {
			UsersEntity userEntity = optional;
			if(user.getPassword().equals(userEntity.getPassword())) {
			 userPojo = new UserPojo(userEntity.getUserId(), userEntity.getUserName(), userEntity.getPassword(), userEntity.getFullname(), userEntity.getEmail(), userEntity.getRole());
			}
		}
		return userPojo;
	}


}
