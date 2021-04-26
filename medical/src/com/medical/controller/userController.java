package com.medical.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.medical.dao.DoctorDao;
import com.medical.entity.Users;
import com.medical.service.DoctorService;
import com.medical.service.HospitalService;
import com.medical.service.usersService;



@Controller
@RequestMapping("/user")
public class userController {

	@Resource
	private usersService userService;


	
	@RequestMapping("/signin")
	public String signin(@RequestParam String info) {
		System.out.println("aaa");
		System.out.print(info);
		Gson gson=new Gson();
		Users user2=gson.fromJson(info, Users.class);
		String phone = user2.getuPhone();
		String password = user2.getUpassword();
		int flag = (int)user2.getUflag();
		//普通用户
		if(flag==0) {
			userService.signUsers(phone, password);
			return "密码正确";
		}
		return "账号或密码错误";
		
	
	}
	
}
