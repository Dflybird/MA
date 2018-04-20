package com.example.gq.ma.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TaskExpandableListAdapter extends BaseExpandableListAdapter {

    private String groupStrings[] = {"探测", "运输"};

    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

//
//    private String groupStrings[] = {"发现", "攻击"};
//    private List<Task> attackTask = new ArrayList<>();
//    private List<Task> investigateTask = new ArrayList<>();
//
//    private int investigateGroupCount;
//    private int attackGroupCount;
//
//    private Context context;
//
//    public MyExpandableListAdapter(List<Task> list, Context context) {
//        this.context = context;
//        for (Task t:list) {
//            if (t.getType() == Task.TaskType.INVESTIGATE)
//                investigateTask.add(t);
//            else attackTask.add(t);
//        }
//        investigateGroupCount = investigateTask.size();
//        attackGroupCount = attackTask.size();
//    }
//
//    @Override
//    public int getGroupCount() {
//        return groupStrings.length;
//    }
//
//    @Override
//    public int getChildrenCount(int groupPosition) {
//        return groupPosition == INVESTIGATE_GROUP ?
//                investigateGroupCount : attackGroupCount;
//    }
//
//    @Override
//    public Object getGroup(int groupPosition) {
//        return groupStrings[groupPosition];
//    }
//
//    @Override
//    public Object getChild(int groupPosition, int childPosition) {
//        return groupPosition == INVESTIGATE_GROUP ?
//                investigateTask.get(childPosition) :
//                attackTask.get(childPosition);
//    }
//
//    @Override
//    public long getGroupId(int groupPosition) {
//        return groupPosition;
//    }
//
//    @Override
//    public long getChildId(int groupPosition, int childPosition) {
//        return childPosition;
//    }
//
//    @Override
//    public boolean hasStableIds() {
//        return true;
//    }
//
//    @Override
//    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//        GroupViewHolder groupViewHolder;
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.expandable_item, parent, false);
//            groupViewHolder = new GroupViewHolder();
//            groupViewHolder.tvTitle = convertView.findViewById(R.id.expand_item_tv);
//            convertView.setTag(groupViewHolder);
//        } else
//            groupViewHolder = (GroupViewHolder) convertView.getTag();
//        String tvStr;
//        if (groupPosition == INVESTIGATE_GROUP)
//            tvStr = "侦查任务";
//        else tvStr = "攻击任务";
//        groupViewHolder.tvTitle.setText(tvStr);
//        return convertView;
//    }
//
//    @Override
//    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//        ChildViewHolder childViewHolder;
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.expandable_item, parent,false);
//            childViewHolder = new ChildViewHolder();
//            childViewHolder.tvTitle = convertView.findViewById(R.id.expand_item_tv);
//            convertView.setTag(childViewHolder);
//        } else
//            childViewHolder = (ChildViewHolder) convertView.getTag();
//
//        StringBuilder builder = new StringBuilder();
//        builder.append(groupStrings[groupPosition]);
//        if (groupPosition == INVESTIGATE_GROUP) {
//            builder.append(investigateTask.get(childPosition).getInvestigateTarget().getName());
//        } else {
//            builder.append(attackTask.get(childPosition).getAttackTarget().getName());
//        }
//        String tvStr = builder.toString();
//        childViewHolder.tvTitle.setText(tvStr);
//        return convertView;
//    }
//
//    @Override
//    public boolean isChildSelectable(int groupPosition, int childPosition) {
//        return true;
//    }
//
//    class GroupViewHolder {
//        TextView tvTitle;
//    }
//
//    class ChildViewHolder {
//        TextView tvTitle;
//    }
}
