package com.example.gq.ma.view.inter;

import com.example.gq.ma.bean.History;
import com.example.gq.ma.bean.Robot;

public interface DetectViewInter {

    void onShowInfo(String id, String name, String distance, String electric);
    void onShowHistory(History history);
}
