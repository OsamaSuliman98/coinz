package com.osama.suliman.coinz.Api;

import com.osama.suliman.coinz.model.coin.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("currencies/list")
    Call<BaseResponse> baseResponseCurrencies (@Query("i_page_count") Integer i_page_count,
                                               @Query("i_page_number") Integer i_page_number);



    @GET("news/list")
    Call<BaseResponse> baseResponseNews (@Query("i_page_count") Integer i_page_count,
                                         @Query("i_page_number") Integer i_page_number);

    @GET("triggers/list")
    @Headers("X-Client-Device-UDID: 1234")
    Call<BaseResponse> ConditionList();




    @GET("favourites")
    Call<BaseResponse> FavouritsList (@Query("i_page_count") Integer i_page_count,
                                      @Query("i_page_number") Integer i_page_number);

}
