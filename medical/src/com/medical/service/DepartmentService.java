package com.medical.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medical.entity.Departments;

@Service
public class DepartmentService {
	@Resource 
	private Departments DepartmentDaos;
	
	//≤È’“ø∆ “list
	@Transactional(readOnly = false)
	public List<Departments> findDeById(int id){
		return this.findDeById(id);
		
	}
	
	
	
}
