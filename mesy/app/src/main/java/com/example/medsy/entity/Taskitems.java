package com.example.medsy.entity;

public class Taskitems {
    private String DocName;
    private String HosName;
    private String T_time;
    private String T_week;
    private String T_day;

    public Taskitems(String docName, String hosName, String t_time, String t_week, String t_day) {
        DocName = docName;
        HosName = hosName;
        T_time = t_time;
        T_week = t_week;
        T_day = t_day;
    }

    public String getDocName() {
        return DocName;
    }

    public void setDocName(String docName) {
        DocName = docName;
    }

    public String getHosName() {
        return HosName;
    }

    public void setHosName(String hosName) {
        HosName = hosName;
    }

    public String getT_time() {
        return T_time;
    }

    public void setT_time(String t_time) {
        T_time = t_time;
    }

    public String getT_week() {
        return T_week;
    }

    public void setT_week(String t_week) {
        T_week = t_week;
    }

    public String getT_day() {
        return T_day;
    }

    public void setT_day(String t_day) {
        T_day = t_day;
    }
}
