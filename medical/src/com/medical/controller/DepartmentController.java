package com.medical.controller;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.medical.service.DepartmentService;




@Controller
@RequestMapping("/Department")
public class DepartmentController {

	@Resource 
	private DepartmentService DepartmentService;
	
	//医院id，查找科室list
	@RequestMapping("/findDeList")
	public void findDeById(@RequestParam String info) {
		int id = Integer.parseInt(info);
		DepartmentService.findDeById(id);
	}
	
	
	
}
