package com.example.gq.ma.bean;

public class Terrain {

    private int id;
    private int TaskID;
    private String location;
    private boolean isDetect;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskID() {
        return TaskID;
    }

    public void setTaskID(int taskID) {
        TaskID = taskID;
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

    @Override
    public String toString() {
        return "Terrain{" +
                "id=" + id +
                ", TaskID=" + TaskID +
                ", location='" + location + '\'' +
                ", isDetect=" + isDetect +
                '}';
    }
}
