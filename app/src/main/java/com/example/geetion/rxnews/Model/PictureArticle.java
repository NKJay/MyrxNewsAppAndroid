package com.example.geetion.rxnews.Model;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by Geetion on 16/4/23.
 */
public class PictureArticle {
    public String id;
    public String title;
    public int click;
    public String thumb;

    public PictureArticle(JSONObject object){
        try {
            id = String.valueOf(object.getInt("pid"));
            title = object.getString("title");
            Log.i("zxc",title);
            thumb = object.getString("thumb");
            click = object.getInt("click");
        }catch (Exception e){
            Log.i("123",e.toString());
        }
    }
}
