package com.example.geetion.rxnews.Picture;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.geetion.rxnews.Model.PictureArticle;
import com.example.geetion.rxnews.R;

import java.util.ArrayList;

/**
 * Created by Geetion on 16/4/22.
 */
public class PicturesRecyclerViewAdapter extends RecyclerView.Adapter<PicturesRecyclerViewAdapter.ViewHolder> {

    private ArrayList<PictureArticle> marticles = new ArrayList<>();

    public PicturesRecyclerViewAdapter(ArrayList<PictureArticle> articles){
        marticles = articles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.picture_viewholder,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PictureArticle article = marticles.get(position);
        holder.title.setText(article.title);
    }

    @Override
    public int getItemCount() {
        return marticles.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.picture_vh_title);
        }
    }
}
