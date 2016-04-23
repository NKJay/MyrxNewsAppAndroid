package com.example.geetion.rxnews.Model;

import org.json.JSONObject;

/**
 * Created by Geetion on 16/4/23.
 */
public class SlideRXNewsArticle {

    public String id;
    public String title;
    public String thumb;

    public SlideRXNewsArticle(JSONObject object){
        try {
            id = String.valueOf(object.getInt("id"));
            title = object.getString("title");
            thumb = object.getString("thumb");
        }catch (Exception e){

        }
    }
}
