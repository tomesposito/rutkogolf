package com.rutko.golf.service;

import java.util.List;

import com.rutko.golf.dao.UserDBDAO;
import com.rutko.golf.model.hibernate.User;

public class UserManager {
	
	private UserDBDAO dao ;
	
	public UserDBDAO getDao() {
		return dao;
	}

	public void setDao(UserDBDAO dao) {
		this.dao = dao;
	}

	public List<User> fetchAllUsers(){
		return dao.getAllUsers() ;
	}
	
	public User fetchChechAuth(String username, String password){
		return dao.checkAuth(username, password) ;
	}
	
	public User fetchGetUser(String username){
		return dao.getUser(username) ;
	}
	
	public User fetchAddUser(User user){
		return dao.addUser(user) ;
	}
	
	public User fetchUpdateUser(User user){
		return dao.updateUser(user) ;
	}

}
