package com.example.geetion.rxnews.Collage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Geetion on 16/4/23.
 */
public class CollageRecyclerViewAdapter extends RecyclerView.Adapter {

    class MyViewholder extends RecyclerView.ViewHolder{

        public MyViewholder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
