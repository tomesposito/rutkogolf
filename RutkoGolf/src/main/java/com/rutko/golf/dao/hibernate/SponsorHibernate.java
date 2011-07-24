package com.rutko.golf.dao.hibernate;

import java.util.List;

import com.rutko.golf.dao.SponsorDBDAO;
import com.rutko.golf.model.hibernate.Sponsor;

public class SponsorHibernate extends HibernateDAO<Sponsor, Integer> implements SponsorDBDAO{
	
	public SponsorHibernate(){
		super(Sponsor.class) ;
	}
	
	public List<Sponsor> getAllSponsors(){
		return super.findAllOrder("name") ;
	}
	
	public Sponsor getSponsor(Integer id){
		return super.getObjectByPID(Sponsor.class, id) ;
	}
	
	public Sponsor addSponsor(Sponsor sponsor){
		save(sponsor) ;
		return sponsor ;
	}
	
	public Sponsor updateSponsor(Sponsor sponsor){
		save(sponsor) ;
		return sponsor ;
	}
	
	public void deleteSponsor(Sponsor sponsor){
		super.delete(sponsor) ;
	}

}
