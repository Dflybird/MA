package com.example.gq.ma.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gq.ma.R;
import com.example.gq.ma.bean.Target;

import java.util.List;
import java.util.Random;

public class TargetListAdapter extends ArrayAdapter<Target> {

    private Context context;
    private int resource;
    Random random;

    public TargetListAdapter(@NonNull Context context, int resource, @NonNull List<Target> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        random = new Random();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        Target target = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(resource, null);
            viewHolder = new ViewHolder();
            viewHolder.iconIV = convertView.findViewById(R.id.t_icon_lv_im);
            viewHolder.idTV = convertView.findViewById(R.id.t_id_lv_tv);
            viewHolder.nameTV = convertView.findViewById(R.id.t_name_lv_tv);
            viewHolder.timeTV = convertView.findViewById(R.id.t_time_lv_tv);
            convertView.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.idTV.setText(Integer.toString(target.getId()));
        viewHolder.nameTV.setText(target.getName());
        viewHolder.timeTV.setText(target.getLastTransportTime());

        switch (random.nextInt()%5){
            case 1:
                viewHolder.iconIV.setImageResource(R.drawable.target_1);
                break;
            case 2:
                viewHolder.iconIV.setImageResource(R.drawable.target_2);
                break;
            case 3:
                viewHolder.iconIV.setImageResource(R.drawable.target_3);
                break;
            case 4:
                viewHolder.iconIV.setImageResource(R.drawable.target_4);
                break;
            case 0:
                viewHolder.iconIV.setImageResource(R.drawable.target_5);
                break;
            default:
                break;
        }



        return convertView;
    }


    class ViewHolder{
        ImageView iconIV;
        TextView idTV;
        TextView nameTV;
        TextView timeTV;
    }
}
