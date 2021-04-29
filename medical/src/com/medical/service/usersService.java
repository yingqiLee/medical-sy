package com.medical.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.dao.UsersDao;
import com.medical.entity.Users;



@Service
public class usersService {

	@Resource
	private UsersDao userDao;
	
	@Transactional(readOnly = false)
	public String signUsers(String phone,String password) {
		 return this.userDao.signUser(phone,password);
	}
	
	
	
	//根据id查学生
	@Transactional(readOnly = false)
	public Users findUserById(int id) {
		return this.userDao.findUserById(id);
		
	}
	
	
	//根据id更改
	@Transactional(readOnly = false)
	public void update(Users u) {
		this.userDao.update(u);
		
	}
	
}
