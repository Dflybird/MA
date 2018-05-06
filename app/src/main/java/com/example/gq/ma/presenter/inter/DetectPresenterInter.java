package com.example.gq.ma.presenter.inter;

import com.example.gq.ma.bean.History;
import com.example.gq.ma.bean.Robot;

import java.util.List;

public interface DetectPresenterInter {

    List<Robot> loadDetectRobots();
    List<History> loadDetectRobotHistoryByID(int id);
    void loadDetectRobotInfo(List<Robot> robotList, int position );
}
