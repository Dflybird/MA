package com.example.gq.ma.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.gq.ma.R;
import com.example.gq.ma.adapter.TaskExpandableListAdapter;
import com.example.gq.ma.base.BaseFragment;
import com.example.gq.ma.bean.Task;
import com.example.gq.ma.presenter.TaskPresenter;
import com.example.gq.ma.utils.GLog;
import com.example.gq.ma.view.inter.TaskViewInter;

import java.util.List;

public class TaskFragment extends BaseFragment implements TaskViewInter {

    private ExpandableListView mExpandableListView;
    private TaskChildFragment mChildFragment;

    private TaskExpandableListAdapter mExpandableListAdapter;
    private TaskPresenter mTaskPresenter;

    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        mTaskPresenter = new TaskPresenter(this);
    }

    @Override
    public int getResourceID() {
        return R.layout.fragment_task;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        mChildFragment = new TaskChildFragment();
        mExpandableListView = view.findViewById(R.id.task_expandable_lv);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTaskPresenter.loadTaskList();
    }

    @Override
    public void onShowTaskList(final List<Task> detectTasks, final List<Task> transportTasks) {
        mExpandableListAdapter = new TaskExpandableListAdapter(context, detectTasks, transportTasks);
        mExpandableListView.setAdapter(mExpandableListAdapter);
        mExpandableListView.setGroupIndicator(null);
        mExpandableListView.setDivider(null);
        mExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });
        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                if (mChildFragment.isAdded()){
                    GLog.d("fragment already existing");
                } else {
                    FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                    transaction.add(R.id.task_child_fg,mChildFragment).commit();
                }
                boolean isDetect = groupPosition == 0;
                int taskID;
                if (isDetect) {
                    taskID = detectTasks.get(childPosition).getId();
                }
                else {
                    taskID = transportTasks.get(childPosition).getId();
                }
                mChildFragment.refresh(taskID, isDetect);
                return true;
            }
        });
    }

    @Override
    public void onRefreshTaskItem() {

    }

    @Override
    public void onShowTask() {

    }
}
