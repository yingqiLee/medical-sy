package com.medical.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;
import com.medical.entity.Doctors;
import com.medical.entity.Taskitems;
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
	
	
	//����id��Һ���Ϣ
	public Taskitems findTasktime(int taskuid){
		Session session=this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(" select * from Tasktime where taskuid= ?");
		query.setParameter(0, taskuid);
		List<Tasks> tlist=query.list();
		Tasks tt  = tlist.get(0);
		Taskitems taskitem = new Taskitems();
		Doctors d = session.get(Doctors.class,tt.getDocId());
		taskitem.setDocName(d.getDname());
		taskitem.setHosName(d.getDhospital());
		Tasktime ts = session.get(Tasktime.class,tt.getTimeId());
		taskitem.setT_day(ts.getTaskday());
		taskitem.setT_week(ts.getTaskweek());
		taskitem.setT_time(ts.getTaskdtime());
		return taskitem;
	}
	
}
