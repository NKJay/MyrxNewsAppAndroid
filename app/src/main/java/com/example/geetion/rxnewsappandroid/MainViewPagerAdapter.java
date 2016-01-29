package com.example.geetion.rxnewsappandroid;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import java.util.ArrayList;

/**
 * Created by Findys on 15/12/22.
 */
public class MainViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> viewArray;

    public MainViewPagerAdapter(FragmentManager fragmentManager,ArrayList<Fragment> myArray){
        super(fragmentManager);
        viewArray = myArray;
    }


    @Override
    public int getCount() {
        return viewArray.size();
    }

    @Override
    public Fragment getItem(int position) {
        return viewArray.get(position);
    }
}
