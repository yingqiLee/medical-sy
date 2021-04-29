package com.medical.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.medical.entity.Tasktime;


@Controller
@RequestMapping("/tasktime")
public class TasktimeController {
	
	@Resource 
	private com.medical.service.TasktimeService TasktimeService;
	
	//医生id找
	@RequestMapping("/findTasktimeList")
	public List<Tasktime> findHospitalById(@RequestParam String info){
		int id = Integer.parseInt(info);
		return this.TasktimeService.findAll(id);
	}
	
	//医生id和taskid修改挂号
	@RequestMapping("/change")
	public void change(@RequestParam String did,@RequestParam String ttimeid) {
		int dd = Integer.parseInt(did);
		int tt = Integer.parseInt(ttimeid);
		this.TasktimeService.update(dd, tt);
		
	}
	
	//根据docid查找TaskTime中flag=0对象，返回List<TaskTime>
	@RequestMapping("/findTasktimeByDid")
	public List<Tasktime> findTasktimeByDid(@RequestParam String did){
		int dd = Integer.parseInt(did);
		return this.TasktimeService.findTasktimeByDid(dd);
		
		
	}
	
	
	
}
