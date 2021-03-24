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

import com.newshunt.daomodel.MenuDao;
import com.newshunt.daomodel.adminMenuDao;
@Controller
public class AdminMenuList {

	@RequestMapping(value="/adMenuList")
	public String viewMenuList(){
		return "adminmenulist";
	}
	
	@RequestMapping(value = "/fetchMenuList" , method = RequestMethod.POST)
    @ResponseBody
	public List<MenuDao>MenuList(){
	   Configuration cfg = new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   SessionFactory sf = cfg.buildSessionFactory();
       Session ss = sf.openSession();
       Criteria cr = ss.createCriteria(MenuDao.class);
       List<MenuDao>p=cr.list();
	   if(p.isEmpty()!=true) {
		    return p;  
	   }
	   
	 return null;  
   }
	
	@RequestMapping(value = "/updateMenuInfo" , method = RequestMethod.POST)
    @ResponseBody
	public  byte updatemenu(@RequestBody MenuDao rec){
		
	   try {
		   
		Configuration cfg = new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   SessionFactory sf = cfg.buildSessionFactory();
       Session ss = sf.openSession();
       ss.update(rec);
       ss.beginTransaction().commit();
       return 1;
   }
	   catch(Exception e){
		   e.printStackTrace();
	   }
	   return 0;
}
	
	@RequestMapping(value = "/deleteMenuInfo" , method = RequestMethod.POST)
    @ResponseBody
	public  byte deletemenu(@RequestBody MenuDao rec){
		
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