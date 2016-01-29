package com.example.geetion.rxnewsappandroid.rxNews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.geetion.rxnewsappandroid.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Geetion on 16/1/21.
 */
public class rxNewsAdapter extends RecyclerView.Adapter<rxNewsAdapter.MyViewHolder> {

    private ArrayList<rxNewsItem> list = new ArrayList<>();

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
//        ViewHolder holder = new ViewHolder(LayoutInflater.from(
//                rxNewsAdapter.this).inflate(R.layout.rxnewsviewholder, parent,
//                false));
        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.rxnewsviewholder, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    public rxNewsAdapter( ArrayList<rxNewsItem> myList){
        this.list = myList;
    }

    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        rxNewsItem item = list.get(position);

        holder.title.setText(item.title);
        holder.info.setText(item.info);
        holder.click.setText(String.valueOf(item.click));

    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView title;
        TextView info;
        TextView click;

        public MyViewHolder(View view)
        {
            super(view);

            click = (TextView)view.findViewById(R.id.click);
            title = (TextView)view.findViewById(R.id.title);
            info = (TextView)view.findViewById(R.id.info);
        }
    }
}
