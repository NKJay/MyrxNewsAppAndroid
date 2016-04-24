package com.example.geetion.rxnews.Controller.Picture;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.example.geetion.rxnews.Model.PictureArticle;
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
public class PictureFragment extends Fragment implements RecyclerViewOnClickInterface{

    private RecyclerView mrecyclerView;
    private SwipeRefreshLayout mswipeRefreshLayout;
    private RecyclerView.LayoutManager mlayoutManager;
    private PicturesRecyclerViewAdapter mpicturesRecyclerViewAdapter;
    private String articleID;
    private Boolean isLoadMore = true;

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
        mlayoutManager = new LinearLayoutManager(getActivity());
        mrecyclerView = (RecyclerView) view.findViewById(R.id.pictureRecyclerView);
        mrecyclerView.setLayoutManager(mlayoutManager);
        mpicturesRecyclerViewAdapter = new PicturesRecyclerViewAdapter(PictureFragment.this);
        mrecyclerView.setAdapter(mpicturesRecyclerViewAdapter);
        mrecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastPosition =  ((LinearLayoutManager)mlayoutManager).findLastVisibleItemPosition();
                int totolCount = mlayoutManager.getItemCount();
//                Log.i("ddd",String.valueOf(isLoadMore));
                if ((totolCount - lastPosition -1 ) > 1){
                    isLoadMore = true;
                }

                if (((totolCount - lastPosition -1 ) < 1)&&isLoadMore){
                    getMoreData();
                    isLoadMore = false;
                }
            }
        });

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
                    articleID = ((JSONObject)(articlesJSONArray.get(articlesJSONArray.length()-1))).getString("pubdate");

                    ArrayList<PictureArticle> tmpNormalArticles = new ArrayList<>();
                    parseNorlmalArticleJSONArray(articlesJSONArray,tmpNormalArticles);
                    marticles = tmpNormalArticles;
                    mpicturesRecyclerViewAdapter.updateData(marticles);
                    mpicturesRecyclerViewAdapter.notifyDataSetChanged();
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

    //获取更多网络数据
    private void getMoreData(){
        String url = murl + "?before=" + articleID;
        NetWorkUtils.getHttpRequest(url, new NetWorkUtils.OnRequestSuccess() {
            @Override
            public void onSuccess(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    //处理一般文章数据
                    JSONArray articlesJSONArray = jsonObject.getJSONArray("list");
                    articleID = ((JSONObject)(articlesJSONArray.get(articlesJSONArray.length()-1))).getString("pubdate");
                    Log.i("123",String.valueOf(marticles.size()));
                    parseNorlmalArticleJSONArray(articlesJSONArray,marticles);
                    mpicturesRecyclerViewAdapter.updateData(marticles);
                    mpicturesRecyclerViewAdapter.notifyItemRangeInserted(mpicturesRecyclerViewAdapter.getItemCount()-1,3);
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
                Log.i("hhh",String.valueOf(articles.size()));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onItemClickListener(int position) {

    }
}
