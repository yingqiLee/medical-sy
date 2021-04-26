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
	
	
}
