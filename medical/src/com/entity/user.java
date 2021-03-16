package com.entity;

public class user {
	private int Id;
	private String uimg;
	private String uphone;
	private String uname;
	
	
	@Override
	public String toString() {
		return "user [Id=" + Id + ", uimg=" + uimg + ", uphone=" + uphone + ", uname=" + uname + "]";
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getUimg() {
		return uimg;
	}


	public void setUimg(String uimg) {
		this.uimg = uimg;
	}


	public String getUphone() {
		return uphone;
	}


	public void setUphone(String uphone) {
		this.uphone = uphone;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}
	
	

}
