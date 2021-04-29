package com.medical.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.medical.entity.Departments;
import com.medical.dao.DepartmentDao;

@Service
public class DepartmentService {
	
	@Resource
	private DepartmentDao DepartmentDaos;
	
	//≤È’“ø∆ “list
	@Transactional(readOnly = false)
	public List<Departments> findDeById(int id){
		return this.DepartmentDaos.findDeById(id);
		
	}
	
	
	
}
