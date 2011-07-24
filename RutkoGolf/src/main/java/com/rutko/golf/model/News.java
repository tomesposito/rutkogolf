package com.rutko.golf.model;

import java.sql.Date;

public class News {
	
	private Integer id ;
	private String title ;
	private String content ;
	private String posted_by ;
	private Date timestamp ;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPosted_by() {
		return posted_by;
	}
	public void setPosted_by(String posted_by) {
		this.posted_by = posted_by;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public final String toString(){
		return String.format("ID: %s TITLE: %s CONTENT: %s POSTED_BY: %s TIMESTAMP: %s", 
				new String[]{Integer.toString(id), title, content, posted_by, String.valueOf(timestamp)}) ;
	}

}
