package com.rutko.golf.dao;

import java.util.List;

import com.rutko.golf.model.hibernate.News;

public interface NewsDBDAO {
	
	List<News> getAllNews() ;
	
	News getNewsByID(Integer id) ;
	
	News createNews(News news) ;
	
	News updateNews(News news) ;
	
	Boolean deleteNews(News news) ;

}
