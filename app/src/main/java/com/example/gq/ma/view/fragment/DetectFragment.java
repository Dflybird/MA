package com.example.gq.ma.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gq.ma.R;
import com.example.gq.ma.adapter.DetectRecyclerAdapter;
import com.example.gq.ma.base.BaseFragment;
import com.example.gq.ma.bean.History;
import com.example.gq.ma.bean.Robot;
import com.example.gq.ma.presenter.DetectPresenter;
import com.example.gq.ma.view.RecyclerViewDecoration;
import com.example.gq.ma.view.inter.DetectViewInter;

import java.util.List;

public class DetectFragment extends BaseFragment implements DetectViewInter{

    private Context context;

    private TextView robotIDTV;
    private TextView robotNameTV;
    private TextView robotDistanceTV;
    private TextView robotElectricTV;
    private ListView historyLV;
    private RecyclerView detectRobotRV;

    private DetectRecyclerAdapter mDetectRecyclerAdapter;
    private DetectPresenter mDetectPresenter;

    private List<Robot> detectRobotList;

    @Override
    public int getResourceID() {
        return R.layout.fragment_detect;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        robotIDTV = view.findViewById(R.id.robot_id_tv);
        robotNameTV = view.findViewById(R.id.robot_name_tv);
        robotDistanceTV = view.findViewById(R.id.robot_distance_tv);
        robotElectricTV = view.findViewById(R.id.robot_electric_tv);
        historyLV = view.findViewById(R.id.detect_history_lv);
        detectRobotRV = view.findViewById(R.id.detect_robot_rv);

        //recyclerView
        mDetectRecyclerAdapter = new DetectRecyclerAdapter(context, detectRobotList);
        detectRobotRV.addItemDecoration(new RecyclerViewDecoration(context));
        detectRobotRV.setLayoutManager(new GridLayoutManager(context, 6));
        mDetectRecyclerAdapter.setOnItemClickListener(new DetectRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClickListener(View view, int position) {
                mDetectPresenter.loadDetectRobotInfo(detectRobotList, position);
            }
        });
        detectRobotRV.setAdapter(mDetectRecyclerAdapter);
        detectRobotRV.setItemAnimator(new DefaultItemAnimator());

        //历史数据表

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        mDetectPresenter = new DetectPresenter(this);
        detectRobotList = mDetectPresenter.loadDetectRobots();
    }

    @Override
    public void onShowInfo(String id, String name, String distance, String electric) {
        robotIDTV.setText(id);
        robotNameTV.setText(name);
        robotDistanceTV.setText(distance);
        robotElectricTV.setText(electric);
    }

    @Override
    public void onShowHistory(History history) {

    }
}
