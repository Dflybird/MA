package com.example.gq.ma.model.inter;

import com.example.gq.ma.bean.Robot;

import java.util.List;

public interface RobotModelInter {

    List<Robot> getRobotList();
    Robot getRobotByID(int id, boolean isEager);
}
