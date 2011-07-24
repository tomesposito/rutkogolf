//package com.rutko.golf.dao.mysql.test;
//
//import java.util.List;
//
//import com.rutko.golf.dao.mysql.UserMySQL;
//import com.rutko.golf.model.User;
//
//public class UserMySQLTest extends AbstractLocalJUnitMySQLTest{
//	
//	public void testCreateUser(){
//		UserMySQL dao = new UserMySQL(super.getDataSource()) ;
//		User user = new User() ;
//		User user1 = new User() ;
//		user.setUsername("espotw") ;
//		user.setPassword("test") ;
//		user.setFname("Tom") ;
//		user.setLname("Esposito") ;
//		user.setAccount_type(0) ;
//		
//		user1 = dao.addUser(user) ;
//		
//		System.out.println(user1.getUsername()) ;
//		
//		assertNotNull(user1) ;
//		
//	}
//	
//	public void testFindAllUsers(){
//		UserMySQL dao = new UserMySQL(super.getDataSource()) ;
//		List<User> list = dao.getAllUsers() ;
//		for(User u : list){
//			System.out.println(u.getUsername()) ;
//			System.out.println(u.getFname()) ;
//			System.out.println(u.getLname()) ;
//		}
//		assertNotNull(list) ;
//	}
//
//}
