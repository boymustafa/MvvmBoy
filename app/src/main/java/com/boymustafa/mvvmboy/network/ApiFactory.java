package com.boymustafa.mvvmboy.network;

import com.boymustafa.mvvmboy.util.Constant;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    public static CharService create(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.ALL_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(CharService.class);

    }

}
