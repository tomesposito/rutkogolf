package com.rutko.golf.dao;

import java.util.List;

import com.rutko.golf.model.hibernate.Sponsor;

public interface SponsorDBDAO {
	
	List<Sponsor> getAllSponsors() ;
	
	Sponsor getSponsor(Integer id) ;
	
	Sponsor addSponsor(Sponsor sponsor) ;
	
	Sponsor updateSponsor(Sponsor sponsor) ;
	
	void deleteSponsor(Sponsor sponsor) ;

}
