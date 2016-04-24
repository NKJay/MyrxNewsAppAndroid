package com.example.geetion.rxnews.Controller;

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
;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mviewPager = (ViewPager)findViewById(R.id.mainViewPager);

        initFragments();
        initLayout();
        mviewPager.setAdapter(new MainViewpagerAdapater(getSupportFragmentManager(),mfragments,mtitleList));

    }

    private void initLayout(){
        mtitleList.add("日新新闻");
        mtitleList.add("学院新闻");
        mtitleList.add("日新图说");
    }

    private void initFragments(){
        mfragments.add(new RXNewsFragment());
        mfragments.add(new CollageFragment());
        mfragments.add(new PictureFragment());
    }
}
