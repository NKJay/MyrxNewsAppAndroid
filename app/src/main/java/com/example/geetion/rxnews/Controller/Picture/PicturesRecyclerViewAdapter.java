package com.example.geetion.rxnews.Controller.Picture;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.geetion.rxnews.Model.PictureArticle;
import com.example.geetion.rxnews.NetWorkRequest.NetWorkUtils;
import com.example.geetion.rxnews.R;
import com.example.geetion.rxnews.Controller.RecyclerViewOnClickInterface;

import java.util.ArrayList;

/**
 * Created by Geetion on 16/4/22.
 */
public class PicturesRecyclerViewAdapter extends RecyclerView.Adapter<PicturesRecyclerViewAdapter.ViewHolder> {

    private ArrayList<PictureArticle> marticles = new ArrayList<>();
    private RecyclerViewOnClickInterface mrecyclerViewOnClickInterface;

    public PicturesRecyclerViewAdapter(ArrayList<PictureArticle> articles,RecyclerViewOnClickInterface recyclerViewOnClickInterface){
        marticles = articles;
        mrecyclerViewOnClickInterface = recyclerViewOnClickInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.picture_viewholder,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        PictureArticle article = marticles.get(position);
        holder.title.setText(article.title);
        NetWorkUtils.loadUrlImage(article.thumb,holder.image);

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


    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.picture_vh_title);
            image = (ImageView) itemView.findViewById(R.id.picture_vh_image);
        }
    }
}
