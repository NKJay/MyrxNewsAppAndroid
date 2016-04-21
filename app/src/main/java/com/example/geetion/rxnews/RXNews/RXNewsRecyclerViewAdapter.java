package com.example.geetion.rxnews.RXNews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Geetion on 16/4/20.
 */
import com.example.geetion.rxnews.R;

public class RXNewsRecyclerViewAdapter extends RecyclerView.Adapter<RXNewsRecyclerViewAdapter.MyViewHolder> {

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rxnews_viewholder,parent);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;

        public TextView title;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.rxnews_vh_imageView);
            title = (TextView) itemView.findViewById(R.id.rxnews_vh_title);
        }
    }
}
