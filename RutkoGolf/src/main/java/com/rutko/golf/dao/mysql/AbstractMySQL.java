package com.rutko.golf.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.rutko.golf.context.ContextUtil;

public abstract class AbstractMySQL {
	private Logger log = Logger.getLogger(AbstractMySQL.class) ;
	
	private DataSource localDS ;
	
	protected AbstractMySQL(){
		try{
			this.localDS = ContextUtil.getRutkoDataSource() ;
		}catch(NamingException e){
			log.error(e) ;
		}
	}
	
	protected AbstractMySQL(DataSource ds){
		this.localDS = ds ;
	}
	
	protected final DataSource getDS(){
		return this.localDS ;
	}
	
	protected Connection getConnection() throws SQLException{
		return this.getDS().getConnection() ;
	}
	
	protected void closeandcleanup(Connection conn, ResultSet rs, PreparedStatement stmt){
		if(rs != null){
			try {
				rs.close() ;
			} catch (SQLException e) {
				 log.error(e) ;
			}
		}
		if(stmt != null){
			try {
				stmt.close() ;
			} catch (SQLException e) {
				 log.error(e) ;
			}
		}
		if(conn != null){
			try {
				conn.close() ;
			} catch (SQLException e) {
				log.error(e) ;
			}
		}
	}
	
	protected void closeandcleanup(Connection conn, PreparedStatement stmt){
		if(stmt != null){
			try {
				stmt.close() ;
			} catch (SQLException e) {
				 log.error(e) ;
			}
		}
		if(conn != null){
			try {
				conn.close() ;
			} catch (SQLException e) {
				log.error(e) ;
			}
		}
	}
	
	protected void closeandcleanup(Connection conn, ResultSet rs, Statement stmt){
		if(rs != null){
			try {
				rs.close() ;
			} catch (SQLException e) {
				 log.error(e) ;
			}
		}
		if(stmt != null){
			try {
				stmt.close() ;
			} catch (SQLException e) {
				 log.error(e) ;
			}
		}
		if(conn != null){
			try {
				conn.close() ;
			} catch (SQLException e) {
				log.error(e) ;
			}
		}
	}
	

}
