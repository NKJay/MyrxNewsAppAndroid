package com.example.geetion.rxnewsappandroid.rxNews;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.geetion.rxnewsappandroid.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


public class rxNewsFragment extends Fragment {

    String url = "http://app.ecjtu.net/api/v1/index";
    private ArrayList<rxNewsItem> newsList = new ArrayList<>();
    RecyclerView recyclerView;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        requestData();

        View view = inflater.inflate(R.layout.news_layout, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new rxNewsAdapter(newsList));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    public void requestData() {

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        JsonObjectRequest jsonObjectRequest;
        
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {

                            newsList = creatNewsData(jsonObject);
                            creatSlideNewsData(jsonObject);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                });

        requestQueue.add(jsonObjectRequest);
    }

    private ArrayList<rxSlideNewsItem> creatSlideNewsData(JSONObject jsonObject) throws JSONException {

        JSONObject slide = jsonObject.getJSONObject("slide_article");
        JSONArray slideArray = slide.getJSONArray("articles");

        ArrayList<rxSlideNewsItem> currentSlideData = new ArrayList<>();

        for (int i = 0;i < slideArray.length();i++) {

            rxSlideNewsItem newsItem = new rxSlideNewsItem();

            newsItem.id = slideArray.getJSONObject(i).getInt("id");
            newsItem.title = slideArray.getJSONObject(i).getString("title");
            newsItem.thumb = slideArray.getJSONObject(i).getString("thumb");

            currentSlideData.add(newsItem);
        }

        return currentSlideData;
    }

    private ArrayList<rxNewsItem> creatNewsData(JSONObject jsonObject) throws JSONException {

        JSONObject news = jsonObject.getJSONObject("normal_article");
        JSONArray newsArray = news.getJSONArray("articles");

        ArrayList<rxNewsItem> currentData = new ArrayList<>();

        for (int i = 0;i < newsArray.length();i++) {

            rxNewsItem newsItem = new rxNewsItem();
            newsItem.click = newsArray.getJSONObject(i).getInt("click");
            newsItem.id = newsArray.getJSONObject(i).getInt("id");
            newsItem.info = newsArray.getJSONObject(i).getString("info");
            newsItem.title = newsArray.getJSONObject(i).getString("title");
            newsItem.thumb = newsArray.getJSONObject(i).getString("thumb");

            currentData.add(newsItem);
        }
        return currentData;
    }

}
