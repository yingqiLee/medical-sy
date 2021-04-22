package com.example.medsy.entity;

public class TaskTime {
    private int id;
    private String taskdtime;
    private String taskweek;
    private String taskday;
    private String flag;
    private int taskdid;
    private int taskuid;

    public TaskTime(int id, String taskdtime, String taskweek, String taskday, String flag, int taskdid, int taskuid) {
        this.id = id;
        this.taskdtime = taskdtime;
        this.taskweek = taskweek;
        this.taskday = taskday;
        this.flag = flag;
        this.taskdid = taskdid;
        this.taskuid = taskuid;
    }

    public TaskTime(String taskdtime, String taskweek, String taskday) {
        this.taskdtime = taskdtime;
        this.taskweek = taskweek;
        this.taskday = taskday;
    }

    public TaskTime() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskdtime() {
        return taskdtime;
    }

    public void setTaskdtime(String taskdtime) {
        this.taskdtime = taskdtime;
    }

    public String getTaskweek() {
        return taskweek;
    }

    public void setTaskweek(String taskweek) {
        this.taskweek = taskweek;
    }

    public String getTaskday() {
        return taskday;
    }

    public void setTaskday(String taskday) {
        this.taskday = taskday;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getTaskdid() {
        return taskdid;
    }

    public void setTaskdid(int taskdid) {
        this.taskdid = taskdid;
    }

    public int getTaskuid() {
        return taskuid;
    }

    public void setTaskuid(int taskuid) {
        this.taskuid = taskuid;
    }

    @Override
    public String toString() {
        return "TaskTime{" +
                "id=" + id +
                ", taskdtime='" + taskdtime + '\'' +
                ", taskweek='" + taskweek + '\'' +
                ", taskday='" + taskday + '\'' +
                ", flag='" + flag + '\'' +
                ", taskdid=" + taskdid +
                ", taskuid=" + taskuid +
                '}';
    }
}
