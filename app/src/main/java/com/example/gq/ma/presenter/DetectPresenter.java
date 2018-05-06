package com.example.gq.ma.presenter;

import com.example.gq.ma.bean.History;
import com.example.gq.ma.bean.Robot;
import com.example.gq.ma.model.RobotModel;
import com.example.gq.ma.presenter.inter.DetectPresenterInter;
import com.example.gq.ma.view.inter.RobotViewInter;

import java.util.ArrayList;
import java.util.List;

public class DetectPresenter implements DetectPresenterInter {

    private RobotViewInter robotViewInter;
    private RobotModel mRobotModel;

    public DetectPresenter(RobotViewInter robotViewInter) {
        this.robotViewInter = robotViewInter;
        mRobotModel = RobotModel.getInstance();
    }


    @Override
    public List<Robot> loadDetectRobots() {
        List<Robot> robots = mRobotModel.getRobotList();
        List<Robot> detectRobots = new ArrayList<>();
        for (Robot robot : robots) {
            if (robot.isDetect())
                detectRobots.add(robot);
        }
        return detectRobots;
    }

    @Override
    public List<History> loadDetectRobotHistoryByID(int id) {
        Robot robot = mRobotModel.getRobotByID(id, true);
        return robot.getHistories();
    }

    @Override
    public void loadDetectRobotInfo(List<Robot> robotList, int position) {
        Robot robot = robotList.get(position);
        String id = Integer.toString(robot.getId());
        String name = robot.getName();
        String distance = robot.getDistance() + " m";
        String electric = robot.getElectric() + " A";
        robotViewInter.onShowInfo(id, name, distance, electric);
    }
}
