package com.example.geetion.rxnews;

import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Geetion on 16/4/19.
 */
public class MainViewpagerAdapater extends FragmentPagerAdapter {

    private ArrayList<android.support.v4.app.Fragment> mfragments;

    public MainViewpagerAdapater(FragmentManager fm,ArrayList<android.support.v4.app.Fragment> fragments) {
        super(fm);
        mfragments = fragments;
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return mfragments.get(position);
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }
}
