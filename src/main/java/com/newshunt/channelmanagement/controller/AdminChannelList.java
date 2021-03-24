package com.newshunt.channelmanagement.controller;

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
public class AdminChannelList {

	@RequestMapping(value = "/adChannelList")
	public String channelList() {
		return "adminChannelList";
	}

	@RequestMapping(value = "/fetchChannelList" , method = RequestMethod.POST)
    @ResponseBody
	public List<ChannelListDao>channellist(){
	   Configuration cfg = new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   SessionFactory sf = cfg.buildSessionFactory();
       Session ss = sf.openSession();
       Criteria cr = ss.createCriteria(ChannelListDao.class);
       List<ChannelListDao>p=cr.list();
	   if(p.isEmpty()!=true) {
		    return p;  
	   }
	   
	 return null;  
   }
	
	@RequestMapping(value = "/updateChannelInfo" , method = RequestMethod.POST)
    @ResponseBody
	public  byte updatechannel(@RequestBody ChannelListDao rec){
		
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
	
	@RequestMapping(value="/deleteChannelInfo", method=RequestMethod.POST)
	@ResponseBody
	public void del1(@RequestBody ChannelListDao rec)
	{
	Configuration cfg= new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory sf = cfg.buildSessionFactory();
	Session ss = sf.openSession();	    
	Criteria criteria = ss.createCriteria(signup.class);
	List<signup>info =criteria.list();
	for(signup w : info) {
		String updateChannel="";
		if(w.getMychannel().contains(rec.getId()+""));
		{
	       String m[] = w.getMychannel().split(",");		
	       for(String v: m) {
	    	   if(v.equals(rec.getId()+"")){
	    		    continue;
	    	   }
	    	   else {
	    		   updateChannel = updateChannel + v +",";    
	    	   }
	       }
	       w.setMychannel(updateChannel);
	       ss.update(w);      
		}
	}
	ss.delete(rec);
	ss.beginTransaction().commit();
	}
}