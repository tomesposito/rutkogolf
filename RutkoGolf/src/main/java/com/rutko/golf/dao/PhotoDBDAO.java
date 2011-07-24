package com.rutko.golf.dao;

import java.util.List;

import com.rutko.golf.model.hibernate.Photo;

public interface PhotoDBDAO {
	
	List<Photo> getAllPhotos() ;
	
	Photo getPhotoByID(Integer id) ;
	
	Photo savePhoto(Photo photo) ;
	
	Boolean deletePhoto(Photo photo) ;

}
