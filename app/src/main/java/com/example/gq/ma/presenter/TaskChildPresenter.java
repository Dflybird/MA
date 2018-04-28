package com.example.gq.ma.presenter;

import com.example.gq.ma.bean.Robot;
import com.example.gq.ma.bean.Target;
import com.example.gq.ma.bean.Task;
import com.example.gq.ma.bean.Terrain;
import com.example.gq.ma.model.TaskModel;
import com.example.gq.ma.presenter.inter.TaskChildPresenterInter;
import com.example.gq.ma.view.inter.TaskChildViewInter;

import java.util.List;

public class TaskChildPresenter implements TaskChildPresenterInter {

    private TaskChildViewInter mViewInter;
    private TaskModel mTaskModel;

    public TaskChildPresenter(TaskChildViewInter mViewInter) {
        this.mViewInter = mViewInter;
        mTaskModel = TaskModel.getInstance();
    }

    @Override
    public void loadTask(int taskID, boolean isDetect) {
        Task task = mTaskModel.getTaskByID(taskID);
        List<Terrain> terrainList = task.getTerrains();
        List<Target> targetList = task.getTargets();
        List<Robot> robotList = task.getRobots();
        String time = task.getDate();
        String title = "";
        String loc = "";

        if (isDetect){
            for (Terrain terrain: terrainList) {
                if (!terrain.isDetect()){
                    title = "探测" + terrain.getName();
                    loc = terrain.getLocation();
                }
            }
        } else {
            for (Target target: targetList){
                if (!target.isTransport()){
                    title = "运输" + target.getName();
                    loc = target.getLocation();
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Robot robot: robotList) {
            builder.append(robot.getName());
            builder.append("; ");
        }
        String team =  builder.toString();
        mViewInter.onRefresh(title, loc, time, team);
    }
}
