package com.medical.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "Departments")
public class Departments {
	@Id
	@GeneratedValue(generator="increment_generator")
	@GenericGenerator(name="increment_generator",strategy="increment")
	private int departmentid;
	//������departmentӦ�����¼ӵ�id ����
    private String main;
    private String introduce;
    private String little;
    //�¼ӵ����
    private int hospitalid;
    
    
	public Departments() {
		super();
	}
	
	
	public int getHospitalid() {
		return hospitalid;
	}


	public void setHospitalid(int hospitalid) {
		this.hospitalid = hospitalid;
	}


	public int getDepartmentid() {
		return departmentid;
	}


	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}


	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getLittle() {
		return little;
	}
	public void setLittle(String little) {
		this.little = little;
	}
	
    
    

}
