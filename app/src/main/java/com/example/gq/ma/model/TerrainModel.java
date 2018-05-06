package com.example.gq.ma.model;

import com.example.gq.ma.bean.Terrain;
import com.example.gq.ma.model.inter.TerrainModelInter;

import org.litepal.crud.DataSupport;

import java.util.List;

public class TerrainModel implements TerrainModelInter {

    private static TerrainModel instance = new TerrainModel();

    public static TerrainModel getInstance(){
        return instance;
    }

    @Override
    public List<Terrain> getTerrainList() {
        return DataSupport.findAll(Terrain.class);
    }

    @Override
    public Terrain getTerrainByID(int id, boolean isEager) {
        if (isEager)
            return DataSupport.find(Terrain.class, id, true);
        else
            return DataSupport.find(Terrain.class, id);
    }
}
