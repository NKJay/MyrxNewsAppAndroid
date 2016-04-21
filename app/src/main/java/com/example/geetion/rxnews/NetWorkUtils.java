package com.example.geetion.rxnews;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Geetion on 16/4/21.
 */
public class NetWorkUtils{

    static final int timeOut = 8000;

    public static final int GET = 0;
    public static final int POST = 1;

    static public void getHttpRequest(final String Url,final NetWorkUtilsInterface.OnRequestSuccess onRequestSuccess){
        Log.i("222","123");
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                onRequestSuccess.onSuccess(String.valueOf(msg.obj));
            }
        };

        new Thread(new Runnable() {
            Message message = new Message();
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    //设置连接相关参数
                    URL url = new URL(Url);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(timeOut);
                    connection.setReadTimeout(timeOut);
                    //逐行读取内容
                    InputStream in = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line = reader.readLine())!= null){
                        response.append(line);
                    }
                    //将数据发送到主线程
                    message.what = GET;
                    message.obj = response;
                    handler.sendMessage(message);
                    Log.i("222",response.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
