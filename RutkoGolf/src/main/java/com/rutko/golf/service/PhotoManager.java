package com.rutko.golf.service;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import com.google.gdata.client.photos.*;
import com.google.gdata.data.photos.*;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

import com.rutko.golf.dao.PhotoDBDAO;
import com.rutko.golf.model.hibernate.Photo;

public class PhotoManager {
	
	private PhotoDBDAO dao ;
	
	private String id ;
	private String pass ;
	
	public UserFeed fetchAlbumNames(URL albumurl) throws AuthenticationException, IOException, ServiceException{
		UserFeed myUserFeed = this.getAuth().getFeed(albumurl, UserFeed.class) ;
		return myUserFeed ;
	}
	
	public AlbumFeed fetchAlbumPhotos(URL albumid) throws AuthenticationException, IOException, ServiceException{
		AlbumFeed feed = this.getAuth().getFeed(albumid, AlbumFeed.class) ;
		return feed ;
	}
	
	public List<Photo> fetchAllPhotos(){
		return dao.getAllPhotos() ;
	}
	
	public Photo fetchPhotoByID(Integer id){
		return dao.getPhotoByID(id) ;
	}
	
	public Photo fetchSavePhoto(Photo photo){
		return dao.savePhoto(photo) ;
	}
	
	public Boolean fetchDeletePhoto(Photo photo){
		return dao.deletePhoto(photo) ;
	}

	public void setDao(PhotoDBDAO dao) {
		this.dao = dao;
	}

	public PhotoDBDAO getDao() {
		return dao;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	

	private PicasawebService getAuth() throws AuthenticationException{
		PicasawebService myService = new PicasawebService("rutkoGolf") ;
		myService.setUserCredentials(id, pass) ;
		
		return myService ;
	}
	
}
