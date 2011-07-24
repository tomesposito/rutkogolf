//package com.rutko.golf.dao.mysql;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.apache.log4j.Logger;
//
//import com.rutko.golf.dao.UserDBDAO;
//import com.rutko.golf.model.News;
//import com.rutko.golf.model.User;
//
//public class UserMySQL extends AbstractMySQL implements UserDBDAO{
//	private Logger log = Logger.getLogger(UserMySQL.class) ;
//	
//	public UserMySQL(){
//		super() ;
//	}
//	
//	public UserMySQL(DataSource ds){
//		super(ds) ;
//	}
//	
//	private static final String AUTHORIZE_USER = "SELECT * FROM USER WHERE username=? AND password=?" ;
//	private static final String SELECT_USER_BY_USERNAME = "SELECT * FROM USER WHERE username=?" ;
//	private static final String SELECT_ALL_USERS = "SELECT * FROM USER" ;
//	private static final String INSERT_USER = "INSERT INTO USER VALUES(?, ?, ?, ?, ?)" ;
//	private static final String UPDATE_USER = "UPDATE USER SET password=?, fname=?, lname=?. account_type=? WHERE username=?" ;
//	
//	public User checkAuth(String username, String password){
//		User user = null ;
//		ResultSet rs = null ;
//		Connection conn = null ;
//		PreparedStatement stmt = null ;
//		try{
//			conn = super.getConnection() ;
//			stmt = conn.prepareStatement(AUTHORIZE_USER) ;
//			stmt.setString(1, username) ;
//			stmt.setString(2, password) ;
//			rs = stmt.executeQuery() ;
//			if(rs.next()){
//				user = this.mapToUser(rs) ;
//			}
//		}catch(SQLException e){
//			System.out.println(e) ;
//			log.error(e) ;
//		}finally{
//			super.closeandcleanup(conn, rs, stmt) ;
//		}
//		return user ;
//	}
//	
//	public User getUser(String username){
//		User user = null ;
//		ResultSet rs = null ;
//		Connection conn = null ;
//		PreparedStatement stmt = null ;
//		try{
//			conn = super.getConnection() ;
//			stmt = conn.prepareStatement(SELECT_USER_BY_USERNAME) ;
//			stmt.setString(1, username) ;
//			rs = stmt.executeQuery() ;
//			if(rs.next()){
//				user = this.mapToUser(rs) ;
//			}
//		}catch(SQLException e){
//			System.out.println(e) ;
//			log.error(e) ;
//		}finally{
//			super.closeandcleanup(conn, rs, stmt) ;
//		}
//		return user ;
//	}
//	
//	public List<User> getAllUsers(){
//		List<User> list = new ArrayList<User>() ;
//		ResultSet rs = null ;
//		Connection conn = null ;
//		Statement stmt = null ;
//		try{
//			conn = super.getConnection() ;
//			stmt = conn.createStatement() ;
//			rs = stmt.executeQuery(SELECT_ALL_USERS) ;
//			if(rs.next()){
//				list.add(this.mapToUser(rs)) ;
//			}
//		}catch(SQLException e){
//			System.out.println(e) ;
//			log.error(e) ;
//		}finally{
//			super.closeandcleanup(conn, rs, stmt) ;
//		}
//		return list ;
//	}
//	
//	public User addUser(User user){
//		Connection conn = null ;
//		PreparedStatement stmt = null ;
//		try{
//			conn = super.getConnection() ;
//			stmt = conn.prepareStatement(INSERT_USER) ;
//			stmt.setString(1, user.getUsername()) ;
//			stmt.setString(2, user.getPassword()) ;
//			stmt.setString(3, user.getFname()) ;
//			stmt.setString(4, user.getLname()) ;
//			stmt.setInt(5, user.getAccount_type()) ;
//			stmt.executeUpdate() ;
//		}catch(SQLException e){
//			System.out.println(e) ;
//			log.error(e) ;
//		}finally{
//			super.closeandcleanup(conn, stmt) ;
//		}
//		return user ;
//	}
//	
//	public User updateUser(User user){
//		Connection conn = null ;
//		PreparedStatement stmt = null ;
//		try{
//			conn = super.getConnection() ;
//			stmt = conn.prepareStatement(UPDATE_USER) ;
//			stmt.setString(1, user.getPassword()) ;
//			stmt.setString(2, user.getFname()) ;
//			stmt.setString(3, user.getLname()) ;
//			stmt.setInt(4, user.getAccount_type()) ;
//			stmt.setString(5, user.getUsername()) ;
//			stmt.executeUpdate() ;
//		}catch(SQLException e){
//			System.out.println(e) ;
//			log.error(e) ;
//		}finally{
//			super.closeandcleanup(conn, stmt) ;
//		}
//		return user ;
//	}
//	
//	private User mapToUser(ResultSet rs) throws SQLException{
//		User vo = new User() ;
//		
//		vo.setUsername(rs.getString("username")) ;
//		vo.setFname(rs.getString("fname")) ;
//		vo.setLname(rs.getString("lname")) ;
//		vo.setAccount_type(rs.getInt("account_type")) ;
//		
//		return vo ;
//	}
//
//}
