package com.rutko.golf.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.rutko.golf.model.hibernate.User;
import com.rutko.golf.service.UserManager;

public class AuthenticationController extends AbstractController{
	
	private String username ;
	private String password ;
	private String userAttrib ;
	private UserManager usermanager ;
	
	public final ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
		String usern = request.getParameter(this.getUsername()) ;
		String pass = request.getParameter(this.getPassword()) ;
		if(StringUtils.isNotBlank(usern) && StringUtils.isNotBlank(pass)){
			User user = this.getUsermanager().fetchChechAuth(usern, pass) ;
			if(user != null){
				request.getSession().setAttribute(this.getUserAttrib(), user) ;
				return new ModelAndView(super.getSuccessView()) ;
			}else{
				request.setAttribute(this.userAttrib, "fail") ;
			}
		}else if(StringUtils.equalsIgnoreCase(this.getUsername(), "logout")){
			request.getSession().removeAttribute(this.getUserAttrib()) ;
		}
		return new ModelAndView(super.getFormView()) ;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserAttrib() {
		return userAttrib;
	}

	public void setUserAttrib(String userAttrib) {
		this.userAttrib = userAttrib;
	}
	
	public UserManager getUsermanager() {
		return usermanager;
	}

	public void setUsermanager(UserManager usermanager) {
		this.usermanager = usermanager;
	}

}
