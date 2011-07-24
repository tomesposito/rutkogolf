package com.rutko.golf.common;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CacheManager {
	
	//set the timeout to 2 minutes
	private static final long timeToLive = (120 * 1000);
	//set map variables (static to hold state)
	private static Map<String, Date> timeSet = new HashMap<String, Date>() ;
	private static Map<String, Object> object = new HashMap<String, Object>() ;
	
	
	//constructor to create new singleton objects
	private CacheManager(){}
	
	/**
	 * Aug 26, 2010
	 * 
	 * @author ESPOTW
	 * 
	 * This method returns the singleton object of this class 
	 *
	 * @return EAMCacheManager
	 */
	public static CacheManager getMappedCacheManager(){
		return CacheManagerHolder.instance ;
	}
	//creates the singleton of this class
	private static class CacheManagerHolder{
		private static CacheManager instance = new CacheManager() ;
	}
	
	/**
	 * Aug 26, 2010
	 * 
	 * @author ESPOTW
	 *
	 * This method checks if the cached item currently exists 
	 *
	 * @param key
	 * @return Boolean
	 */
	public Boolean cacheExists(String key){
		if(object.containsKey(key) && timeSet.containsKey(key)){
			if((now().getTime() - timeSet.get(key).getTime()) < timeToLive){
				return true ;
			}else{
				object.remove(key) ;
				timeSet.remove(key) ;
				return false ;
			}
		}else{
			return false ;
		}
	}
	
	/**
	 * Aug 26, 2010
	 * 
	 * @author ESPOTW
	 *
	 * Add an item to the cache
	 *
	 * @param key
	 * @param object
	 * @return void
	 */
	public void addItem(String key, Object obj){
		timeSet.put(key, now()) ;
		object.put(key, obj) ;
	}
	
	
	/**
	 * Aug 26, 2010
	 * 
	 * @author ESPOTW
	 *
	 * Get an item from the cache
	 *
	 * @param key
	 * @return object
	 */
	public Object getItem(String key){
		return object.get(key) ;
	}
	
	/**
	 * Aug 26, 2010
	 * 
	 * @author ESPOTW
	 *
	 * Returns the time (in seconds) left on the cache before it expires
	 *
	 * @param key
	 * @return long
	 */
	public long timeToExpire(String key){
		return ((timeToLive - (now().getTime() - timeSet.get(key).getTime()))/1000) ;
	}
	
	/**
	 * Aug 26, 2010
	 * 
	 * @author ESPOTW
	 * 
	 * Clears the cache
	 *
	 */
	public void flushCache(){
		object.clear() ;
		timeSet.clear() ;
	}
	
	//private method to return the current timestamp
	private Date now(){
		Date now = new Date() ;
		long msec = now.getTime();
	    now.setTime(msec);
	    return now ;
	}

}
