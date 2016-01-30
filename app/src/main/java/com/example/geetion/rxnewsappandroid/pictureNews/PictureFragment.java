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

    private ArrayList<PictureItem> newsList = new ArrayList<>();
    private String articleID = new String();
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.picture_layout, container, false);

        requestData();
        requestMoreData(articleID);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

     private void requestData(){

         String url = "http://pic.ecjtu.net/api.php/list";

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        try {
                            ArrayList<PictureItem> currentData = new ArrayList<>();

                            newsList = creatNewsData(jsonObject,currentData);

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

    private void requestMoreData(String id){

        String url = "http://pic.ecjtu.net/api.php/list?before="+id;

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {

                        try {
                            int count = jsonObject.getInt("count");

                            if (0 != count){
                                creatNewsData(jsonObject,newsList);
                            }
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

    private ArrayList<PictureItem> creatNewsData(JSONObject jsonObject,ArrayList<PictureItem> dataSource) throws JSONException {

            JSONArray newsArray = jsonObject.getJSONArray("list");

            articleID = newsArray.getJSONObject(newsArray.length()-1).getString("pubdate");

            for(int i = 0;i < newsArray.length();i++){

                PictureItem pictureItem = new PictureItem();

                JSONObject item = newsArray.getJSONObject(i);

                pictureItem.click = item.getInt("click");
                pictureItem.title = item.getString("title");

                dataSource.add(pictureItem);
            }

        return dataSource;
    }
}
