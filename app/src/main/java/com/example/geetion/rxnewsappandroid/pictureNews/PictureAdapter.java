package com.example.geetion.rxnewsappandroid.pictureNews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.geetion.rxnewsappandroid.R;

import java.util.ArrayList;

/**
 * Created by Geetion on 16/1/29.
 */
public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.MyViewHolder>{

    ArrayList<PictureItem> list = new ArrayList<>();

    public PictureAdapter(ArrayList<PictureItem> mList){
        list = mList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.picture_viewholder,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.click.setText(String.valueOf(list.get(position).click));
        holder.title.setText(list.get(position).title);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView click;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            click = (TextView)itemView.findViewById(R.id.click);
        }
    }
}
