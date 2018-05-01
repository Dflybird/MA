package com.example.gq.ma.presenter;

import com.example.gq.ma.bean.Robot;
import com.example.gq.ma.model.RobotModel;
import com.example.gq.ma.presenter.inter.DetectPresenterInter;
import com.example.gq.ma.view.inter.DetectViewInter;

import java.util.ArrayList;
import java.util.List;

public class DetectPresenter implements DetectPresenterInter {

    private DetectViewInter detectViewInter;
    private RobotModel mRobotModel;

    public DetectPresenter(DetectViewInter detectViewInter) {
        this.detectViewInter = detectViewInter;
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
    public void loadDetectRobotInfo(List<Robot> robotList, int position) {
        Robot robot = robotList.get(position);
        String id = Integer.toString(robot.getId());
        String name = robot.getName();
        String distance = robot.getDistance() + " m";
        String electric = robot.getElectric() + " A";
        detectViewInter.onShowInfo(id, name, distance, electric);
    }
}
