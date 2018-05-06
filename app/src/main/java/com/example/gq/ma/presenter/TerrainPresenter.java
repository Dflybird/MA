package com.example.gq.ma.presenter;

import com.example.gq.ma.bean.Terrain;
import com.example.gq.ma.model.TerrainModel;
import com.example.gq.ma.presenter.inter.TerrainPresenterInter;
import com.example.gq.ma.view.inter.TerrainViewInter;

import java.util.List;

public class TerrainPresenter implements TerrainPresenterInter {

    private TerrainViewInter terrainViewInter;
    private TerrainModel terrainModel;

    public TerrainPresenter(TerrainViewInter terrainViewInter) {
        this.terrainViewInter = terrainViewInter;
        terrainModel = TerrainModel.getInstance();
    }

    @Override
    public List<Terrain> loadTerrains() {
        return terrainModel.getTerrainList();
    }

    @Override
    public void loadTerrainInfoByID(int id) {
        Terrain terrain = terrainModel.getTerrainByID(id, false);
        terrainViewInter.onShowTerrainTitle(Integer.toString(id), terrain.getName());
        terrainViewInter.onShowTerrainInfo(terrain.getLocation(), terrain.isDetect(), terrain.getLastDetectTime());
    }
}
