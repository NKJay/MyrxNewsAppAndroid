package com.example.geetion.rxnews.Picture;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geetion.rxnews.Model.PictureArticle;
import com.example.geetion.rxnews.NetWorkRequest.NetWorkUtils;
import com.example.geetion.rxnews.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {

    private RecyclerView mrecyclerView;
    private SwipeRefreshLayout mswipeRefreshLayout;

    private ArrayList<PictureArticle> marticles = new ArrayList<>();
    private String murl = "http://pic.ecjtu.net/api.php/list";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisView = inflater.inflate(R.layout.fragment_picture, container, false);
        initLayout(thisView);
        getHttpRequestData();
        return thisView;
    }

    private void initLayout(View view){
        mrecyclerView = (RecyclerView) view.findViewById(R.id.pictureRecyclerView);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mswipeRefreshLayout = (SwipeRefreshLayout)view.findViewById(R.id.pictureRefreshLayout);
        mswipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getHttpRequestData();
            }
        });
    }

    //获取网络数据
    private void getHttpRequestData(){
        NetWorkUtils.getHttpRequest(murl, new NetWorkUtils.OnRequestSuccess() {
            @Override
            public void onSuccess(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    //处理一般文章数据
                    JSONArray articlesJSONArray = jsonObject.getJSONArray("list");
                    ArrayList<PictureArticle> tmpNormalArticles = new ArrayList<>();
                    parseNorlmalArticleJSONArray(articlesJSONArray,tmpNormalArticles);
                    marticles = tmpNormalArticles;

                    mrecyclerView.setAdapter(new PicturesRecyclerViewAdapter(marticles));
                    mswipeRefreshLayout.setRefreshing(false);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new NetWorkUtils.OnRequestfail() {
            @Override
            public void onFail(String e) {

            }
        });
    }

    private void parseNorlmalArticleJSONArray(JSONArray jsonArray,ArrayList<PictureArticle> articles) {
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                PictureArticle article = new PictureArticle(object);
                articles.add(article);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
