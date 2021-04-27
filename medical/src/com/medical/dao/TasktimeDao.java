package com.medical.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.medical.entity.Doctors;
import com.medical.entity.Tasks;
import com.medical.entity.Tasktime;

@Repository
public class TasktimeDao {
	@Resource
	private SessionFactory sessionFactory;
	
	//����ҽ��id����ȫ�� flag=0 �Ŀ���ʱ��(list<ʱ��>)
	public List<Tasktime> findALLD(int did) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select taskdid from Tasktime where did= ? and flag = ?");
		query.setParameter(0, did);
		query.setParameter(1, "0");
		List<Tasktime> tlist=query.list();
		return tlist;
	}
	
	
	//����ҽ��id��ʱ��id������Ӧʱ���flag��Ϊ1(flag=0->flag=1)(����Ҫ����ֵ)
	public void update(int did,int ttimeid) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(" select * from Tasktime where taskdid= ? and ttimeid = ?");
		query.setParameter(0, did);
		query.setParameter(1, ttimeid);
		List<Tasktime> tlist=query.list();
		if(tlist.size()!=0) {
			Tasktime a = tlist.get(0);
			a.setFlag("1");
			session.update(a);
		}
		 
	}

	

}
