package com.example.gq.ma.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gq.ma.R;
import com.example.gq.ma.adapter.TargetListAdapter;
import com.example.gq.ma.base.BaseFragment;
import com.example.gq.ma.bean.Target;
import com.example.gq.ma.presenter.TargetPresenter;
import com.example.gq.ma.view.inter.TargetViewInter;

import java.util.List;

public class TargetFragment extends BaseFragment implements TargetViewInter {

    private Context context;

    private TextView idTV;
    private TextView nameTV;
    private TextView locationTV;
    private TextView completeTV;
    private TextView timeTV;
    private ListView tListView;
    private TextView titleTv;

    private List<Target> targetList;

    private TargetListAdapter mTargetListAdapter;
    private TargetPresenter mTargetPresenter;

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
        titleTv.setText("运输 > 目标物");

        mTargetListAdapter = new TargetListAdapter(context, R.layout.item_t_lv, targetList);
        tListView.setAdapter(mTargetListAdapter);
        tListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mTargetPresenter.loadTargetInfoByID(targetList.get(position).getId());
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        mTargetPresenter = new TargetPresenter(this);
        targetList = mTargetPresenter.loadTargets();
    }

    @Override
    public void onShowTargetTitle(String id, String name) {
        idTV.setText(id);
        nameTV.setText(name);
    }

    @Override
    public void onShowTargetInfo(String location, boolean isComplete, String time) {
        locationTV.setText(location);
        completeTV.setText(isComplete ? "是" : "否");
        timeTV.setText(time);
    }
}
