package com.medical.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.dao.TaskDao;
import com.medical.dao.TasktimeDao;
import com.medical.entity.Taskitems;
import com.medical.entity.Tasks;

@Service
public class TasksService {
	@Resource
	private TaskDao TaskDao;
	
	public void saveTask(Tasks t) {
		this.TaskDao.saveTask(t);
	}

	//”√ªßid’“
	@Transactional(readOnly = false)
	public Taskitems findTasktime(int taskuid) {
		return this.TaskDao.findTasktime(taskuid);
	}
	
	
}
