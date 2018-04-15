package com.example.gq.ma.bean;

public class Robot {
    enum robotType{}

    private int id;
    private int TaskID;
    private int electric;
    private int distance;
    private String name;
    private robotType type;

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

    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public robotType getType() {
        return type;
    }

    public void setType(robotType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", TaskID=" + TaskID +
                ", electric=" + electric +
                ", distance=" + distance +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
