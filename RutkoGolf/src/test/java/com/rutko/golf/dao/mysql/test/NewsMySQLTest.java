//package com.rutko.golf.dao.mysql.test;
//
//import java.util.List;
//
//import com.rutko.golf.dao.mysql.NewsMySQL;
//import com.rutko.golf.model.News;
//
//public class NewsMySQLTest extends AbstractLocalJUnitMySQLTest{
//	News news = new News() ;
//
//	public void testCreateNews(){
//		NewsMySQL dao = new NewsMySQL(super.getDataSource()) ;
//		news.setTitle("test1") ;
//		news.setContent("test content") ;
//		news.setPosted_by("espotw") ;
//		news = dao.createNews(news) ;
//		news = dao.getNewsByID(news.getId()) ;
//		System.out.println(news.toString()) ;
//		assertNotNull(news) ;
//	}
//	
//	public void testUpdateNews(){
//		NewsMySQL dao = new NewsMySQL(super.getDataSource()) ;
//		news.setId(5) ;
//		news.setTitle("test2") ;
//		news.setContent("test updated content") ;
//		news.setPosted_by("espotw") ;
//		news = dao.updateNews(news) ;
//		news = dao.getNewsByID(news.getId()) ;
//		System.out.println(news.toString()) ;
//		assertNotNull(news) ;
//	}
//	
//	public void testGetAllNews(){
//		NewsMySQL dao = new NewsMySQL(super.getDataSource()) ;
//		List<News> list = dao.getAllNews() ;
//		for(News n : list){
//			System.out.println(n.getTitle()) ;
//		}
//		assertNotNull(list) ;
//	}
//
//}
