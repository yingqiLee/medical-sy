package com.medical.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Doctors")
public class Doctors {
	@Id
	@GeneratedValue(generator="increment_generator")
	@GenericGenerator(name="increment_generator",strategy="increment")
    private int dind;
    private String dname;
    private String dphone;
    private String dtitle;
    private String dskill;
    private String dtudisease;
    private String dage;
    private String dsex;
    private int d_uid;
    private String dtuage;
    private String dtusex;
    private String dturegion;
    private String dtupeople;
    private String dpassword;
    private int Dflag;
    //新加的两个外键
    private String ddepartment;
    private String dhospital;
    private int ddepartmentid;
    private int dhospitalid;
    
    
    
    
    
    
    
    
	public String getDhospital() {
		return dhospital;
	}
	public void setDhospital(String dhospital) {
		this.dhospital = dhospital;
	}
	public int getDdepartmentid() {
		return ddepartmentid;
	}
	public void setDdepartmentid(int ddepartmentid) {
		this.ddepartmentid = ddepartmentid;
	}
	public int getDhospitalid() {
		return dhospitalid;
	}
	public void setDhospitalid(int dhospitalid) {
		this.dhospitalid = dhospitalid;
	}
	public Doctors() {
		super();
	}
	public int getDind() {
		return dind;
	}
	public void setDind(int dind) {
		this.dind = dind;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDphone() {
		return dphone;
	}
	public void setDphone(String dphone) {
		this.dphone = dphone;
	}
	public String getDtitle() {
		return dtitle;
	}
	public void setDtitle(String dtitle) {
		this.dtitle = dtitle;
	}
	public String getDskill() {
		return dskill;
	}
	public void setDskill(String dskill) {
		this.dskill = dskill;
	}
	public String getDdepartment() {
		return ddepartment;
	}
	public void setDdepartment(String ddepartment) {
		this.ddepartment = ddepartment;
	}
	public String getDtudisease() {
		return dtudisease;
	}
	public void setDtudisease(String dtudisease) {
		this.dtudisease = dtudisease;
	}
	public String getDage() {
		return dage;
	}
	public void setDage(String dage) {
		this.dage = dage;
	}
	public String getDsex() {
		return dsex;
	}
	public void setDsex(String dsex) {
		this.dsex = dsex;
	}
	public int getD_uid() {
		return d_uid;
	}
	public void setD_uid(int d_uid) {
		this.d_uid = d_uid;
	}
	public String getDtuage() {
		return dtuage;
	}
	public void setDtuage(String dtuage) {
		this.dtuage = dtuage;
	}
	public String getDtusex() {
		return dtusex;
	}
	public void setDtusex(String dtusex) {
		this.dtusex = dtusex;
	}
	public String getDturegion() {
		return dturegion;
	}
	public void setDturegion(String dturegion) {
		this.dturegion = dturegion;
	}
	public String getDtupeople() {
		return dtupeople;
	}
	public void setDtupeople(String dtupeople) {
		this.dtupeople = dtupeople;
	}
	public String getDpassword() {
		return dpassword;
	}
	public void setDpassword(String dpassword) {
		this.dpassword = dpassword;
	}
	public int getDflag() {
		return Dflag;
	}
	public void setDflag(int dflag) {
		Dflag = dflag;
	}
    
    
    
    
    
    
    

}
