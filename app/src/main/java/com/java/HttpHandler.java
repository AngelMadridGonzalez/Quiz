package com.java;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpHandler {

    private final String TAG = HttpHandler.class.getSimpleName();
    //private static final boolean debug = ( "1".equals(App.getContext().getResources().getString(R.string.DEBUG)) ) ? true : false;

    public HttpHandler() {
    }

    public String  mainPerformPostCall(String requestURL, HashMap<String, String> postDataParams) {
        // Entrada: El hashMap con los pares clave-valor que envíamos con POST y la url
        // Salida : Un String con la cadena JSON
        Log.i(TAG, "> > > mainPerformPostCall()");
        Log.d(TAG, "----> requestURL:     " + requestURL);
        Log.d(TAG, "----> postDataParams: " + postDataParams.toString());
        URL url;
        String responseJson = "";
        try {
            url = new URL(requestURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));
            writer.flush();
            writer.close();
            os.close();

            // Download
            // Falta controlar el código 200 de responseCode **************
            int responseCode=conn.getResponseCode();
            Log.d(TAG, "----> responseCode: " + responseCode);
            Log.d(TAG, "----> conn.getInputStream(): " + conn.getInputStream());
            InputStream in = new BufferedInputStream(conn.getInputStream());
            responseJson = convertStreamToString(in);
            Log.d(TAG, "----> responseJson1: " + responseJson);
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        Log.d(TAG, "----> responseJson: " + responseJson);
        return responseJson;
    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        Log.i(TAG, "> > > getPostDataString()");
        Log.d(TAG, "----> params: " + params.toString());
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        Log.d(TAG, "----> result: " + result.toString());
        return result.toString();
    }

    private String convertStreamToString(InputStream is) {
        Log.i(TAG, "> > > convertStreamToString()");
        Log.d(TAG, "----> InputStream: " + is.toString());
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
