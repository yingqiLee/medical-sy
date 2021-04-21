package com.example.medsy.entity;

public class Departments {
    private int hid;
    private int kid;
    private String main;
    private String introduce;
    private String little;

    public Departments() {
    }

    public Departments(String main, String introduce, String little) {
        this.main = main;
        this.introduce = introduce;
        this.little = little;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
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

    @Override
    public String toString() {
        return "Departments{" +
                "main='" + main + '\'' +
                ", introduce='" + introduce + '\'' +
                ", little='" + little + '\'' +
                '}';
    }
}
