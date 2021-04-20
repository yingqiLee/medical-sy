package com.example.medsy.entity;

public class Doctors {
    private int dind;
    private String dname;
    private String dphone;
    private String dtitle;
    private String dskill;
    private String ddepartment;
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




    public Doctors(String dname, String dtitle, String dskill) {
        this.dname = dname;
        this.dtitle = dtitle;
        this.dskill = dskill;
    }

    public Doctors(String dphone, String dpassword, int dflag) {
        this.dphone = dphone;
        this.dpassword = dpassword;
        Dflag = dflag;
    }

    public Doctors() {
    }

    public int getDflag() {
        return Dflag;
    }

    public void setDflag(int dflag) {
        Dflag = dflag;
    }

    public String getDpassword() {
        return dpassword;
    }

    public void setDpassword(String dpassword) {
        this.dpassword = dpassword;
    }

    public String getDdepartment() {
        return ddepartment;
    }

    public void setDdepartment(String ddepartment) {
        this.ddepartment = ddepartment;
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

}
