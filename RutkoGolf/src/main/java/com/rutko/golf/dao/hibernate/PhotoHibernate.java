package com.rutko.golf.dao.hibernate;

import java.util.List;

import com.rutko.golf.dao.PhotoDBDAO;
import com.rutko.golf.model.hibernate.Photo;

public class PhotoHibernate extends HibernateDAO<Photo, Integer> implements PhotoDBDAO {

	public PhotoHibernate(){
		super(Photo.class) ;
	}
	
	public List<Photo> getAllPhotos(){
		return super.findAllOrderDesc("timestamp") ;
	}
	
	public Photo getPhotoByID(Integer id){
		return super.getObjectByPID(Photo.class, id) ;
	}
	
	public Photo savePhoto(Photo photo){
		super.save(photo) ;
		return photo ;
	}
	
	public Boolean deletePhoto(Photo photo){
		super.delete(photo) ;
		if(this.getPhotoByID(photo.getId()) != null){
			return false ;
		}else{
			return true ;
		}
	}
}
