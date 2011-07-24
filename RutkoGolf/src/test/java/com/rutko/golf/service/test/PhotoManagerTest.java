package com.rutko.golf.service.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang.StringUtils;

import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.data.photos.UserFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import com.rutko.golf.service.PhotoManager;

import junit.framework.TestCase;

public class PhotoManagerTest extends TestCase{
	
	public void testFetchAlbumNames(){
		PhotoManager manager = new PhotoManager() ;
		manager.setId("rutkogolf@yahoo.com") ;
		manager.setPass("rutkowski") ;
		StringBuffer sb = new StringBuffer() ;
		sb.append("{'albums':[") ;
		UserFeed myUserFeed = null;
		try {
			myUserFeed = manager.fetchAlbumNames(new URL("https://picasaweb.google.com/data/feed/api/user/117892625446591382126?kind=album"));
		} catch (AuthenticationException e) {
			System.out.println(e.getMessage()) ;
		} catch (IOException e) {
			System.out.println(e.getMessage()) ;
		} catch (ServiceException e) {
			System.out.println(e.getMessage()) ;
		}
		for(AlbumEntry myAlbum : myUserFeed.getAlbumEntries()){
			System.out.println("Title: "+myAlbum.getTitle().getPlainText()) ;
			sb.append("'title':'") ;
			sb.append(myAlbum.getTitle().getPlainText()) ;
			sb.append("', 'photos':[") ;
			try {
				AlbumFeed albumfeed = manager.fetchAlbumPhotos(
						new URL("https://picasaweb.google.com/data/feed/api/user/117892625446591382126/albumid/"+StringUtils.substringAfterLast(myAlbum.getId(), "/"))) ;
				int i = 0 ;
				for(PhotoEntry photo : albumfeed.getPhotoEntries()){
					if(i>0){
						sb.append(",") ;
					}
					sb.append("{'title':'") ;
					sb.append(photo.getTitle().getPlainText()) ;
					sb.append("', 'thumbnail':'") ;
					sb.append(photo.getMediaThumbnails().get(0).getUrl()) ;
					sb.append("', 'src':'") ;
					sb.append(photo.getMediaContents().get(0).getUrl()) ;
					sb.append("'}") ;
					System.out.println("\tPhoto title: "+photo.getTitle().getPlainText()) ;
					System.out.println("\tPhoto description: "+photo.getDescription().getPlainText()) ;
					System.out.println("\tMedia Thumbnail: " + photo.getMediaThumbnails().get(0).getUrl());
					System.out.println("\tMedia Content: " + photo.getMediaContents().get(0).getUrl());
					System.out.println("\n");
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
		}
		sb.append("]]} ;") ;
//		System.out.println(sb.toString()) ;
		assertNotNull(myUserFeed) ;
	}

}
