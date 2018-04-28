package com.example.gq.ma.view.inter;

import com.example.gq.ma.bean.Task;

import java.util.List;

public interface TaskViewInter {

    void onShowTaskList(List<Task> detectTasks, List<Task> transportTasks);
    void onRefreshTaskItem();
    void onShowTask();

}
