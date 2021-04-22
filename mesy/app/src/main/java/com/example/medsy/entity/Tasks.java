package com.example.medsy.entity;

public class Tasks {
    private int t_id;
    private String Introduction;
    private String t_uName;
    private int DocId;
    private int HosId;
    private String t_time;
    private String t_week;
    private String t_day;


    public Tasks(String introduction, String t_uName, int docId, int hosId, String t_time, String t_week, String t_day) {
        Introduction = introduction;
        this.t_uName = t_uName;
        DocId = docId;
        HosId = hosId;
        this.t_time = t_time;
        this.t_week = t_week;
        this.t_day = t_day;
    }

    public Tasks() {
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public int getDocId() {
        return DocId;
    }

    public void setDocId(int docId) {
        DocId = docId;
    }

    public int getHosId() {
        return HosId;
    }

    public void setHosId(int hosId) {
        HosId = hosId;
    }

    public String getT_time() {
        return t_time;
    }

    public void setT_time(String t_time) {
        this.t_time = t_time;
    }

    public String getT_week() {
        return t_week;
    }

    public void setT_week(String t_week) {
        this.t_week = t_week;
    }

    public String getT_day() {
        return t_day;
    }

    public void setT_day(String t_day) {
        this.t_day = t_day;
    }

    public String getT_uName() {
        return t_uName;
    }

    public void setT_uName(String t_uName) {
        this.t_uName = t_uName;
    }
}
