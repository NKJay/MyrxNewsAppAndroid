package com.example.geetion.rxnewsappandroid.pictureNews;

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
public class PictureFragment extends Fragment{
    private String url = "http://pic.ecjtu.net/api.php/list";
    private ArrayList<PictureItem> newsList = new ArrayList<>();
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.picture_layout, container, false);

        requestData();

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

     private void requestData(){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            newsList = creatNewsData(jsonObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        recyclerView.setAdapter(new PictureAdapter(newsList));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                    }
                });
         requestQueue.add(jsonObjectRequest);
    }

    private ArrayList<PictureItem> creatNewsData(JSONObject jsonObject) throws JSONException {

        ArrayList<PictureItem> currentData = new ArrayList<>();

            JSONArray news = jsonObject.getJSONArray("list");
            for(int i = 0;i < news.length();i++){

                PictureItem pictureItem = new PictureItem();

                JSONObject item = news.getJSONObject(i);

                pictureItem.click = item.getInt("click");
                pictureItem.title = item.getString("title");

                currentData.add(pictureItem);
            }

        return currentData;
    }
}
