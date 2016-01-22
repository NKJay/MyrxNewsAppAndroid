package com.example.geetion.rxnewsappandroid;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Geetion on 16/1/21.
 */
public class rxNewsAdapter extends RecyclerView.Adapter<rxNewsAdapter.MyViewHolder> {

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

    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.tv.setText("123");
    }

    @Override
    public int getItemCount()
    {
        return 3;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv;

        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.textView);
        }
    }
}
