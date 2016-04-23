package com.example.geetion.rxnews;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.geetion.rxnews.Collage.CollageFragment;
import com.example.geetion.rxnews.Picture.PictureshowFragment;
import com.example.geetion.rxnews.RXNews.RXNewsFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<android.support.v4.app.Fragment> mfragments = new ArrayList<>();
    private ViewPager mviewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mviewPager = (ViewPager)findViewById(R.id.mainViewPager);

        initFragments();

        mviewPager.setAdapter(new MainViewpagerAdapater(getSupportFragmentManager(),mfragments));

    }

    private void initFragments(){
        mfragments.add(new RXNewsFragment());
        mfragments.add(new CollageFragment());
        mfragments.add(new PictureshowFragment());
    }
}
