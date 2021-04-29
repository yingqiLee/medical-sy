package com.medical.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	//根据Id查找学生发送
	@RequestMapping("/findUById")
	public String findUserById(@RequestParam String id,Model model,HttpServletRequest req,HttpServletResponse rep) {
		rep.setCharacterEncoding("UTF-8");
		rep.setContentType("text/html;charset=UTF-8");
		Gson gson=new Gson();
		System.out.println(id);
		int userId = Integer.parseInt(id);
		Users user=userService.findUserById(userId);
		String usering=gson.toJson(user);
		model.addAttribute("user",usering);
		System.out.println(usering);
		PrintWriter writer;
		try {
			writer = rep.getWriter();
			writer.println(usering);
		    writer.flush();
		    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usering;
		
	}
	
	//个人中心更改信息
	@RequestMapping("/updateById")
	public String updateUserById(@RequestParam String change_user) {
		Gson gson=new Gson();
		System.out.println(change_user);
		Users u = gson.fromJson(change_user, Users.class);
		int userId = u.getuId();
		System.out.print(userId);
		this.userService.update(u);
		return "修改成功";
		
	}
	
	
	
	
}
