package com.example.gq.ma.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.gq.ma.R;
import com.example.gq.ma.bean.Task;

import java.util.List;

public class TaskExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private String groupStrings[] = {"探测", "运输"};
    private List<Task> detectTasks;
    private List<Task> transportTasks;

    public TaskExpandableListAdapter(Context context, List<Task> detectTasks, List<Task> transportTasks) {
        this.context = context;
        this.detectTasks = detectTasks;
        this.transportTasks = transportTasks;
    }

    @Override
    public int getGroupCount() {
        return 2;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (groupPosition == 0)
            return detectTasks.size();
        else if (groupPosition == 1)
            return transportTasks.size();
        else return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupStrings[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        if (groupPosition == 0)
            return detectTasks.get(childPosition);
        else if (groupPosition == 1)
            return transportTasks.get(childPosition);
        else return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        if (groupPosition == 0)
            return detectTasks.get(childPosition).getId();
        else if (groupPosition == 1)
            return transportTasks.get(childPosition).getId();
        else return 0;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            groupViewHolder = new GroupViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.task_expandable_item, parent, false);
            groupViewHolder.groupTV = convertView.findViewById(R.id.task_expandable_tv);
            convertView.setTag(groupViewHolder);
        }
        else
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        groupViewHolder.groupTV.setText(groupStrings[groupPosition]);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.task_expandable_item,parent,false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.childTV = convertView.findViewById(R.id.task_expandable_tv);
            convertView.setTag(childViewHolder);
        }
        else
            childViewHolder = (ChildViewHolder) convertView.getTag();
        if (groupPosition == 0)
            childViewHolder.childTV.setText(detectTasks.get(childPosition).getTitle());
        else if (groupPosition == 1)
            childViewHolder.childTV.setText(transportTasks.get(childPosition).getTitle());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupViewHolder{
        TextView groupTV;
    }

    class ChildViewHolder{
        TextView childTV;
    }
}
