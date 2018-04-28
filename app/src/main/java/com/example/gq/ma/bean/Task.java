package com.example.gq.ma.bean;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Task extends DataSupport{

    private int id;
    private String date;
    private String title;
    private List<Robot> robots = new ArrayList<>();
    private List<Target> targets = new ArrayList<>();
    private List<Terrain> terrains = new ArrayList<>();

    public List<Robot> getRobots() {
        return robots;
    }

    public void setRobots(List<Robot> robots) {
        this.robots = robots;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public List<Terrain> getTerrains() {
        return terrains;
    }

    public void setTerrains(List<Terrain> terrains) {
        this.terrains = terrains;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", title='" + title + '\'' +
                ", robots=" + robots +
                ", targets=" + targets +
                ", terrains=" + terrains +
                '}';
    }
}
