package com.example.gq.ma.bean;

import org.litepal.crud.DataSupport;

public class Target extends DataSupport{

    private int id;
    private String name;
    private String location;
    private String lastTransportTime;
    private boolean isTransport;
    private Task task;

    public String getLastTransportTime() {
        return lastTransportTime;
    }

    public void setLastTransportTime(String lastTransportTime) {
        this.lastTransportTime = lastTransportTime;
    }

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

    public boolean isTransport() {
        return isTransport;
    }

    public void setTransport(boolean transpot) {
        isTransport = transpot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
