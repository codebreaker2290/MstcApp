package com.example.mstcapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstcapp.R;
import com.example.mstcapp.onlineFootprint.eventsFragments;

import java.util.List;

public class eventFragmentAdapter extends RecyclerView.Adapter<eventFragmentAdapter.myViewHolder> {

    Context mContext;
    List<eventsFragments> mData;

    public eventFragmentAdapter(Context mContext, List<eventsFragments> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.items_event,parent,false);
        myViewHolder vHolder=new myViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.tv_header.setText(mData.get(position).getHeader());
        holder.tv_descrip.setText(mData.get(position).getDescription());
        holder.image_event.setImageResource(mData.get(position).getPhoto());
        holder.tv_instaLink_event.setText(mData.get(position).getEvent_Insta_Link());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_header,tv_descrip,tv_instaLink_event;
        private ImageView image_event;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_header=(TextView)itemView.findViewById(R.id.tv__name_event);
            tv_descrip=(TextView)itemView.findViewById(R.id.tv_descr_event);
            image_event=(ImageView)itemView.findViewById(R.id.image_event);
            tv_instaLink_event=(TextView)itemView.findViewById(R.id.tv_link_event);
        }

    }
}
