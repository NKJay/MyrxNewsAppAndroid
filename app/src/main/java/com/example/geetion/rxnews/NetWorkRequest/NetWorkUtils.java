package com.example.geetion.rxnews.NetWorkRequest;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Geetion on 16/4/21.
 */
public class NetWorkUtils{

    public interface OnRequestSuccess
    {
        void onSuccess (String response);
    }

    public interface OnLoadImageSuccess
    {
        void onSuccess (Bitmap bitmap);
    }

    public interface OnRequestfail{
        void onFail(String e);
    }

    public static void getHttpRequest(String Url, NetWorkUtils.OnRequestSuccess onRequestSuccess,NetWorkUtils.OnRequestfail onRequestfail){
        new GetHttpRequest(Url,onRequestSuccess,onRequestfail).execute();
    }

    public static void loadUrlImage(String url, final ImageView imageView){
        new LoadUrlImage(url, new OnLoadImageSuccess() {
            @Override
            public void onSuccess(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
            }
        }, new OnRequestfail() {
            @Override
            public void onFail(String e) {

            }
        }).execute();
    }
}
