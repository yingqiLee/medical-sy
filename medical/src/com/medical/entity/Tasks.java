package com.medical.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Tasks")
public class Tasks {
	@Id
	@GeneratedValue(generator="increment_generator")
	@GenericGenerator(name="increment_generator",strategy="increment")
    private int t_id;
    private String Introduction;
    private int DocId;
    private int HosId;
    //tasktime外键
    private int TimeId;
    //新加的病人id
    private int UserId;
    
    
	public Tasks() {
		super();
	}

	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getIntroduction() {
		return Introduction;
	}
	public void setIntroduction(String introduction) {
		Introduction = introduction;
	}
	public int getDocId() {
		return DocId;
	}
	public void setDocId(int docId) {
		DocId = docId;
	}
	public int getHosId() {
		return HosId;
	}
	public void setHosId(int hosId) {
		HosId = hosId;
	}
	public int getTimeId() {
		return TimeId;
	}
	public void setTimeId(int timeId) {
		TimeId = timeId;
	}
	
    
    
    
	
}
