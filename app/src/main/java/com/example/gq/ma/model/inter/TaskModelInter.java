package com.example.gq.ma.model.inter;

import com.example.gq.ma.bean.Task;

import java.util.List;

public interface TaskModelInter {

    List<Task> getTaskList();
    Task getTaskByID(int taskID);
}
