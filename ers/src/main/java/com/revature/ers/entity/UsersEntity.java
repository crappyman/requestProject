package com.revature.ers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="user_id")
    private int userId;

    @Column(name="username", unique = true, nullable = false)
    private String userName;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="full_name", nullable = false)
    private String fullname;

    @Column(name="email", unique = true, nullable = false)
    private String email;


    @Column(name="role_id",  nullable = false)
    
    private int role;


    
	public UsersEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UsersEntity(int userId, String userName, String password, String fullname, String email, 
			int role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.role = role;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


    
}