package com.medical.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.medical.dao.TasktimeDao;
import com.medical.entity.Tasks;
import com.medical.entity.Tasktime;

@Service
public class TasktimeService {

	@Resource
	private TasktimeDao TasktimeDao ;
	
	
	//ҽ��id��
	@Transactional(readOnly = false)
	public List<Tasktime> findAll(int id) {
		return this.TasktimeDao.findALLD(id);
	}
	
	
	@Transactional(readOnly = false)
	public void update(int did,int ttimeid) {
		this.TasktimeDao.update(did, ttimeid);
	}
	
	//����docid����TaskTime��flag=0���󣬷���List<TaskTime>
	@Transactional(readOnly = false)
	public List<Tasktime> findTasktimeByDid(int did){
		return this.TasktimeDao.findTasktimeByDid(did);
	}

	
}
