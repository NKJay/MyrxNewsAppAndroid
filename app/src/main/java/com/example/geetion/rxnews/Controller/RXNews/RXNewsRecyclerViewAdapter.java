package com.example.geetion.rxnews.Controller.RXNews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Geetion on 16/4/20.
 */
import com.example.geetion.rxnews.Model.NormalRXNewsArticle;
import com.example.geetion.rxnews.R;
import com.example.geetion.rxnews.Controller.RecyclerViewOnClickInterface;

import java.util.ArrayList;

public class RXNewsRecyclerViewAdapter extends RecyclerView.Adapter<RXNewsRecyclerViewAdapter.ViewHolder> {

    private ArrayList<NormalRXNewsArticle> marticles = new ArrayList<>();
    private RecyclerViewOnClickInterface mrecyclerViewOnClickInterface;

    public RXNewsRecyclerViewAdapter(ArrayList<NormalRXNewsArticle> articles,RecyclerViewOnClickInterface recyclerViewOnClickInterface){
        marticles = articles;
        mrecyclerViewOnClickInterface = recyclerViewOnClickInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rxnews_viewholder,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return marticles.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        NormalRXNewsArticle article = marticles.get(position);
        holder.title.setText(article.title);
        
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mrecyclerViewOnClickInterface.onItemClickListener(position);
            }
        });
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;

        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.rxnews_vh_imageView);
            title = (TextView) itemView.findViewById(R.id.rxnews_vh_title);
        }
    }
}
