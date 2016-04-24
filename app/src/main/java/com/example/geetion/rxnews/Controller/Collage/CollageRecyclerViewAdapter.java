package com.example.geetion.rxnews.Controller.Collage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.geetion.rxnews.Model.CollageArticle;
import com.example.geetion.rxnews.R;
import com.example.geetion.rxnews.Controller.RecyclerViewOnClickInterface;

import java.util.ArrayList;

/**
 * Created by Geetion on 16/4/23.
 */
public class CollageRecyclerViewAdapter extends RecyclerView.Adapter<CollageRecyclerViewAdapter.Viewholder>{

    private ArrayList<CollageArticle> marticles = new ArrayList<>();
    private RecyclerViewOnClickInterface mrecyclerViewOnClickInterface;

    public CollageRecyclerViewAdapter(ArrayList<CollageArticle> articles,RecyclerViewOnClickInterface recyclerViewOnClickInterface){
        mrecyclerViewOnClickInterface = recyclerViewOnClickInterface;
        marticles = articles;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.collage_viewholder,parent,false);
        Viewholder viewholder = new Viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, final int position) {
        CollageArticle article = marticles.get(position);
        holder.title.setText(article.title);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mrecyclerViewOnClickInterface.onItemClickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return marticles.size();
    }


    class Viewholder extends RecyclerView.ViewHolder{

        public TextView title;

        public Viewholder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.collage_vh_title);
        }
    }


}
