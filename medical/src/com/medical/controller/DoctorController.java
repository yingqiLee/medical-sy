package com.medical.controller;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.medical.entity.Doctors;
import com.medical.entity.Users;
import com.medical.service.DoctorService;
import com.medical.service.usersService;

@Controller
@RequestMapping("/Doc")
public class DoctorController {


	@Resource
	private DoctorService DoctorService;
	
	
	@RequestMapping("/signin")
	public String signin(@RequestParam String info) {
		System.out.println("aaa");
		System.out.print(info);
		Gson gson=new Gson();
		Doctors user2=gson.fromJson(info, Doctors.class);
		String phone = user2.getDphone();
		String password = user2.getDpassword();
		int flag = (int)user2.getDflag();
		
		if(flag==2) {
			DoctorService.signDocs(phone, password);
			return "�˺Ż��������";
		}
		return "�˺Ż��������";
	}
	
	
	//����docid���²��ҷ���doctors(name,Hos,Dep,Skill,Title)
	@RequestMapping("/findDByDid")
	public Doctors findDByDid(@RequestParam String info) {
		int dd = Integer.parseInt(info);
		Doctors d = DoctorService.findDByDid(dd);
		Gson gson=new Gson();
		String a = gson.toJson(d);
		return d;
		
	}
	
	
	//(4)����doctors�����ַ������������docid����
	@RequestMapping("/findDByDid")
	public void updateDocByDid(@RequestParam String info) {
		Gson gson=new Gson();
		Doctors d=gson.fromJson(info, Doctors.class);
		this.DoctorService.updateDocByDid(d);
	}
	
	
	
	
	
}