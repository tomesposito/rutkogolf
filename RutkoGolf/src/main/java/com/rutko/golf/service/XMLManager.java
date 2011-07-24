package com.rutko.golf.service;

import com.rutko.golf.dao.xml.XMLDAO;

public class XMLManager {
	
	private XMLDAO dao ;
	
	public String fetchPageDataByName(String name){
		return dao.retrievePageByTitle(name) ;
	}

	public XMLDAO getDao() {
		return dao;
	}

	public void setDao(XMLDAO dao) {
		this.dao = dao;
	}

}
