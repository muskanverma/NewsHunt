package com.newshunt.accountmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutID {

	@RequestMapping(value="/logout")
	public String logout() {
		return "login";
	}
	
	@RequestMapping(value="/adlogout")
	public String adminlogout() {
		return "login";
	}
}
