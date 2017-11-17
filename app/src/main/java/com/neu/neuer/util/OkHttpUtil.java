package com.neu.neuer.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by fengyuluo on 2017/11/14.
 */

public class OkHttpUtil {
    public static void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
