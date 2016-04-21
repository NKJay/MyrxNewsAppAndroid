package com.example.geetion.rxnews.Collage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geetion.rxnews.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CollageFragment extends Fragment {


    public CollageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisView = inflater.inflate(R.layout.fragment_collage, container, false);
        return thisView;
    }

}
