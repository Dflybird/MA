package com.example.gq.ma.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.gq.ma.R;
import com.example.gq.ma.bean.History;

import java.util.List;

public class HistoryListAdapter extends ArrayAdapter<History> {
    private Context context;
    private int resource;

    public HistoryListAdapter(@NonNull Context context, int resource, @NonNull List<History> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder viewHolder;
            History history = getItem(position);

            if (convertView == null){
                convertView = LayoutInflater.from(context).inflate(resource, null);
                viewHolder = new ViewHolder();
                viewHolder.targetTV = convertView.findViewById(R.id.detect_robot_target_tv);
                viewHolder.dateTV = convertView.findViewById(R.id.detect_robot_date_tv);
                convertView.setTag(viewHolder);
            }else
                viewHolder = (ViewHolder) convertView.getTag();

            viewHolder.targetTV.setText(history.getTarget());
            viewHolder.dateTV.setText(history.getDate());
        return convertView;
    }

    class ViewHolder{
        TextView targetTV;
        TextView dateTV;
    }
}
