package com.example.gq.ma.model.inter;

import com.example.gq.ma.bean.Target;

import java.util.List;

public interface TargetModelInter {

    List<Target> getTargetList();

    Target getTargetByID(int id, boolean isEager);

    boolean insertTarget(Target target);
}
