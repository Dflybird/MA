package com.example.gq.ma.presenter.inter;

import com.example.gq.ma.bean.Target;

import java.util.List;

public interface TargetPresenterInter {
    List<Target> loadTargets();
    void loadTargetInfoByID(int id);
    void addTarget(String name, String location, String lastTransportTime, boolean isTransport);
}
