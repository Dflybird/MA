package com.example.gq.ma.bean;

import org.litepal.crud.DataSupport;

public class Terrain extends DataSupport{

    private int id;
    private String name;
    private String location;
    private boolean isDetect;
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isDetect() {
        return isDetect;
    }

    public void setDetect(boolean detect) {
        isDetect = detect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
