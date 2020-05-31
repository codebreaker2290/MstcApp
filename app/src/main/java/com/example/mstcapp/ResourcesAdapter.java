package com.example.mstcapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ResourcesAdapter extends RecyclerView.Adapter<ResourcesAdapter.ResourcesView> {
     static List<String> domains= new ArrayList<>();


    public ResourcesAdapter(List<String> domains) {
        this.domains = domains;    //constructor used for initialising the list in the the view
    }

    @NonNull
    @Override
    public ResourcesView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //fills the view with card view layout made (row_domains)
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_domains,parent,false);
        return new ResourcesView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResourcesView holder, int position) {
        holder.texttitle.setText(domains.get(position));        //sets the list to the holder


    }

    @Override
    public int getItemCount() {
        return domains.size(); //size of the list
    }

    public static class ResourcesView extends RecyclerView.ViewHolder{

        TextView texttitle;
        public ResourcesView(@NonNull View itemView) {
            super(itemView);
            texttitle=(TextView)itemView.findViewById(R.id.domaintitle);

            //OnClick Listener to go to the resource page of the particular domain when clicked

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i =new Intent(v.getContext(), ResourcesDetails.class);
                    i.putExtra("test",domains.get(getAdapterPosition()));
                    v.getContext().startActivity(i);
                }
            });
        }
    }
}