package com.medical.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.medical.entity.Hospitals;
import com.medical.entity.Users;

@Repository
public class HospitalsDao {

	@Resource
	private SessionFactory sessionFactory;
	
	//µÇÂ¼ºÍ×¢²á
	public String signHo(String phone,String password) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Hospitals where hphone=?");
		query.setParameter(0, phone);
		List<Hospitals> holist=query.list();
		if(holist.size() == 0) {
			return "ÕËºÅ»òÃÜÂë´íÎó";
		}
		else {
			Hospitals u2 =holist.get(0) ;
			if(u2.getHpassword().equals(password)) {
				return "ÕËºÅÕıÈ·";
			}
		}
		return "ÕËºÅ»òÃÜÂë´íÎó";
		
	}
	
	//²éÕÒÒ½Ôºlist
	public List<Hospitals> findHospital() {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("selsect * from Hospitals");
		List<Hospitals> ho=query.list();
		return ho;
	}
	

	
	
	
	
}
