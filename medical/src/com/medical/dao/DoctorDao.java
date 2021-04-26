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
	
	//��¼��ע��
	public String signDoc(String phone,String password) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Doctors where dphone=?");
		query.setParameter(0, phone);
		List<Doctors> doclist=query.list();
		if(doclist.size() == 0) {
			return "�˺Ż��������";
		}
		else {
			Doctors u2 =doclist.get(0) ;
			if(u2.getDpassword().equals(password)) {
				return "�˺���ȷ";
			}
		}
		return "�˺Ż��������";
		
	}
	
}
