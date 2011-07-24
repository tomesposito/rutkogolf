package com.rutko.golf.web.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.web.servlet.ModelAndView;

import com.rutko.golf.model.hibernate.News;
import com.rutko.golf.model.hibernate.User;
import com.rutko.golf.service.NewsManager;

public class NewsController extends AbstractController {

	private String newsattrib ;
	private String newsactionparam ;
	private String newsidparam ;
	private String newstitleparam ;
	private String newscontentparam ;
	private String newsitemattrib ;
	private NewsManager newsmanager ;
	

	public final ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
		if(StringUtils.equalsIgnoreCase(request.getParameter(this.getNewsactionparam()), "edit")){
			if(StringUtils.isNotEmpty(request.getParameter(this.getNewsidparam()))
					&& StringUtils.isNotEmpty(request.getParameter(this.getNewstitleparam()))
					){
				News news = this.getNewsmanager().fetchNewsByID(Integer.parseInt(request.getParameter(this.getNewsidparam()))) ;
				news.setTitle(Jsoup.clean(request.getParameter(this.getNewstitleparam()), Whitelist.none())) ;
				news.setContent(Jsoup.clean(request.getParameter(this.getNewscontentparam()), Whitelist.relaxed())) ;
				news.setUser((User)request.getSession().getAttribute("user")) ;
				news.setTimestamp(new Date()) ;
				this.getNewsmanager().fetchUpdateNews(news) ;
				request.setAttribute(this.getNewsitemattrib(), news) ;
			}else if(StringUtils.isEmpty(request.getParameter(this.getNewsidparam()))
					&& StringUtils.isNotEmpty(request.getParameter(this.getNewstitleparam()))){
				News news = new News() ;
				news.setTitle(Jsoup.clean(request.getParameter(this.getNewstitleparam()), Whitelist.none())) ;
				news.setContent(Jsoup.clean(request.getParameter(this.getNewscontentparam()), Whitelist.relaxed())) ;
				news.setUser((User)request.getSession().getAttribute("user")) ;
				news.setTimestamp(new Date()) ;
				this.getNewsmanager().fetchUpdateNews(news) ;
				request.setAttribute(this.getNewsattrib(), this.getNewsmanager().fetchAllNews()) ;
				return new ModelAndView(super.getSuccessView()) ;
			}
		}else if(StringUtils.equalsIgnoreCase(request.getParameter(this.getNewsactionparam()), "delete")){
			if(StringUtils.isNotEmpty(request.getParameter(this.getNewsidparam()))){
				this.getNewsmanager().fetchDeleteNews(
						this.getNewsmanager().fetchNewsByID(
								Integer.parseInt(request.getParameter(this.getNewsidparam())))) ;
				request.setAttribute(this.getNewsattrib(), this.getNewsmanager().fetchAllNews()) ;
				return new ModelAndView(super.getSuccessView()) ;
			}
		}
		request.setAttribute(this.getNewsattrib(), this.getNewsmanager().fetchAllNews()) ;
		return new ModelAndView(super.getFormView()) ;
	}
	
	public String getNewsattrib() {
		return newsattrib;
	}

	public void setNewsattrib(String newsattrib) {
		this.newsattrib = newsattrib;
	}
	
	public String getNewsactionparam() {
		return newsactionparam;
	}

	public void setNewsactionparam(String newsactionparam) {
		this.newsactionparam = newsactionparam;
	}
	
	public String getNewsidparam() {
		return newsidparam;
	}

	public void setNewsidparam(String newsidparam) {
		this.newsidparam = newsidparam;
	}

	public String getNewstitleparam() {
		return newstitleparam;
	}

	public void setNewstitleparam(String newstitleparam) {
		this.newstitleparam = newstitleparam;
	}

	public String getNewscontentparam() {
		return newscontentparam;
	}

	public void setNewscontentparam(String newscontentparam) {
		this.newscontentparam = newscontentparam;
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
