package com.newshunt.adminhome.controller;

import java.util.ArrayList;
import java.util.LinkedHashSet;
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
import com.newshunt.daomodel.signup;
@Controller
public class adminHomePage {

	@RequestMapping(value="/adminhome")
	public String admin(){
		return "adminhome";
	}
	
	@RequestMapping(value = "/ttusers" , method = RequestMethod.POST)
    @ResponseBody
	public String totalUsers(){
		String countofusers = "0";
	   Configuration cfg = new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   SessionFactory sf = cfg.buildSessionFactory();
       Session ss = sf.openSession();
       Criteria cr = ss.createCriteria(signup.class);
       List<signup>p=cr.list();
	   if(p.isEmpty()!=true) {
		     countofusers = "" + p.size();
	   }
	   
	 return countofusers;  
   }
	
	@RequestMapping(value = "/ttchannels" , method = RequestMethod.POST)
    @ResponseBody
	public String totalchannels(){
		String countofchannels = "0";
	   Configuration cfg = new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   SessionFactory sf = cfg.buildSessionFactory();
       Session ss = sf.openSession();
       Criteria cr = ss.createCriteria(ChannelListDao.class);
       List<ChannelListDao>p=cr.list();
	   if(p.isEmpty()!=true) {
		     countofchannels = "" + p.size();
	   }
	   
	 return countofchannels;  
   }
	
	@RequestMapping(value = "/sub")
    @ResponseBody
	public String subscribedchannels(){
		String s="";
		try {
		   Configuration cfg = new Configuration();
		   cfg.configure("hibernate.cfg.xml");
		   SessionFactory sf = cfg.buildSessionFactory();
	       Session ss = sf.openSession();
	       Criteria cr = ss.createCriteria(signup.class);
	       List<signup>p=cr.list();
	       LinkedHashSet<Integer>hs = new LinkedHashSet<Integer>();
	       for(signup x:p){
	    	   
	    	  String c = x.getMychannel();
	    	  String m[] = c.split(",");
	    	  for(String y:m){
	    		  hs.add(Integer.parseInt(y));
	    	  }
	   		}
		    s = s+hs.size();  
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return s;
	}
	
	@RequestMapping(value = "/unsub")
    @ResponseBody
	public String unsubscribedchannels(){
		String s="";
		try {
		   Configuration cfg = new Configuration();
		   cfg.configure("hibernate.cfg.xml");
		   SessionFactory sf = cfg.buildSessionFactory();
	       Session ss = sf.openSession();
	       Criteria cr = ss.createCriteria(signup.class);
	       List<signup>p=cr.list();
	       LinkedHashSet<Integer>hs = new LinkedHashSet<Integer>();
	       for(signup x:p){
	    	   
	    	  String c = x.getMychannel();
	    	  String m[] = c.split(",");
	    	  for(String y:m){
	    		  hs.add(Integer.parseInt(y));
	    	  }
	   		}
		   
		    Criteria c = ss.createCriteria(ChannelListDao.class);
		    List<ChannelListDao>m=c.list();
		    s+=m.size()-hs.size();
		}
		catch(Exception e)
    	{
    		e.printStackTrace();
    	}
		return s;
	}
	
}
