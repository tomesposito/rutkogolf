package com.rutko.golf.model.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sponsor")
public class Sponsor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idsponsor")
	private Integer id ;
	@Column(name="name")
	private String name ;
	@Column(name="description")
	private String description ;
	@Column(name="address")
	private String address ;
	@Column(name="city")
	private String city ;
	@Column(name="state")
	private String state ;
	@Column(name="zipcode")
	private Integer zip ;
	@Column(name="phone")
	private String phone ;
	@Column(name="website")
	private String website ;
	
	
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String toString(){
		return String.format("ID: %s  NAME: %s  DESCRIPTION: %s  ADDRESS: %s  CITY: %  STATE: %s  ZIP: %s  PHONE: %s  WEBSITE: %s", 
				new String[]{Integer.toString(id), name, description, address, city, state, Integer.toString(zip), website}) ;
	}

}
