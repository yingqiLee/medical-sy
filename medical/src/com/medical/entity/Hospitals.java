package com.medical.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "hospital")
public class Hospitals {
	@Id
	@GeneratedValue(generator="increment_generator")
	@GenericGenerator(name="increment_generator",strategy="increment")
    private int hid;
    private String hname;
    private String hphone;
    private String hpassword;
    private String hgrade;
    private String htype;
    private String hrank;
    private int Hflag;
    
    
    
	public Hospitals() {
		super();
	}
	public int getHid() {
		return hid;
	}
	public void setHid(int hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public String getHphone() {
		return hphone;
	}
	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	public String getHpassword() {
		return hpassword;
	}
	public void setHpassword(String hpassword) {
		this.hpassword = hpassword;
	}
	public String getHgrade() {
		return hgrade;
	}
	public void setHgrade(String hgrade) {
		this.hgrade = hgrade;
	}
	public String getHtype() {
		return htype;
	}
	public void setHtype(String htype) {
		this.htype = htype;
	}
	public String getHrank() {
		return hrank;
	}
	public void setHrank(String hrank) {
		this.hrank = hrank;
	}
	public int getHflag() {
		return Hflag;
	}
	public void setHflag(int hflag) {
		Hflag = hflag;
	}
	
    

}
