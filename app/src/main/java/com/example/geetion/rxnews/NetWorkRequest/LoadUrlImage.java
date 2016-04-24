package com.example.geetion.rxnews.NetWorkRequest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Geetion on 16/4/24.
 */
public class LoadUrlImage extends AsyncTask {

    private String murl;
    private Bitmap urlBitmap;
    private NetWorkUtils.OnRequestfail monRequestfail;
    private NetWorkUtils.OnLoadImageSuccess monLoadImageSuccess;

    public LoadUrlImage(String url,NetWorkUtils.OnLoadImageSuccess onLoadImageSuccess ,NetWorkUtils.OnRequestfail onRequestfail){
        murl = url;
        monRequestfail = onRequestfail;
        monLoadImageSuccess = onLoadImageSuccess;
    }

    private void getBitmap() throws Exception {
        URL url = new URL(murl);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setDoInput(true);
        connection.setConnectTimeout(8000);
        InputStream in = connection.getInputStream();
        urlBitmap = BitmapFactory.decodeStream(in);
    }


    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            getBitmap();
        } catch (Exception e) {
            e.printStackTrace();
            monRequestfail.onFail(e.toString());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        monLoadImageSuccess.onSuccess(urlBitmap);
    }
}
