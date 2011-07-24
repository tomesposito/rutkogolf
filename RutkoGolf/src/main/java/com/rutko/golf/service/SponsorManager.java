package com.rutko.golf.service;

import java.util.List;

import com.rutko.golf.dao.SponsorDBDAO;
import com.rutko.golf.model.hibernate.Sponsor;

public class SponsorManager {
	
	private SponsorDBDAO dao ;


	public List<Sponsor> fetchAllSponsors(){
		return dao.getAllSponsors() ;
	}
	
	public Sponsor fetchSponsorByID(Integer id){
		return dao.getSponsor(id) ;
	}
	
	public Sponsor fetchCreateSponsor(Sponsor sponsor){
		return dao.addSponsor(sponsor) ;
	}
	
	public Sponsor fetchUpdateSponsor(Sponsor sponsor){
		return dao.updateSponsor(sponsor) ;
	}
	
	public void fetchDeleteSponsor(Sponsor sponsor){
		dao.deleteSponsor(sponsor) ;
	}
	
	
	public SponsorDBDAO getDao() {
		return dao;
	}

	public void setDao(SponsorDBDAO dao) {
		this.dao = dao;
	}
}
