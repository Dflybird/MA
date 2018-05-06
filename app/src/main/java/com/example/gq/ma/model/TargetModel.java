package com.example.gq.ma.model;

import com.example.gq.ma.bean.Target;
import com.example.gq.ma.model.inter.TargetModelInter;

import org.litepal.crud.DataSupport;

import java.util.List;

public class TargetModel implements TargetModelInter {

    private static TargetModel instance = new TargetModel();

    public static TargetModel getInstance(){
        return instance;
    }

    @Override
    public List<Target> getTargetList() {
        return DataSupport.findAll(Target.class);
    }

    @Override
    public Target getTargetByID(int id, boolean isEager) {
        if (isEager)
            return DataSupport.find(Target.class, id, true);
        else
            return DataSupport.find(Target.class, id);
    }

    @Override
    public boolean insertTarget(Target target) {
        return target.save();
    }
}
