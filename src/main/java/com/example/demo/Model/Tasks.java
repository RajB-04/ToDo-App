package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskid;
    private String taskName;
    private boolean taskStatus;
    public int getTaskid() {
        return taskid;
    }
    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public boolean getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Tasks(int taskid, String taskName, boolean taskStatus) {
        this.taskid = taskid;
        this.taskName = taskName;
        this.taskStatus = taskStatus;
    }
    public Tasks() {
    }

}
