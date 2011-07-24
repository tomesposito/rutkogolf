package com.rutko.golf.dao.hibernate;

import java.util.List;

import com.rutko.golf.dao.UserDBDAO;
import com.rutko.golf.model.hibernate.User;

public class UserHibernate extends HibernateDAO<User, Integer> implements UserDBDAO{
	
	public UserHibernate(){
		super(User.class) ;
	}
	
	public User checkAuth(String username, String password){
		if(super.checkExist("select count(*) from User where username='"+username+"' and password='"+password+"'")){
			return super.getObjectByPID(User.class, username) ;
		}
		return null ;
	}
	
	public User getUser(String username){
		return super.getObjectByPID(User.class, username) ;
	}
	
	public List<User> getAllUsers(){
		return super.findAll() ;
	}
	
	public User addUser(User user){
		super.save(user) ;
		return user ;
	}
	
	public User updateUser(User user){
		super.save(user) ;
		return user ;
	}

}
