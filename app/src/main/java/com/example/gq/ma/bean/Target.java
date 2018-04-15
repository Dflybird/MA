package com.example.gq.ma.bean;

public class Target {

    private int id;
    private int TaskID;
    private String location;
    private boolean isTransport;

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

    public boolean isTransport() {
        return isTransport;
    }

    public void setTransport(boolean transpot) {
        isTransport = transpot;
    }

    @Override
    public String toString() {
        return "Target{" +
                "id=" + id +
                ", TaskID=" + TaskID +
                ", location='" + location + '\'' +
                ", isTranspot=" + isTransport +
                '}';
    }
}
