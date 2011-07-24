package com.rutko.golf.web.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.data.photos.UserFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import com.rutko.golf.service.NewsManager;
import com.rutko.golf.service.PhotoManager;

public class PhotoController extends AbstractController{
	
	private PhotoManager pmanager ;

	private String albumurl ;
	private String photourl ;
	private String jsonattrib ;
	
	private String newsattrib ;
	private NewsManager newsmanager ;
	
	public final ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute(this.getNewsattrib(), this.getNewsmanager().fetchAllNews()) ;
		StringBuffer sb = new StringBuffer() ;
		sb.append("{'albums':[{") ;
		UserFeed myUserFeed = null;
		try {
			myUserFeed = pmanager.fetchAlbumNames(new URL(albumurl));
		} catch (AuthenticationException e) {
			System.out.println(e.getMessage()) ;
		} catch (IOException e) {
			System.out.println(e.getMessage()) ;
		} catch (ServiceException e) {
			System.out.println(e.getMessage()) ;
		}
		for(AlbumEntry myAlbum : myUserFeed.getAlbumEntries()){
			sb.append("'title':'") ;
			sb.append(myAlbum.getTitle().getPlainText()) ;
//			sb.append("'") ;
			sb.append("', 'photos':[") ;
			try {
				AlbumFeed albumfeed = pmanager.fetchAlbumPhotos(
						new URL(photourl+StringUtils.substringAfterLast(myAlbum.getId(), "/"))) ;
				int i = 0 ;
				for(PhotoEntry photo : albumfeed.getPhotoEntries()){
					if(i>0){
						sb.append(",") ;
					}
					sb.append("{'title':'") ;
					sb.append(photo.getTitle().getPlainText()) ;
					sb.append("', 'caption':'") ;
					sb.append(photo.getDescription().getPlainText()) ;
					sb.append("', 'thumbnail':'") ;
					sb.append(photo.getMediaThumbnails().get(0).getUrl()) ;
					sb.append("', 'src':'") ;
					sb.append(photo.getMediaContents().get(0).getUrl()) ;
					sb.append("'}") ;
					i++ ;
				}
			} catch (AuthenticationException e) {
				System.out.println(e.getMessage()) ;
			} catch (MalformedURLException e) {
				System.out.println(e.getMessage()) ;
			} catch (IOException e) {
				System.out.println(e.getMessage()) ;
			} catch (ServiceException e) {
				System.out.println(e.getMessage()) ;
			}
			sb.append("]") ;
		}
		sb.append("}]}") ;
		request.setAttribute(jsonattrib, sb.toString()) ;
		return new ModelAndView(super.getSuccessView()) ;
	}
	
	public PhotoManager getPmanager() {
		return pmanager;
	}

	public void setPmanager(PhotoManager pmanager) {
		this.pmanager = pmanager;
	}

	public String getAlbumurl() {
		return albumurl;
	}

	public void setAlbumurl(String albumurl) {
		this.albumurl = albumurl;
	}

	public String getPhotourl() {
		return photourl;
	}

	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}

	public String getJsonattrib() {
		return jsonattrib;
	}

	public void setJsonattrib(String jsonattrib) {
		this.jsonattrib = jsonattrib;
	}
	
	public String getNewsattrib() {
		return newsattrib;
	}

	public void setNewsattrib(String newsattrib) {
		this.newsattrib = newsattrib;
	}

	public NewsManager getNewsmanager() {
		return newsmanager;
	}

	public void setNewsmanager(NewsManager newsmanager) {
		this.newsmanager = newsmanager;
	}

}
