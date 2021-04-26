package com.medical.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.dao.DoctorDao;


@Service
public class DoctorService {

	@Resource
	private DoctorDao DoctorDao ;
	
	@Transactional(readOnly = false)
	public String signDocs(String phone,String password) {
		 return this.DoctorDao.signDoc(phone, password);
	}
	
	
	
}
