package com.medical.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Tasktime")
public class Tasktime {
	@Id
	@GeneratedValue(generator="increment_generator")
	@GenericGenerator(name="increment_generator",strategy="increment")
    private int ttimeid;
    private String taskdtime;
    private String taskweek;
    private String taskday;
    private String flag;
    //医生患者的id 本来就有的
    private int taskdid;
    private int taskuid;
    
    
	public Tasktime() {
		super();
	}
	public int getTtimeid() {
		return ttimeid;
	}
	public void setTtimeid(int ttimeid) {
		this.ttimeid = ttimeid;
	}
	public String getTaskdtime() {
		return taskdtime;
	}
	public void setTaskdtime(String taskdtime) {
		this.taskdtime = taskdtime;
	}
	public String getTaskweek() {
		return taskweek;
	}
	public void setTaskweek(String taskweek) {
		this.taskweek = taskweek;
	}
	public String getTaskday() {
		return taskday;
	}
	public void setTaskday(String taskday) {
		this.taskday = taskday;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public int getTaskdid() {
		return taskdid;
	}
	public void setTaskdid(int taskdid) {
		this.taskdid = taskdid;
	}
	public int getTaskuid() {
		return taskuid;
	}
	public void setTaskuid(int taskuid) {
		this.taskuid = taskuid;
	}
	
	

}
