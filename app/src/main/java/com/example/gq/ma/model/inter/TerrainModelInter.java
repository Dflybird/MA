package com.example.gq.ma.model.inter;

import com.example.gq.ma.bean.Terrain;

import java.util.List;

public interface TerrainModelInter {

    List<Terrain> getTerrainList();

    Terrain getTerrainByID(int id, boolean isEager);
}
