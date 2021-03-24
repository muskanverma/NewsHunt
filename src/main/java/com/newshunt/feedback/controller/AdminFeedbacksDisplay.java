package com.newshunt.feedback.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newshunt.daomodel.FeedbackDao;
import com.newshunt.daomodel.MenuDao;
import com.newshunt.daomodel.signup;

@Controller
public class AdminFeedbacksDisplay {

	@RequestMapping(value="/adFeedback")
	public String feedbacks() {
		return "displayfeedbacks";
	}
	
	@RequestMapping(value = "/feedbacksReceived" , method = RequestMethod.POST)
    @ResponseBody
	public List<FeedbackDao>channellist(){
	   Configuration cfg = new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   SessionFactory sf = cfg.buildSessionFactory();
       Session ss = sf.openSession();
       Criteria cr = ss.createCriteria(FeedbackDao.class);
       List<FeedbackDao>p=cr.list();
	   if(p.isEmpty()!=true) {
		    return p;  
	   }
	   
	 return null;  
   }
	
	@RequestMapping(value = "/deleteFeedback" , method = RequestMethod.POST)
    @ResponseBody
	public  byte deletemenu(@RequestBody FeedbackDao rec){
		
	   try {
		   
		Configuration cfg = new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   SessionFactory sf = cfg.buildSessionFactory();
       Session ss = sf.openSession();
       ss.delete(rec);
       ss.beginTransaction().commit();
       return 1;
   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
	   return 0;
}
}
