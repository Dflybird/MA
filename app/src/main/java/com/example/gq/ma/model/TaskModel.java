package com.example.gq.ma.model;

import com.example.gq.ma.bean.Task;
import com.example.gq.ma.bean.Terrain;
import com.example.gq.ma.model.inter.TaskModelInter;
import com.example.gq.ma.utils.GLog;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class TaskModel implements TaskModelInter {

    //单例
    private static TaskModel instance = new TaskModel();

    public static TaskModel getInstance(){
        return instance;
    }

    @Override
    public List<Task> getTaskList() {
        List<Task> tasks = DataSupport.findAll(Task.class, true);
        return tasks;
    }

    @Override
    public Task getTaskByID(int taskID) {
        Task task = DataSupport.find(Task.class, taskID, true);
        return task;
    }
}
