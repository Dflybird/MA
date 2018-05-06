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
import com.example.gq.ma.bean.Terrain;
import com.example.gq.ma.utils.GLog;

import java.util.List;
import java.util.Random;

public class TerrainListAdapter extends ArrayAdapter<Terrain> {

    private Context context;
    private int resource;
    Random random;

    public TerrainListAdapter(@NonNull Context context, int resource, @NonNull List<Terrain> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        random = new Random();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        Terrain terrain = getItem(position);
        GLog.d(terrain.toString());

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
            viewHolder.idTV.setText(Integer.toString(terrain.getId()));
            viewHolder.nameTV.setText(terrain.getName());
            viewHolder.timeTV.setText(terrain.getLastDetectTime());
        int i = random.nextInt()%5;
        switch (i){
            case 1:
                viewHolder.iconIV.setImageResource(R.drawable.terrain_1);
                break;
            case 2:
                viewHolder.iconIV.setImageResource(R.drawable.terrain_2);
                break;
            case 3:
                viewHolder.iconIV.setImageResource(R.drawable.terrain_3);
                break;
            case 4:
                viewHolder.iconIV.setImageResource(R.drawable.terrain_4);
                break;
            case 0:
                viewHolder.iconIV.setImageResource(R.drawable.terrain_5);
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
