package com.newshunt.feedback.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newshunt.daomodel.FeedbackDao;
import com.newshunt.daomodel.signup;

@Controller
public class Feedbackform {

	@RequestMapping("/feedback")
	public String feedback() {
		return "feedback";
	}
	
	@RequestMapping(value="/feedbackform" , method=RequestMethod.POST)
	@ResponseBody
	public  byte saveUserInfo(@RequestBody FeedbackDao rec) {
		
		  try
		  {
			  Configuration cfg= new Configuration();
		       cfg.configure("hibernate.cfg.xml");
		       SessionFactory sf = cfg.buildSessionFactory();
		       Session ss = sf.openSession();
		       ss.save(rec);
		       ss.beginTransaction().commit();
	    	   return 1; 
		  }
		  catch(Exception e) {
			  
		  e.printStackTrace();
		  
		  }
		  return 0;
	}
}
