package com.rutko.golf.service;

import java.util.List;

import com.rutko.golf.dao.NewsDBDAO;
import com.rutko.golf.model.hibernate.News;

public class NewsManager {
	
	private NewsDBDAO dao ;
	
	public List<News> fetchAllNews(){
		return dao.getAllNews() ;
	}
	
	public News fetchNewsByID(Integer id){
		return dao.getNewsByID(id) ;
	}
	
	public News fetchCreateNews(News news){
		return dao.createNews(news) ;
	}
	
	public News fetchUpdateNews(News news){
		return dao.updateNews(news) ;
	}
	
	public Boolean fetchDeleteNews(News news){
		return dao.deleteNews(news) ;
	}

	public NewsDBDAO getDao() {
		return dao;
	}

	public void setDao(NewsDBDAO dao) {
		this.dao = dao;
	}

}
