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
    private ArrayList<String> mtitleList = new ArrayList<>();

    public MainViewpagerAdapater(FragmentManager fm,ArrayList<android.support.v4.app.Fragment> fragments,ArrayList<String> titleList) {
        super(fm);
        mfragments = fragments;
        mtitleList = titleList;
    }


    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return mfragments.get(position);
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mtitleList.get(position);
    }
}
