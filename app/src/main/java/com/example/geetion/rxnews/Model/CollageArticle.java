package com.example.geetion.rxnews.Model;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Geetion on 16/4/22.
 */
public class CollageArticle {
    public String id;
    public String title;
    public int click;
    public String thumb;
    public String info;

    public CollageArticle(JSONObject object){
        try {
            id = String.valueOf(object.getInt("id"));
            title = object.getString("title");
            info = object.getString("info");
            thumb = object.getString("thumb");
            click = object.getInt("click");
        }catch (Exception e){

        }
    }
}
