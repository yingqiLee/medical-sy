package com.medical.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.medical.entity.Departments;
  

@Repository
public class DepartmentDao {

	@Resource
	private SessionFactory sessionFactory;
	
	//≤È’“ø∆ “list
	public List<Departments> findDeById(int id) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("selsect * from Departments where hospitalid =?");
		query.setParameter(0, id);
		List<Departments> ho=query.list();
		return ho;
	}
	
	
	
}
