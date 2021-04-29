package com.medical.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.dao.DoctorDao;
import com.medical.dao.HospitalsDao;
import com.medical.entity.Hospitals;

@Service
public class HospitalService {

	@Resource
	private HospitalsDao HospitalsDao ;
	
	@Transactional(readOnly = false)
	public String signHo(String phone,String password) {
		return this.HospitalsDao.signHo(phone, password);
	}
	
	
	//查找医院list
	@Transactional(readOnly = false)
	public List<Hospitals> findHospital(){
		return this.HospitalsDao.findHospital();
		
	}
	
	//根据hosid更新查找返回hospitald(name,type,description)
	public Hospitals findHospitalById(int hid) {
		return this.findHospitalById(hid);
	}
	
	//根据hospitals类型字符串解析后根据hosid更新
	public void updateHo(Hospitals h) {
		this.HospitalsDao.updateHo(h);
	}
	
}
