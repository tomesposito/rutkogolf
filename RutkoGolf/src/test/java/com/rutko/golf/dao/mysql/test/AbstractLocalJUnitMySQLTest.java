package com.rutko.golf.dao.mysql.test;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import junit.framework.TestCase;

public abstract class AbstractLocalJUnitMySQLTest extends TestCase{
	BasicDataSource ds ;
	
	protected void setUp(){
		ds = new BasicDataSource() ;
		ds.setDriverClassName("com.mysql.jdbc.Driver") ;
		ds.setUrl("jdbc:mysql://localhost:3306/rutkogolf") ;
		ds.setUsername("espotw") ;
		ds.setPassword("fuckyou") ;
	}
	
	protected void tearDown(){
		
	}
	
	public DataSource getDataSource(){
		return this.ds ;
	}

}
