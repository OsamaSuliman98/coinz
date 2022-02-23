package com.osama.suliman.coinz.Api;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiCilent {


//    private String client = new OkHttpClient.Builder()
//            .addInterceptor(MyInterceptor())
//            .build();


//    Retrofit retrofit = new Retrofit.Builder()
//            .client(client)
//            .build();


//    private Interceptor.Chain chain;
//
//
//    Request original = chain.request();
//    ApiCilent requestInterceptor = new ApiCilent() {
//        @Override
//        public void intercept(Request request) {
//            request.header("X-Client-Device-UDID");
//
//        }
//    };
//
//
//    RestAdapter restAdapter = new RestAdapter.Builder()
//            .setEndpoint("https://api.github.com")
//            .setRequestInterceptor(requestInterceptor)
//            .build();


    public static String BASE_URL = "https://newlinetech.site/currency/api/v1/";
    public static Retrofit retrofit;

    public static Retrofit getClient() {
        if (retrofit == null) {
            return new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
