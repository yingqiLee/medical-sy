package com.medical.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;
import com.medical.entity.Tasks;
import com.medical.entity.Tasktime;

@Repository
public class TaskDao {

	@Resource
	private SessionFactory sessionFactory;
	

	//����tasks���͵�Gson�ַ����������󱣴�tasks����
	public void saveTask(Tasks task) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(task);
		System.out.print("����ɹ�");
	}
	
}
