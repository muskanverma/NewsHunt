package com.newshunt.userslist.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newshunt.daomodel.ChannelListDao;
import com.newshunt.daomodel.signup;

@Controller
public class ListOfUsers {

	@RequestMapping(value="/adUsers")
	public String userslist(){
		return "listofusers";
	}
	
	@RequestMapping(value = "/usrLst" , method = RequestMethod.POST)
    @ResponseBody
	public List<signup>channellist(){
	   Configuration cfg = new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   SessionFactory sf = cfg.buildSessionFactory();
       Session ss = sf.openSession();
       Criteria cr = ss.createCriteria(signup.class);
       List<signup>p=cr.list();
	   if(p.isEmpty()!=true) {
		    return p;  
	   }
	   
	 return null;  
   }
}
