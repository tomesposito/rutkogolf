package com.rutko.golf.context;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class ContextUtil {
	private Logger log = Logger.getLogger(ContextUtil.class) ;
	
	private static InitialContext initialContext ;
	
	private static final String DATASOURCE	= "jdbc/rutkogolfDS" ;
	private static final String PHOTODIR	= "photos.dir" ;
	
	private static volatile ContextUtil instance ;
	private String photodir 	= null;
	
	public synchronized static ContextUtil getContextUtil(){
		if(instance == null){
			synchronized (ContextUtil.class) {
				if(instance == null ){
					instance = new ContextUtil() ;
				}
			}
		}
		return instance ;
	}
	
	private ContextUtil(){
		try{
			initialContext = new InitialContext() ;
		}catch(NamingException e){
			log.error(e) ;			
		}
	}
	
	private DataSource getDataSource() throws NamingException{
		Object objref = null ;
		objref = initialContext.lookup(DATASOURCE) ;
		return (DataSource) PortableRemoteObject.narrow(objref, DataSource.class) ;
	}
	
	public static DataSource getRutkoDataSource() throws NamingException{
		return ContextUtil.getContextUtil().getDataSource() ;
	}
	
	public String getPhotoDir(){
		if(this.photodir == null){
			try{
				this.photodir = (String) this.initialContext.lookup(PHOTODIR) ;
			}catch (Exception e) {
				log.error(e) ;
			}
		}
		return this.photodir ;
	}

}
