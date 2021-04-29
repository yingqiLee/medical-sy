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
	
	//����docid���²��ҷ���doctors(name,Hos,Dep,Skill,Title)
	public Doctors findDByDid(int did) {
		return this.findDByDid(did);
	}
	
	//(4)����doctors�����ַ������������docid����
	public void updateDocByDid(Doctors d) {
		this.DoctorDao.updateDocByDid(d);
	}
	
	
}
