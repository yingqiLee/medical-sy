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
	
	
	//≤È’““Ω‘∫list
	@Transactional(readOnly = false)
	public List<Hospitals> findHospital(){
		return this.HospitalsDao.findHospital();
		
	}
	
	
}
