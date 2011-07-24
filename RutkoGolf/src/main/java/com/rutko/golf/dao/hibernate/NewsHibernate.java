package com.rutko.golf.dao.hibernate;

import java.util.List;

import com.rutko.golf.dao.NewsDBDAO;
import com.rutko.golf.model.hibernate.News;

public class NewsHibernate extends HibernateDAO<News, Integer> implements NewsDBDAO{
	
	public NewsHibernate(){
		super(News.class) ;
	}
	
	public List<News> getAllNews(){
		return super.findAllOrderDesc("timestamp") ;
	}
	
	public News getNewsByID(Integer id){
		return super.getObjectByPID(News.class, id) ;
	}
	
	public News createNews(News news){
		save(news) ;
		return news ;
	}
	
	public News updateNews(News news){
		save(news) ;
		return news ;
	}
	
	public Boolean deleteNews(News news){
		super.delete(news) ;
		if(this.getNewsByID(news.getId()) != null){
			return false ;
		}else{
			return true ;
		}
	}

}
