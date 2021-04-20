package com.example.medsy.entity;

public class Tasks {
    private int t_id;
    private String Introduction;
    private int DocId;
    private int HosId;
    private int TimeId;

    public Tasks(int t_id, String introduction, int docId, int hosId, int timeId) {
        this.t_id = t_id;
        Introduction = introduction;
        DocId = docId;
        HosId = hosId;
        TimeId = timeId;
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

    public int getTimeId() {
        return TimeId;
    }

    public void setTimeId(int timeId) {
        TimeId = timeId;
    }
}
