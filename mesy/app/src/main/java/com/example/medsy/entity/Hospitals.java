package com.example.medsy.entity;

public class Hospitals {
    private int id;
    private String name;
    private String phone;
    private String password;
    private String grade;
    private String type;
    private String rank;
    private int Hflag;



    public Hospitals(String name, String grade, String type, String rank) {
        this.name = name;
        this.grade = grade;
        this.type = type;
        this.rank = rank;
    }

    public Hospitals(int id, String name, String grade, String type, String rank) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.type = type;
        this.rank = rank;
    }

    public Hospitals() {
    }

    public Hospitals(String phone, String password, int hflag) {
        this.phone = phone;
        this.password = password;
        Hflag = hflag;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHflag() {
        return Hflag;
    }

    public void setHflag(int hflag) {
        Hflag = hflag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Hospitals{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", type='" + type + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }

    public static class RegisterDetail {
    }
}
