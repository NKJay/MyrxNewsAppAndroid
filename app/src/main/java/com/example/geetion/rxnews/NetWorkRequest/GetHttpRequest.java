package com.example.geetion.rxnews.NetWorkRequest;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Geetion on 16/4/22.
 */
public class GetHttpRequest extends AsyncTask<Void,Integer,Boolean>{

    private String murl;
    private NetWorkUtils.OnRequestSuccess monRequestSuccess;
    private NetWorkUtils.OnRequestfail monRequestfail;
    private StringBuilder response = new StringBuilder();


    public  GetHttpRequest(String Url,NetWorkUtils.OnRequestSuccess onRequestSuccess,NetWorkUtils.OnRequestfail onRequestfail){
        murl = Url;
        monRequestSuccess = onRequestSuccess;
        monRequestfail = onRequestfail;
    }

    private void httpRequest(){
        HttpURLConnection connection = null;
        try{
            //建立网络连接并设置相关参数
            URL url = new URL(murl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(8000);
            connection.setReadTimeout(8000);
            //逐行读取内容
            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
            monRequestfail.onFail(e.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            monRequestfail.onFail(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            monRequestfail.onFail(e.toString());
        }finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        httpRequest();
        return null;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        monRequestSuccess.onSuccess(response.toString());
    }
}
