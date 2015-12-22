package com.example.geetion.rxnewsappandroid;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Findys on 15/12/22.
 */
public class MainViewPagerAdapter extends PagerAdapter{
    ArrayList<View> viewArray;
    public MainViewPagerAdapter(ArrayList<View> myArray){
            viewArray = myArray;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewArray.get(position));
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewArray.get(position));
        return viewArray.get(position);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
