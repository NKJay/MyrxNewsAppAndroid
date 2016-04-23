package com.example.geetion.rxnews.NetWorkRequest;
/**
 * Created by Geetion on 16/4/21.
 */
public class NetWorkUtils{

    public interface OnRequestSuccess
    {
        void onSuccess (String response);
    }

    public interface OnRequestfail{
        void onFail(String e);
    }

    public static void getHttpRequest(String Url, NetWorkUtils.OnRequestSuccess onRequestSuccess,NetWorkUtils.OnRequestfail onRequestfail){
        new GetHttpRequest(Url,onRequestSuccess,onRequestfail).execute();
    }
}
