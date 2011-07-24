package com.rutko.golf.dao.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
 
	
	
    private static final SessionFactory sessionFactory;
    
    static {
    	
    	Logger log = Logger.getLogger(HibernateUtil.class) ;
    	
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            
         } catch (Exception ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed. " + ex);
            log.error(ex) ;
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
	public static Session beginTransaction() {
		Session hibernateSession;
		hibernateSession = HibernateUtil.getSessionFactory().getCurrentSession();
		hibernateSession.beginTransaction();
		return hibernateSession;
	}
	
	public static void clearSession() {
		HibernateUtil.beginTransaction().clear() ;
	}



}