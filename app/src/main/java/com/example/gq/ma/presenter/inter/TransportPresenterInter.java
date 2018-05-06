package com.example.gq.ma.presenter.inter;

import com.example.gq.ma.bean.History;
import com.example.gq.ma.bean.Robot;

import java.util.List;

public interface TransportPresenterInter {

    List<Robot> loadTransportRobots();
    List<History> loadTransportRobotHistoryByID(int id);
    void loadTransportRobotInfo(List<Robot> robotList, int position );
}
