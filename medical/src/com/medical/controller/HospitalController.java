package com.medical.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.medical.entity.Doctors;
import com.medical.entity.Hospitals;
import com.medical.service.HospitalService;
import com.medical.service.usersService;

@Controller
@RequestMapping("/Hos")
public class HospitalController {
	@Resource
	private HospitalService HospitalService;
	
	@RequestMapping("/signin")
	public String signin(@RequestParam String info) {
		System.out.println("aaa");
		System.out.print(info);
		Gson gson=new Gson();
		Doctors user2=gson.fromJson(info, Doctors.class);
		String phone = user2.getDphone();
		String password = user2.getDpassword();
		int flag = (int)user2.getDflag();
		//普通用户
		if(flag==1) {
			HospitalService.signHo(phone, password);
			return "密码正确";
		}
		return "账号或密码错误";
	}
	
	@RequestMapping("/findHoList")
	public List<Hospitals> findHospitalById(){
		return this.HospitalService.findHospital();
		
	}
	
	
}
