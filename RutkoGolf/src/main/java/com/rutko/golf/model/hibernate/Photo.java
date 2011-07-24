package com.rutko.golf.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SPONSOR")
public class Photo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IDPHOTO")
	private Integer id ;
	@Column(name="TITLE")
	private String name ;
	@Column(name="DESCRIPTION")
	private String description ;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
