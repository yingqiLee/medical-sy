package com.medical.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.medical.entity.Doctors;
import com.medical.entity.Tasktime;
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
	
	//����ҽԺid������id���Ҷ�Ӧ���ҵ�ȫ��ҽ��(list<����>)(ֻҪname��title�����ң�skill)��
	public List<Doctors> findALLD(int hoid,int deid) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select did,dname,dtitle,department,dskill from Doctors where dhospitalid= ? and ddepartmentid = ?");
		query.setParameter(0, hoid);
		query.setParameter(1, deid);
		List<Doctors> doclist=query.list();
		return doclist;
	}
	
	//����docid���²��ҷ���doctors(name,Hos,Dep,Skill,Title)
	public Doctors findDByDid(int did) {
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select * from Doctors where dind= ?");
		query.setParameter(0, did);
		List<Doctors> doclist=query.list();
		Doctors d = doclist.get(0);
		return d;
		
	}
	
	//(4)����doctors�����ַ������������docid����
	public void updateDocByDid(Doctors d) {
		Session session=this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(d);
	}
	

	
	
}
