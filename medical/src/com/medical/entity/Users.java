package com.medical.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "user")
public class Users {
	@Id
	@GeneratedValue(generator="increment_generator")
	@GenericGenerator(name="increment_generator",strategy="increment")
    private int uId;
    private String uName;
    private String uPhone;
    private String uImage;
    private String flag_doc;
    private String upassword;
    private int Uflag;
    
	
    
    
    
	public Users() {
		super();
	}
	public Users(String uPhone, String upassword, int uflag) {
		super();
		this.uPhone = uPhone;
		this.upassword = upassword;
		Uflag = uflag;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getuImage() {
		return uImage;
	}
	public void setuImage(String uImage) {
		this.uImage = uImage;
	}
	public String getFlag_doc() {
		return flag_doc;
	}
	public void setFlag_doc(String flag_doc) {
		this.flag_doc = flag_doc;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public int getUflag() {
		return Uflag;
	}
	public void setUflag(int uflag) {
		Uflag = uflag;
	}

    
    
    
    
}
