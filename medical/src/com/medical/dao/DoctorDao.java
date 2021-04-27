package com.medical.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.medical.entity.Doctors;
import com.medical.entity.Users;

@Repository
public class DoctorDao {

	@Resource
	private SessionFactory sessionFactory;
	
	//登录和注册
	public String signDoc(String phone,String password) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Doctors where dphone=?");
		query.setParameter(0, phone);
		List<Doctors> doclist=query.list();
		if(doclist.size() == 0) {
			return "账号或密码错误";
		}
		else {
			Doctors u2 =doclist.get(0) ;
			if(u2.getDpassword().equals(password)) {
				return "账号正确";
			}
		}
		return "账号或密码错误";
		
	}
	
	//根据医院id、科室id查找对应科室的全部医生(list<科室>)(只要name，title，科室，skill)；
	public List<Doctors> findALLD(int hoid,int deid) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select did,dname,dtitle,department,dskill from Doctors where dhospitalid= ? and ddepartmentid = ?");
		query.setParameter(0, hoid);
		query.setParameter(1, deid);
		List<Doctors> doclist=query.list();
		return doclist;
	}
	
	
}
