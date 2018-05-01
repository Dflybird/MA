package com.example.gq.ma.presenter.inter;

import com.example.gq.ma.bean.Robot;

import java.util.List;

public interface DetectPresenterInter {

    List<Robot> loadDetectRobots();
    void loadDetectRobotInfo(List<Robot> robotList, int position );
}
