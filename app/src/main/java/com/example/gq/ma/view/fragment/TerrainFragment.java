package com.example.gq.ma.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gq.ma.R;
import com.example.gq.ma.adapter.TerrainListAdapter;
import com.example.gq.ma.base.BaseFragment;
import com.example.gq.ma.bean.Terrain;
import com.example.gq.ma.presenter.TerrainPresenter;
import com.example.gq.ma.presenter.inter.TerrainPresenterInter;
import com.example.gq.ma.view.activity.AddTActivity;
import com.example.gq.ma.view.activity.EditTActivity;
import com.example.gq.ma.view.inter.TerrainViewInter;
import com.getbase.floatingactionbutton.AddFloatingActionButton;

import java.util.List;

public class TerrainFragment extends BaseFragment implements TerrainViewInter {
    private Context context;

    private TextView idTV;
    private TextView nameTV;
    private TextView locationTV;
    private TextView completeTV;
    private TextView timeTV;
    private ListView tListView;
    private TextView titleTv;
    private AddFloatingActionButton addFloatBT;
    private ImageView editIV;
    private ImageView deleteIV;

    private List<Terrain> terrainList;

    private TerrainListAdapter mTerrainListAdapter;
    private TerrainPresenter mTerrainPresenter;

    @Override
    public int getResourceID() {
        return R.layout.fragment_tt;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        idTV = view.findViewById(R.id.t_id_tv);
        nameTV = view.findViewById(R.id.t_name_tv);
        locationTV = view.findViewById(R.id.t_location_tv);
        completeTV = view.findViewById(R.id.t_complete_tv);
        timeTV = view.findViewById(R.id.t_time_tv);
        tListView = view.findViewById(R.id.tt_lv);
        titleTv = view.findViewById(R.id.tt_title_tv);
        addFloatBT = view.findViewById(R.id.t_add_float_bt);
        editIV = view.findViewById(R.id.t_edit_im);
        deleteIV = view.findViewById(R.id.t_delete_im);
        titleTv.setText("探测 > 目标地");

        mTerrainListAdapter = new TerrainListAdapter(context, R.layout.item_t_lv, terrainList);
        tListView.setAdapter(mTerrainListAdapter);
        tListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                mTerrainPresenter.loadTerrainInfoByID(terrainList.get(position).getId());
                editIV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Terrain terrain = terrainList.get(position);
                        EditTActivity.TerrainActionStart(context, terrain.getId(), terrain.getName(),
                                terrain.getLocation(), terrain.getLastDetectTime(), terrain.isDetect());
                    }
                });

                deleteIV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        terrainList.remove(position);
                        mTerrainListAdapter.notifyDataSetChanged();
                        tListView.invalidate();
                    }
                });
            }
        });

        addFloatBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddTActivity.terrainActionStart(context);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        mTerrainPresenter = new TerrainPresenter(this);
        terrainList = mTerrainPresenter.loadTerrains();
    }

    @Override
    public void onShowTerrainTitle(String id, String name) {
        idTV.setText(id);
        nameTV.setText(name);
    }

    @Override
    public void onShowTerrainInfo(String location, boolean isComplete, String time) {
        locationTV.setText(location);
        completeTV.setText(isComplete ? "是" : "否");
        timeTV.setText(time);
    }
}
