package com.rutko.golf.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.rutko.golf.model.hibernate.Sponsor;
import com.rutko.golf.service.NewsManager;
import com.rutko.golf.service.SponsorManager;

public class SponsorController extends AbstractController{
	
	private String sponsorattrib ;
	private String sponsoractionparam ;
	private String sponsoridparam ;
	private SponsorManager sponsormanager ;
	
	private String newsattrib ;
	private NewsManager newsmanager ;
	

	public final ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute(this.getNewsattrib(), this.getNewsmanager().fetchAllNews()) ;
		request.setAttribute("states", super.getStates()) ;
		if(request.getSession().getAttribute("user") != null &&
				StringUtils.isNotEmpty(request.getParameter(this.getSponsoractionparam()))){
			if(StringUtils.equalsIgnoreCase(
					request.getParameter(this.getSponsoractionparam()), "delete")){
				this.getSponsormanager().fetchDeleteSponsor(
						this.getSponsormanager().fetchSponsorByID(
								Integer.parseInt(request.getParameter(this.getSponsoridparam())))) ;
			}else{
				if(StringUtils.equalsIgnoreCase(
						request.getParameter(this.getSponsoractionparam()), "create")){
					Sponsor sponsor = new Sponsor() ;
					this.setParameters(sponsor, request) ;
					this.getSponsormanager().fetchCreateSponsor(sponsor) ;
				}else if(StringUtils.equalsIgnoreCase(
								request.getParameter(this.getSponsoractionparam()), "update")){
					Sponsor sponsor = this.getSponsormanager().fetchSponsorByID(
							Integer.parseInt(request.getParameter(this.getSponsoridparam()))) ;
					this.setParameters(sponsor, request) ;
					this.getSponsormanager().fetchUpdateSponsor(sponsor) ;
				}
			}
		}
		
		request.setAttribute(this.getSponsorattrib(), this.getSponsormanager().fetchAllSponsors()) ;
		return new ModelAndView(super.getFormView()) ;
	}
	
	private void setParameters(Sponsor sponsor, HttpServletRequest request){
		sponsor.setName(request.getParameter("name")) ;
		sponsor.setDescription(request.getParameter("description")) ;
		sponsor.setAddress(request.getParameter("address")) ;
		sponsor.setCity(request.getParameter("city")) ;
		sponsor.setState(request.getParameter("state")) ;
		sponsor.setZip(Integer.parseInt(request.getParameter("zip"))) ;
		sponsor.setPhone(request.getParameter("phone")) ;
		sponsor.setWebsite(request.getParameter("website")) ;
	}
	
	
	public String getSponsorattrib() {
		return sponsorattrib;
	}

	public void setSponsorattrib(String sponsorattrib) {
		this.sponsorattrib = sponsorattrib;
	}

	public String getSponsoractionparam() {
		return sponsoractionparam;
	}

	public void setSponsoractionparam(String sponsoractionparam) {
		this.sponsoractionparam = sponsoractionparam;
	}

	public String getSponsoridparam() {
		return sponsoridparam;
	}

	public void setSponsoridparam(String sponsoridparam) {
		this.sponsoridparam = sponsoridparam;
	}

	public SponsorManager getSponsormanager() {
		return sponsormanager;
	}

	public void setSponsormanager(SponsorManager sponsormanager) {
		this.sponsormanager = sponsormanager;
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
