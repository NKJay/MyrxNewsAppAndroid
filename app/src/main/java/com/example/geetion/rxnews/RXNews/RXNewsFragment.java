package com.example.geetion.rxnews.RXNews;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geetion.rxnews.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RXNewsFragment extends Fragment {


    public RXNewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisView = inflater.inflate(R.layout.fragment_rxnews, container, false);

        RecyclerView recyclerView = (RecyclerView)thisView.findViewById(R.id.rxNewsRecyclerView);

        recyclerView.setAdapter(new RXNewsRecyclerViewAdapter());

        return thisView;
    }

}
