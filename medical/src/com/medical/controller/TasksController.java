package com.medical.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.medical.entity.Tasks;
import com.medical.service.TasksService;

@Controller
@RequestMapping("/Task")
public class TasksController {
	
	@Resource 
	private TasksService taskservice;
	
	@RequestMapping("/findTasktimeList")
	public void saveTask(@RequestParam String info) {
		Gson gson=new Gson();
		Tasks t=gson.fromJson(info,Tasks.class);
		this.taskservice.saveTask(t);
	}

}
