package com.example.geetion.rxnewsappandroid.CollageNews;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

import java.util.ArrayList;

/**
 * Created by Geetion on 16/1/29.
 */
public class CollageFragment extends Fragment {

    private String url = "http://app.ecjtu.net/api/v1/schoolnews";
    private RecyclerView recyclerView;
    private ArrayList<CollageItem> newsList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        requestData();

        View view = inflater.inflate(R.layout.college_layout,container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    private void requestData() {

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        JsonObjectRequest jsonObjectRequest;

        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {

                            newsList = creatNewsData(jsonObject);
                            recyclerView.setAdapter(new CollageAdapter(newsList));

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

    private ArrayList<CollageItem> creatNewsData(JSONObject jsonObject) throws JSONException {

        JSONArray newsArray = jsonObject.getJSONArray("articles");

        ArrayList<CollageItem> currentData = new ArrayList<>();

        for (int i = 0;i < newsArray.length();i++) {

            CollageItem newsItem = new CollageItem();

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
