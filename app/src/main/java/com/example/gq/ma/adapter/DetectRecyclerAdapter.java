package com.example.gq.ma.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.gq.ma.R;
import com.example.gq.ma.bean.Robot;

import java.util.List;

public class DetectRecyclerAdapter extends RecyclerView.Adapter<DetectRecyclerAdapter.DetectViewHolder> {

    private Context context;
    private List<Robot> detectRobotList;
    private OnItemClickListener mOnItemClickListener;
    private boolean isDetect;

    public DetectRecyclerAdapter(Context context, List<Robot> detectRobotList, boolean isDetect) {
        this.context = context;
        this.detectRobotList = detectRobotList;
        this.isDetect = isDetect;
    }

    @NonNull
    @Override
    public DetectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DetectViewHolder(LayoutInflater.from(context).inflate(R.layout.item_r_rv, null));
    }

    @Override
    public void onBindViewHolder(@NonNull final DetectViewHolder holder, final int position) {
        if (isDetect)
            holder.detectRobotIV.setImageResource(R.drawable.detect_robot);
        else
            holder.detectRobotIV.setImageResource(R.drawable.transport_robot);
        holder.detectRobotIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.onClickListener(holder.detectRobotIV, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return detectRobotList.size();
    }

    class DetectViewHolder extends RecyclerView.ViewHolder{

        ImageView detectRobotIV;

        public DetectViewHolder(View itemView) {
            super(itemView);
            detectRobotIV = itemView.findViewById(R.id.rr_item_im);
        }
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    public interface OnItemClickListener{
        void onClickListener(View view, int position);
    }
}
