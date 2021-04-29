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
	
	//登录和注册
	public String signHo(String phone,String password) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Hospitals where hphone=?");
		query.setParameter(0, phone);
		List<Hospitals> holist=query.list();
		if(holist.size() == 0) {
			return "账号或密码错误";
		}
		else {
			Hospitals u2 =holist.get(0) ;
			if(u2.getHpassword().equals(password)) {
				return "账号正确";
			}
		}
		return "账号或密码错误";
		
	}
	
	//查找医院list
	public List<Hospitals> findHospital() {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("selsect * from Hospitals");
		List<Hospitals> ho=query.list();
		return ho;
	}
	
	//(3)根据hosid更新查找返回hospitald(name,type,description)
	public Hospitals findHospitalById(int hid) {
		Session session=this.sessionFactory.getCurrentSession();
		Hospitals h =session.get(Hospitals.class, hid);
		return h;
	}
	
	
	public void updateHo(Hospitals h) {
		Session session=this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(h);;
	}

	
	
	
	
}
