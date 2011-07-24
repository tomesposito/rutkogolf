package com.rutko.golf.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.rutko.golf.service.NewsManager;

public class MainController extends AbstractController {

	private String newsattrib ;
	private String newsparam ;
	private String newsitemattrib ;
	private NewsManager newsmanager ;
	

	public final ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
		request.setAttribute(this.getNewsattrib(), this.getNewsmanager().fetchAllNews()) ;
		if(StringUtils.isNotEmpty(this.getNewsparam())){
			request.setAttribute(this.getNewsitemattrib(), 
					this.getNewsmanager().fetchNewsByID(
							Integer.parseInt(StringUtils.substringAfterLast(request.getRequestURI(), this.getNewsparam()))
							)
						);
		}
		return new ModelAndView(super.getSuccessView()) ;
	}
	
	public String getNewsattrib() {
		return newsattrib;
	}

	public void setNewsattrib(String newsattrib) {
		this.newsattrib = newsattrib;
	}
	
	public String getNewsparam() {
		return newsparam;
	}

	public void setNewsparam(String newsparam) {
		this.newsparam = newsparam;
	}
	
	public String getNewsitemattrib() {
		return newsitemattrib;
	}

	public void setNewsitemattrib(String newsitemattrib) {
		this.newsitemattrib = newsitemattrib;
	}
	
	public NewsManager getNewsmanager() {
		return newsmanager;
	}

	public void setNewsmanager(NewsManager newsmanager) {
		this.newsmanager = newsmanager;
	}

	
}
