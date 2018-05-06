package com.example.gq.ma.presenter;

import com.example.gq.ma.bean.Target;
import com.example.gq.ma.model.TargetModel;
import com.example.gq.ma.presenter.inter.TargetPresenterInter;
import com.example.gq.ma.view.inter.TargetViewInter;

import java.util.List;

public class TargetPresenter implements TargetPresenterInter {

    private TargetViewInter targetViewInter;
    private TargetModel targetModel;

    public TargetPresenter(TargetViewInter targetViewInter) {
        this.targetViewInter = targetViewInter;
        targetModel = TargetModel.getInstance();
    }

    @Override
    public List<Target> loadTargets() {
        return targetModel.getTargetList();
    }

    @Override
    public void loadTargetInfoByID(int id) {
        Target target = targetModel.getTargetByID(id, false);
        targetViewInter.onShowTargetTitle(Integer.toString(id), target.getName());
        targetViewInter.onShowTargetInfo(target.getLocation(), target.isTransport(), target.getLastTransportTime());
    }

    @Override
    public void addTarget(String name, String location, String lastTransportTime, boolean isTransport) {
        Target target = new Target();
        target.setName(name);
        target.setLocation(location);
        target.setLastTransportTime(lastTransportTime);
        target.setTransport(isTransport);
        targetModel.insertTarget(target);
    }
}
