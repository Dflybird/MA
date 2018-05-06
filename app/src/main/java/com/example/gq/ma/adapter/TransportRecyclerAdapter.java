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

public class TransportRecyclerAdapter extends RecyclerView.Adapter<TransportRecyclerAdapter.TransportViewHolder> {

    private Context context;
    private List<Robot> transportRobotList;
    private OnItemClickListener mOnItemClickListener;
    private boolean isDetect;

    public TransportRecyclerAdapter(Context context, List<Robot> transportRobotList, boolean isDetect) {
        this.context = context;
        this.transportRobotList = transportRobotList;
        this.isDetect = isDetect;
    }

    @NonNull
    @Override
    public TransportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TransportViewHolder(LayoutInflater.from(context).inflate(R.layout.item_r_rv, null));
    }

    @Override
    public void onBindViewHolder(@NonNull final TransportViewHolder holder, final int position) {
        if (isDetect)
            holder.transportRobotIV.setImageResource(R.drawable.detect_robot);
        else
            holder.transportRobotIV.setImageResource(R.drawable.transport_robot);
        holder.transportRobotIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null){
                    mOnItemClickListener.onClickListener(holder.transportRobotIV, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return transportRobotList.size();
    }

    class TransportViewHolder extends RecyclerView.ViewHolder{

        ImageView transportRobotIV;

        public TransportViewHolder(View itemView) {
            super(itemView);
            transportRobotIV = itemView.findViewById(R.id.rr_item_im);
        }
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    public interface OnItemClickListener{
        void onClickListener(View view, int position);
    }
}
