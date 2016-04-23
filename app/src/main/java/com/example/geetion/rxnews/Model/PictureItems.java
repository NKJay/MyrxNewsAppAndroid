package com.example.geetion.rxnews.Model;

import org.json.JSONObject;

/**
 * Created by Geetion on 16/4/23.
 */
public class PictureItems {
    public String id;
    public String title;
    public int click;
    public String thumb;

    public PictureItems(JSONObject object){
        try {
            id = String.valueOf(object.getInt("id"));
            title = object.getString("title");
            thumb = object.getString("thumb");
            click = object.getInt("click");
        }catch (Exception e){

        }
    }
}
