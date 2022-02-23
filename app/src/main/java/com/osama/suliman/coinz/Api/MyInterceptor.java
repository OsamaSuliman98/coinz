package com.osama.suliman.coinz.Api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class MyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request  = chain.request()
                .newBuilder()
                .addHeader("X-Client-Device-UDID","1234")
                .build();





        return chain.proceed(request);
    }
}
