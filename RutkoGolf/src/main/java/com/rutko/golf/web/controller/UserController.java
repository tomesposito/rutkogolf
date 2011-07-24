package com.rutko.golf.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.rutko.golf.model.hibernate.User;
import com.rutko.golf.service.UserManager;

public class UserController extends AbstractController{
	
	private String usernameparam ;
	private String passwordparam ;
	private String fnameparam ;
	private String lnameparam ;
	private String actionparam ;
	private String userAttrib ;
	private UserManager usermanager ;
	
	public final ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response){
		if(request.getSession().getAttribute("user") != null){
			if(StringUtils.equalsIgnoreCase(request.getParameter(this.getActionparam()), "create")){
				User user = new User() ;
				user.setUsername(request.getParameter(this.getUsernameparam())) ;
				user.setPassword(request.getParameter(this.getPasswordparam())) ;
				user.setFname(request.getParameter(this.getFnameparam())) ;
				user.setLname(request.getParameter(this.getLnameparam())) ;
				user.setAccount_type(0) ;
				this.getUsermanager().fetchAddUser(user) ;
				return new ModelAndView(super.getSuccessView()) ;
			}else if(StringUtils.equalsIgnoreCase(request.getParameter(this.getActionparam()), "changepass")){
				User user = this.getUsermanager().fetchGetUser(request.getParameter(this.getUsernameparam())) ;
				user.setPassword(request.getParameter(this.getPasswordparam())) ;
				this.getUsermanager().fetchUpdateUser(user) ;
				return new ModelAndView(super.getSuccessView()) ;
			}
			
		}
		return new ModelAndView(super.getFormView()) ;
	}
	
	public String getUsernameparam() {
		return usernameparam;
	}

	public void setUsernameparam(String usernameparam) {
		this.usernameparam = usernameparam;
	}

	public String getPasswordparam() {
		return passwordparam;
	}

	public void setPasswordparam(String passwordparam) {
		this.passwordparam = passwordparam;
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

	public void setFnameparam(String fnameparam) {
		this.fnameparam = fnameparam;
	}

	public String getFnameparam() {
		return fnameparam;
	}

	public void setLnameparam(String lnameparam) {
		this.lnameparam = lnameparam;
	}

	public String getLnameparam() {
		return lnameparam;
	}

	public void setActionparam(String actionparam) {
		this.actionparam = actionparam;
	}

	public String getActionparam() {
		return actionparam;
	}

}
