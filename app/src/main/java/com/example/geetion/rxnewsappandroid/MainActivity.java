package com.example.geetion.rxnewsappandroid;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity{
    ViewPager viewPager;
    ArrayList<View> viewList = new ArrayList<View>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        View view1 = LayoutInflater.from(this).inflate(R.layout.news_layout,null);
        View view2 = LayoutInflater.from(this).inflate(R.layout.college_layout,null);
        View view3 = LayoutInflater.from(this).inflate(R.layout.picture_layout,null);
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewPager.setAdapter(new MainViewPagerAdapter(viewList));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
