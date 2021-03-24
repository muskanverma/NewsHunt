package com.newshunt.loginsignup.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newshunt.daomodel.signup;

@Controller
public class LoginSignup {
	
	@RequestMapping("/")
	public String login() {
		return "login";
	}

	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping(value="/saveUserInfo" , method=RequestMethod.POST)
	@ResponseBody
	public  byte saveUserInfo(@RequestBody signup rec) {
		
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
	
	@ResponseBody
	@RequestMapping(value="/checkInfo", method=RequestMethod.POST)
	public byte checkInfo(@RequestBody signup r, HttpSession session) {
		
		String un="";
		byte flag=0;
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
        Session ss = sf.openSession();
        Criteria cr = ss.createCriteria(signup.class);
        List<signup>p=cr.list();
	       for(signup x:p) {
	    	   if(x.getEmail().equals(r.getEmail())&&x.getPassword().equals(r.getPassword())){
	    		   flag=1;
	    		   un = r.getEmail();
	    	   }
	    	   if(r.getEmail().equals("admin@123")&&r.getPassword().equals("adminpassword")) {
	    		   flag=2;
	    	   }
	       }
	    
			session.setAttribute("un",un);
			return flag;
	}

}
