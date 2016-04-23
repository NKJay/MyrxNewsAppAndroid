package com.example.geetion.rxnews.NetWorkRequest;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Geetion on 16/4/23.
 */
public class PostHttpRequest extends AsyncTask {

    private String murlAddress;
    private StringBuilder response = new StringBuilder();

    public PostHttpRequest(){

    }

    private void httpRequest(){

        HttpURLConnection connection;
        try {

            URL url = new URL(murlAddress);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setReadTimeout(8000);
            connection.setConnectTimeout(8000);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            InputStream in = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null){
                response.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected Object doInBackground(Object[] objects) {
        httpRequest();
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
