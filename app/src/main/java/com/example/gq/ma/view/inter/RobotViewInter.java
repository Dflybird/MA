package com.example.gq.ma.view.inter;

import com.example.gq.ma.bean.History;
import com.example.gq.ma.bean.Robot;

import java.util.List;

public interface RobotViewInter {

    void onShowInfo(String id, String name, String distance, String electric);
    void onShowHistory(List<History> historyList);
}
