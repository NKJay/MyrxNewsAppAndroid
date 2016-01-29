package com.example.geetion.rxnewsappandroid.rxNews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.geetion.rxnewsappandroid.R;

import java.util.ArrayList;

/**
 * Created by Geetion on 16/1/21.
 */
public class RXNewsAdapter extends RecyclerView.Adapter<RXNewsAdapter.MyViewHolder> {

    private ArrayList<RXNewsItem> list = new ArrayList<>();

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.rixin_viewholder, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    public RXNewsAdapter(ArrayList<RXNewsItem> myList){
        this.list = myList;
    }

    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        RXNewsItem item = list.get(position);

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
