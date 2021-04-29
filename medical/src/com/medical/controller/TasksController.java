package com.medical.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.medical.entity.Taskitems;
import com.medical.entity.Tasks;
import com.medical.entity.Tasktime;
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

	//用户id找挂号个人中心
	@RequestMapping("/findTasktime")
	public String findTasktime(@RequestParam String uid) {
		int dd = Integer.parseInt(uid);
		Taskitems tt = taskservice.findTasktime(dd);
		Gson json =  new Gson();
		String a =json.toJson(tt);
		return a ;
		
	}
	
	
	
	
}
