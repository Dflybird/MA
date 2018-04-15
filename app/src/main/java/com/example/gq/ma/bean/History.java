package com.example.gq.ma.bean;

public class History {

    private int id;
    private int robotID;
    private int distance;
    private String date;
    private String location;
    private String runTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRobotID() {
        return robotID;
    }

    public void setRobotID(int robotID) {
        this.robotID = robotID;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", robotID=" + robotID +
                ", distance=" + distance +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", runTime='" + runTime + '\'' +
                '}';
    }
}
