package com.example.gq.ma.presenter;

import com.example.gq.ma.bean.Target;
import com.example.gq.ma.bean.Task;
import com.example.gq.ma.bean.Terrain;
import com.example.gq.ma.model.TaskModel;
import com.example.gq.ma.presenter.inter.TaskPresenterInter;
import com.example.gq.ma.utils.GLog;
import com.example.gq.ma.view.inter.TaskViewInter;

import java.util.ArrayList;
import java.util.List;

public class TaskPresenter implements TaskPresenterInter {
    
    private TaskViewInter taskViewInter;
    private TaskModel taskModel;

    public TaskPresenter(TaskViewInter taskViewInter) {
        this.taskViewInter = taskViewInter;
        taskModel = TaskModel.getInstance();
    }

    @Override
    public void loadTaskList() {
        List<Task> taskList = taskModel.getTaskList();

        int len = taskList.size();

        //将存在至少一个未完成探测目标的任务加入列表
        List<Task> detectTasks = new ArrayList<>();
        for (int i = 0; i < len; i++){
            boolean isAdd = false;
            for (Terrain terrain: taskList.get(i).getTerrains()) {
                if (!terrain.isDetect())
                    isAdd = true;
            }
            if (isAdd)
                detectTasks.add(taskList.get(i));
        }
        GLog.d("detectTasks.size(): "+detectTasks.size());

        //将存在至少一个未运输的目标的任务加入列表
        List<Task> transportTasks = new ArrayList<>();
        for (int i = 0; i < len; i++){
            boolean isAdd = false;
            for (Target target: taskList.get(i).getTargets()) {
                if (!target.isTransport())
                    isAdd = true;
            }
            if (isAdd)
                transportTasks.add(taskList.get(i));
        }
        GLog.d("transportTasks.size(): "+transportTasks.size());

        taskViewInter.onShowTaskList(detectTasks, transportTasks);
    }
}
