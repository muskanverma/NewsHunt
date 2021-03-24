package com.newshunt.menu.controller;

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

import com.newshunt.daomodel.ChannelListDao;
import com.newshunt.daomodel.MenuDao;
import com.newshunt.daomodel.adminMenuDao;
import com.newshunt.daomodel.signup;
@Controller
public class AdminMenuManagement {
	


	@RequestMapping(value = "/InitialMenu" , method = RequestMethod.POST)
    @ResponseBody
	public List<adminMenuDao>home(){
	   Configuration cfg = new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   SessionFactory sf = cfg.buildSessionFactory();
       Session ss = sf.openSession();
       Criteria cr = ss.createCriteria(adminMenuDao.class);
       List<adminMenuDao>p=cr.list();
	   if(p.isEmpty()!=true) {
		    return p;  
	   }
	   
	 return null;  
   }
	
	
	@RequestMapping(value="/adAddMenu")
	public String addMenu(){
		return "adminaddmenu";
	}
	
	
	@RequestMapping(value = "/addMenu" , method = RequestMethod.POST)
    @ResponseBody
	public  byte addmenu(@RequestBody MenuDao rec){
		
	   try {
		   
		Configuration cfg = new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   SessionFactory sf = cfg.buildSessionFactory();
       Session ss = sf.openSession();
       ss.save(rec);
       ss.beginTransaction().commit();
       return 1;
   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
	   return 0;
}
}