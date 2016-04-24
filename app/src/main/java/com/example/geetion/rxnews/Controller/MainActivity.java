package com.example.geetion.rxnews.Controller;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.geetion.rxnews.Controller.Collage.CollageFragment;
import com.example.geetion.rxnews.Controller.Picture.PictureFragment;
import com.example.geetion.rxnews.R;
import com.example.geetion.rxnews.Controller.RXNews.RXNewsFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<android.support.v4.app.Fragment> mfragments = new ArrayList<>();
    private ViewPager mviewPager;
    private ArrayList<String> mtitleList = new ArrayList<>();
    private TabLayout tabLayout;
;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setElevation(0);

        initFragments();
        initLayout();
    }

    private void initLayout(){
        mtitleList.add("日新新闻");
        mtitleList.add("学院新闻");
        mtitleList.add("日新图说");

        mviewPager = (ViewPager)findViewById(R.id.mainViewPager);
        mviewPager.setAdapter(new MainViewpagerAdapater(getSupportFragmentManager(),mfragments,mtitleList));

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.addTab(tabLayout.newTab().setText(mtitleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(mtitleList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(mtitleList.get(2)));
        tabLayout.setupWithViewPager(mviewPager);
    }

    private void initFragments(){
        mfragments.add(new RXNewsFragment());
        mfragments.add(new CollageFragment());
        mfragments.add(new PictureFragment());
    }
}
