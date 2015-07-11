package com.android.mario.api;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by Administrator on 2015/7/10.
 */
public class HttpEngine {
    private static final String SERVER_URL = "http://uat.b.quancome.com/platform/api";

    private static final String REQUEST_METHOD = "POST";

    private static final String ENCODE_TYPE = "UTF-8";

    private static final int TIME_OUT = 15000;

    private static HttpEngine httpEngine = null;

    private HttpEngine() {
    }

    public static HttpEngine getInstance() {

        if (httpEngine == null) {
            httpEngine = new HttpEngine();
        }
        return httpEngine;
    }

    public <T> T postHandle(Map<String, String> paramsMap, Type typeOfT) throws IOException {
        String data = joinParams(paramsMap);

        HttpURLConnection connection = getConnection();
        connection.setRequestProperty("Content-Length", String.valueOf(data.getBytes().length));
        connection.connect();
        OutputStream os = connection.getOutputStream();
        os.write(data.getBytes());
        os.flush();
        if (connection.getResponseCode() == 200) {
            InputStream is = connection.getInputStream();

            //创建字节输出流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int len = 0;

            byte[] buffer = new byte[1024];

            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            is.close();
            baos.close();
            connection.disconnect();

            final String result = new String(baos.toByteArray());
            Gson gson = new Gson();

            return gson.fromJson(result, typeOfT);
        } else {
            connection.disconnect();
            return null;
        }
    }

    private HttpURLConnection getConnection() {

        HttpURLConnection connection = null;

        try {
            URL url = new URL(SERVER_URL);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(REQUEST_METHOD);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);

            connection.setReadTimeout(TIME_OUT);
            connection.setConnectTimeout(TIME_OUT);

            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("Response-Type", "json");
            connection.setChunkedStreamingMode(0);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private String joinParams(Map<String, String> paramsMap) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String key : paramsMap.keySet()) {
            stringBuilder.append(key);
            stringBuilder.append("=");

            try {
                stringBuilder.append(URLEncoder.encode(paramsMap.get(key), ENCODE_TYPE));

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            stringBuilder.append("&");

        }

        return stringBuilder.substring(0, stringBuilder.length() - 1);

    }

}
