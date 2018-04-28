package com.example.gq.ma.bean;

import org.litepal.crud.DataSupport;

public class History extends DataSupport{

    private int id;
    private int distance;
    private String date;
    private String location;
    private String runTime;
    private Robot robot;

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                ", distance=" + distance +
                ", date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", runTime='" + runTime + '\'' +
                ", robot=" + robot +
                '}';
    }
}
