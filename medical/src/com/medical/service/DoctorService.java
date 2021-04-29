package com.medical.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.dao.DoctorDao;
import com.medical.entity.Doctors;


@Service
public class DoctorService {

	@Resource
	private DoctorDao DoctorDao ;
	
	@Transactional(readOnly = false)
	public String signDocs(String phone,String password) {
		 return this.DoctorDao.signDoc(phone, password);
	}
	
	//根据docid更新查找返回doctors(name,Hos,Dep,Skill,Title)
	public Doctors findDByDid(int did) {
		return this.findDByDid(did);
	}
	
	//(4)接收doctors类型字符串解析后根据docid更新
	public void updateDocByDid(Doctors d) {
		this.DoctorDao.updateDocByDid(d);
	}
	
	
}
