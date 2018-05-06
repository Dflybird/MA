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
import com.example.gq.ma.adapter.HistoryListAdapter;
import com.example.gq.ma.adapter.TransportRecyclerAdapter;
import com.example.gq.ma.base.BaseFragment;
import com.example.gq.ma.bean.History;
import com.example.gq.ma.bean.Robot;
import com.example.gq.ma.presenter.TransportPresenter;
import com.example.gq.ma.view.RecyclerViewDecoration;
import com.example.gq.ma.view.inter.RobotViewInter;

import java.util.List;

public class TransportFragment extends BaseFragment implements RobotViewInter {

    private Context context;

    private TextView robotIDTV;
    private TextView robotNameTV;
    private TextView robotDistanceTV;
    private TextView robotElectricTV;
    private ListView historyLV;
    private RecyclerView transportRV;
    private TextView titleTV;

    private TransportRecyclerAdapter mTransportRecyclerAdapter;
    private TransportPresenter mTransportPresenter;
    private HistoryListAdapter mHistoryListAdapter;

    private List<Robot> transportRobotList;
    private List<History> transportHistoryList;

    @Override
    public int getResourceID() {
        return R.layout.fragment_rr;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        robotIDTV = view.findViewById(R.id.rr_id_tv);
        robotNameTV =  view.findViewById(R.id.rr_name_tv);
        robotDistanceTV = view.findViewById(R.id.rr_distance_tv);
        robotElectricTV = view.findViewById(R.id.rr_electric_tv);
        historyLV = view.findViewById(R.id.rr_history_lv);
        transportRV = view.findViewById(R.id.rr_rv);
        titleTV = view.findViewById(R.id.rr_title_tv);
        titleTV.setText("运输 > 机器人");

        mTransportRecyclerAdapter = new TransportRecyclerAdapter(context, transportRobotList, false);
        transportRV.addItemDecoration(new RecyclerViewDecoration(context));
        transportRV.setLayoutManager(new GridLayoutManager(context, 6));
        mTransportRecyclerAdapter.setOnItemClickListener(new TransportRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClickListener(View view, int position) {
                mTransportPresenter.loadTransportRobotInfo(transportRobotList, position);

                transportHistoryList = mTransportPresenter.loadTransportRobotHistoryByID(transportRobotList.get(position).getId());
                mHistoryListAdapter = new HistoryListAdapter(context, R.layout.item_history, transportHistoryList);
                historyLV.setAdapter(mHistoryListAdapter);
            }
        });
        transportRV.setAdapter(mTransportRecyclerAdapter);
        transportRV.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        mTransportPresenter = new TransportPresenter(this);
        transportRobotList = mTransportPresenter.loadTransportRobots();
    }

    @Override
    public void onShowInfo(String id, String name, String distance, String electric) {
        robotIDTV.setText(id);
        robotNameTV.setText(name);
        robotDistanceTV.setText(distance);
        robotElectricTV.setText(electric);
    }

    @Override
    public void onShowHistory(List<History> historyList) {

    }
}
