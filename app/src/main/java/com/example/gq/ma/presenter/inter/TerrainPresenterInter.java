package com.example.gq.ma.presenter.inter;

import com.example.gq.ma.bean.Terrain;

import java.util.List;

public interface TerrainPresenterInter {

    List<Terrain> loadTerrains();
    void loadTerrainInfoByID(int id);
}
