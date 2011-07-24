//package com.rutko.golf.dao.mysql;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.sql.DataSource;
//
//import org.apache.log4j.Logger;
//
//import com.rutko.golf.dao.NewsDBDAO;
//import com.rutko.golf.model.News;
//
//public class NewsMySQL extends AbstractMySQL implements NewsDBDAO{
//	private Logger log = Logger.getLogger(NewsMySQL.class) ;
//	
//	public NewsMySQL(DataSource ds){
//		super(ds) ;
//	}
//	
//	public NewsMySQL(){
//		super() ;
//	}
//	
//	private static final String SELECT_ALL_NEWS = "SELECT * FROM NEWS" ;
//	private static final String SELECT_NEWS_BY_ID = "SELECT * FROM NEWS WHERE idnews=?" ;
//	private static final String SELECT_COUNT = "SELECT max(idnews) FROM NEWS" ;
//	private static final String INSERT_NEWS = "INSERT INTO NEWS VALUES(?, ?, ?, ?, current_timestamp)" ;
//	private static final String UPDATE_NEWS = "UPDATE NEWS SET title=?, content=?, posted_by=?, timestamp=current_timestamp WHERE idnews=?" ;
//	private static final String DELETE_NEWS_BY_ID = "DELETE FROM NEWS WHERE IDNEWS =?" ;
//	
//	public List<News> getAllNews(){
//		List<News> list = new ArrayList<News>() ;
//		ResultSet rs = null ;
//		Connection conn = null ;
//		Statement stmt = null ;
//		try{
//			conn = super.getConnection() ;
//			stmt = conn.createStatement() ;
//			rs = stmt.executeQuery(SELECT_ALL_NEWS) ;
//			while(rs.next()){
//				list.add(this.mapToNews(rs)) ;
//			}
//		}catch(SQLException e){
//			System.out.println(e) ;
//			log.error(e) ;
//		}finally{
//			super.closeandcleanup(conn, rs, stmt) ;
//		}
//		return list ;
//	}
//	
//	public News getNewsByID(Integer id){
//		ResultSet rs = null ;
//		Connection conn = null ;
//		PreparedStatement stmt = null ;
//		News news = null ;
//		try{
//			conn = super.getConnection() ;
//			stmt = conn.prepareStatement(SELECT_NEWS_BY_ID) ;
//			stmt.setInt(1, id) ;
//			rs = stmt.executeQuery() ;
//			if(rs.next()){
//				news = this.mapToNews(rs) ;
//			}
//		}catch(SQLException e){
//			System.out.println(e) ;
//			log.error(e) ;
//		}finally{
//			super.closeandcleanup(conn, rs, stmt) ;
//		}
//		return news ;
//	}
//	
//	public News createNews(News news){
//		Connection conn = null ;
//		PreparedStatement stmt = null ;
//		try{
//			conn = super.getConnection() ;
//			stmt = conn.prepareStatement(INSERT_NEWS) ;
//			news.setId(this.getCount(conn)+1) ;
//			stmt.setInt(1, news.getId()) ;
//			stmt.setString(2, news.getTitle()) ;
//			stmt.setString(3, news.getContent()) ;
//			stmt.setString(4, news.getPosted_by()) ;
//			stmt.executeUpdate() ;
//		}catch(SQLException e){
//			System.out.println(e) ;
//			log.error(e) ;
//		}finally{
//			super.closeandcleanup(conn, stmt) ;
//		}
//		return news ;
//	}
//	
//	public News updateNews(News news){
//		Connection conn = null ;
//		PreparedStatement stmt = null ;
//		try{
//			conn = super.getConnection() ;
//			stmt = conn.prepareStatement(UPDATE_NEWS) ;
//			stmt.setString(1, news.getTitle()) ;
//			stmt.setString(2, news.getContent()) ;
//			stmt.setString(3, news.getPosted_by()) ;
//			stmt.setInt(4, news.getId()) ;
//			stmt.executeUpdate() ;
//		}catch(SQLException e){
//			System.out.println(e) ;
//			log.error(e) ;
//		}finally{
//			super.closeandcleanup(conn, stmt) ;
//		}
//		return news ;
//	}
//	
//	public Boolean deleteNews(News news){
//		ResultSet rs = null ;
//		Connection conn = null ;
//		PreparedStatement stmt = null ;
//		try{
//			conn = super.getConnection() ;
//			stmt = conn.prepareStatement(DELETE_NEWS_BY_ID) ;
//			stmt.setInt(1, news.getId()) ;
//			stmt.executeUpdate() ;
//		}catch(SQLException e){
//			System.out.println(e) ;
//			log.error(e) ;
//			return false ;
//		}finally{
//			super.closeandcleanup(conn, rs, stmt) ;
//		}
//		return true ;
//	}
//	
//	private Integer getCount(Connection conn){
//		ResultSet rs = null ;
//		Statement stmt = null ;
//		try{
//			stmt = conn.createStatement() ;
//			rs = stmt.executeQuery(SELECT_COUNT) ;
//			if(rs.next()){
//				return rs.getInt(1) ;
//			}
//		}catch(SQLException e){
//			log.error(e) ;
//		}
//		return null ;
//	}
//	
//	private final News mapToNews(ResultSet rs) throws SQLException{
//		News vo = new News() ;
//		
//		vo.setId(rs.getInt("idnews")) ;
//		vo.setTitle(rs.getString("title")) ;
//		vo.setContent(rs.getString("content")) ;
//		vo.setPosted_by(rs.getString("posted_by")) ;
//		vo.setTimestamp(rs.getDate("timestamp")) ;
//		
//		return vo ;
//	}
//
//}
