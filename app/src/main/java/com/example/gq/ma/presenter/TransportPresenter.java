package com.example.gq.ma.presenter;

import com.example.gq.ma.bean.History;
import com.example.gq.ma.bean.Robot;
import com.example.gq.ma.model.RobotModel;
import com.example.gq.ma.presenter.inter.TransportPresenterInter;
import com.example.gq.ma.view.inter.RobotViewInter;

import java.util.ArrayList;
import java.util.List;

public class TransportPresenter implements TransportPresenterInter {

    private RobotViewInter robotViewInter;
    private RobotModel mRobotModel;

    public TransportPresenter(RobotViewInter robotViewInter) {
        this.robotViewInter = robotViewInter;
        mRobotModel = RobotModel.getInstance();
    }

    @Override
    public List<Robot> loadTransportRobots() {
        List<Robot> robots = mRobotModel.getRobotList();
        List<Robot> transportRobots = new ArrayList<>();
        for (Robot robot : robots) {
            if (robot.isDetect())
                transportRobots.add(robot);
        }
        return transportRobots;
    }

    @Override
    public List<History> loadTransportRobotHistoryByID(int id) {
        Robot robot = mRobotModel.getRobotByID(id, true);
        return robot.getHistories();
    }

    @Override
    public void loadTransportRobotInfo(List<Robot> robotList, int position) {
        Robot robot = robotList.get(position);
        String id = Integer.toString(robot.getId());
        String name = robot.getName();
        String distance = robot.getDistance() + " m";
        String electric = robot.getElectric() + " A";
        robotViewInter.onShowInfo(id, name, distance, electric);
    }
}
