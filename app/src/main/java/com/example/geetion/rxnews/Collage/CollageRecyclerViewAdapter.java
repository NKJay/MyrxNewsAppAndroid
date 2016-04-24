package com.example.geetion.rxnews.Collage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.geetion.rxnews.Model.CollageArticle;
import com.example.geetion.rxnews.R;
import com.example.geetion.rxnews.RecyclerViewOnClickInterface;

import java.util.ArrayList;

/**
 * Created by Geetion on 16/4/23.
 */
public class CollageRecyclerViewAdapter extends RecyclerView.Adapter<CollageRecyclerViewAdapter.MyViewholder>{

    private ArrayList<CollageArticle> marticles = new ArrayList<>();
    private RecyclerViewOnClickInterface recyclerViewOnClickInterface;

    public CollageRecyclerViewAdapter(ArrayList<CollageArticle> articles){
        marticles = articles;
    }

    class MyViewholder extends RecyclerView.ViewHolder{

        public TextView title;

        public MyViewholder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.collage_vh_title);
        }
    }


    @Override
    public MyViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.collage_viewholder,parent,false);
        MyViewholder myViewholder = new MyViewholder(view);
        return myViewholder;
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, final int position) {
        CollageArticle article = marticles.get(position);
        holder.title.setText(article.title);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerViewOnClickInterface.onItemClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return marticles.size();
    }
}
