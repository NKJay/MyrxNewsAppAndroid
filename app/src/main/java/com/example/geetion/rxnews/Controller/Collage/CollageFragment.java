package com.example.geetion.rxnews.Controller.Collage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.geetion.rxnews.Model.CollageArticle;
import com.example.geetion.rxnews.NetWorkRequest.NetWorkUtils;
import com.example.geetion.rxnews.R;
import com.example.geetion.rxnews.Controller.RecyclerViewOnClickInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CollageFragment extends Fragment implements RecyclerViewOnClickInterface{

    private SwipeRefreshLayout mswipeRefreshLayout;
    private RecyclerView mrecyclerView;

    private final String murl = "http://app.ecjtu.net/api/v1/schoolnews";

    private ArrayList<CollageArticle> marticles = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisView = inflater.inflate(R.layout.fragment_collage, container, false);
        initLayout(thisView);
        getHttpRequestData();
        return thisView;
    }


    private void initLayout(View view){

        mswipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.collageRefreshLayout);
        mswipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getHttpRequestData();
            }
        });

        mrecyclerView = (RecyclerView)view.findViewById(R.id.collageRecyclerView);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    //获取网络数据
    private void getHttpRequestData(){
        NetWorkUtils.getHttpRequest(murl, new NetWorkUtils.OnRequestSuccess() {
            @Override
            public void onSuccess(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    //处理一般文章数据
                    JSONArray articlesJSONArray = jsonObject.getJSONArray("articles");
                    ArrayList<CollageArticle> tmpNormalArticles = new ArrayList<>();
                    parseNorlmalArticleJSONObject(articlesJSONArray,tmpNormalArticles);
                    marticles = tmpNormalArticles;

                    mrecyclerView.setAdapter(new CollageRecyclerViewAdapter(marticles,CollageFragment.this));
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

    private void parseNorlmalArticleJSONObject(JSONArray jsonArray,ArrayList<CollageArticle> articles) {
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                CollageArticle article = new CollageArticle(object);
                articles.add(article);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClickListener(int position) {

    }
}
