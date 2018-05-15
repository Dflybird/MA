package com.example.gq.ma.bean;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Robot extends DataSupport{

    private int id;
    private int electric;
    private int distance;
    private String name;
    private boolean isDetect;
    private Task task;
    private List<History> histories = new ArrayList<>();

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isDetect() {
        return isDetect;
    }

    public void setDetect(boolean detect) {
        isDetect = detect;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "id=" + id +
                ", electric=" + electric +
                ", distance=" + distance +
                ", name='" + name + '\'' +
                ", isDetect=" + isDetect +
                ", task=" + task +
                ", histories=" + histories +
                '}';
    }
}
