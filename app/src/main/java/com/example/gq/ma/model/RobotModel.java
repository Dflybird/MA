package com.example.gq.ma.model;

import com.example.gq.ma.bean.Robot;
import com.example.gq.ma.model.inter.RobotModelInter;

import org.litepal.crud.DataSupport;

import java.util.List;

public class RobotModel implements RobotModelInter {

    private static RobotModel instance = new RobotModel();

    public static RobotModel getInstance() {
        return instance;
    }


    @Override
    public List<Robot> getRobotList() {
        return DataSupport.findAll(Robot.class, true);
    }

    @Override
    public Robot getRobotByID(int id, boolean isEager) {
        if (isEager)
            return DataSupport.find(Robot.class, id, true);
        else
            return DataSupport.find(Robot.class, id);
    }
}
