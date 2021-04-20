package com.example.medsy.entity;

import android.content.Intent;

public class Users {
    private int uId;
    private String uName;
    private String uPhone;
    private String uImage;
    private String flag_doc;
    private String upassword;
    private int Uflag;

    public String getPassword() {
        return upassword;
    }

    public void setPassword(String upassword) {
        this.upassword = upassword;
    }

    public Users(int uId, String uName, String uPhone, String uImage, String flag_doc) {
        this.uId = uId;
        this.uName = uName;
        this.uPhone = uPhone;
        this.uImage = uImage;
        this.flag_doc = flag_doc;
    }

    public Users() {
    }

    public Users(String uPhone, String upassword, int uflag) {
        this.uPhone = uPhone;
        this.upassword = upassword;
        Uflag = uflag;
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

    @Override
    public String toString() {
        return "Users{" +
                "uId=" + uId +
                ", uName='" + uName + '\'' +
                ", uPhone='" + uPhone + '\'' +
                ", uImage='" + uImage + '\'' +
                ", flag_doc='" + flag_doc + '\'' +
                '}';
    }
}
