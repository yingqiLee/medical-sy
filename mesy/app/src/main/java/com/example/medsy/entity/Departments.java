package com.example.medsy.entity;

public class Departments {
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
