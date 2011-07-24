package com.rutko.golf.model.hibernate;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="news")
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idnews")
	private Integer id ;
	@Column(name="title")
	private String title ;
	@Column(name="content")
	private String content ;
	@ManyToOne
	@JoinColumn(name="posted_by")
	private User user ;
	@Column(name="timestamp")
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public final String toString(){
		return String.format("ID: %s TITLE: %s CONTENT: %s POSTED_BY: %s TIMESTAMP: %s", 
				new String[]{Integer.toString(id), title, content, user.getUsername(), String.valueOf(timestamp)}) ;
	}

}
