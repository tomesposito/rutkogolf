package com.rutko.golf.dao.xml.test;

import com.rutko.golf.dao.xml.XMLDAO;

import junit.framework.TestCase;

public class XMLDAOTest extends TestCase{
	
	public void testRetrievePageByTitle(){
		XMLDAO dao = new XMLDAO() ;
		dao.setFilepath("dist/pageData.xml") ;
		String str = null ;
		str = dao.retrievePageByTitle("home") ;
		System.out.println(str) ;
		assertNotNull(str) ;
	}

}
