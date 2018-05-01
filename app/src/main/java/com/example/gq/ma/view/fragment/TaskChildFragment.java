package com.example.gq.ma.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.gq.ma.R;
import com.example.gq.ma.base.BaseFragment;
import com.example.gq.ma.presenter.TaskChildPresenter;
import com.example.gq.ma.view.inter.TaskChildViewInter;

public class TaskChildFragment extends BaseFragment implements TaskChildViewInter {

    private TextView taskTitleTV;
    private TextView taskLocationTV;
    private TextView taskTimeTV;
    private TextView taskTeamTV;

    private TaskChildPresenter mTaskChildPresenter;

    private int taskID;
    private boolean isDetect;

    public void refresh(int taskID, boolean isDetect) {
        this.taskID = taskID;
        this.isDetect = isDetect;
    }

    @Override
    public int getResourceID() {
        return R.layout.fragment_task_child;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        taskTitleTV = view.findViewById(R.id.task_child_title_tv);
        taskLocationTV = view.findViewById(R.id.task_location_tv);
        taskTimeTV = view.findViewById(R.id.task_time_tv);
        taskTeamTV = view.findViewById(R.id.task_team_tv);

        mTaskChildPresenter = new TaskChildPresenter(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTaskChildPresenter.loadTask(taskID, isDetect);
    }

    @Override
    public void onRefresh(String title, String loc, String time,String team) {
        taskTitleTV.setText(title);
        taskLocationTV.setText(loc);
        taskTimeTV.setText(time);
        taskTeamTV.setText(team);
    }
}
