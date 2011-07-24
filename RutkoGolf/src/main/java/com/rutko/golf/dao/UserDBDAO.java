package com.rutko.golf.dao;

import java.util.List;

import com.rutko.golf.model.hibernate.User;

public interface UserDBDAO {
	
	User checkAuth(String username, String password) ;
	
	User getUser(String username) ;
	
	List<User> getAllUsers() ;
	
	User addUser(User user) ;
	
	User updateUser(User user) ;

}
