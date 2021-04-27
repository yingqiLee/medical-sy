package com.medical.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.medical.dao.TaskDao;
import com.medical.dao.TasktimeDao;
import com.medical.entity.Tasks;

@Service
public class TasksService {
	@Resource
	private TaskDao TaskDao;
	
	public void saveTask(Tasks t) {
		this.TaskDao.saveTask(t);
	}

}
