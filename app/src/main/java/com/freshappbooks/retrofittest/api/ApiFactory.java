package com.freshappbooks.retrofittest.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {  // Singleton

    private static ApiFactory apiFactory;
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://gitlab.65apps.com/65gb/static/raw/master/"; // end to slash

    public ApiFactory() {
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

    }

    public static ApiFactory getInstance() {
        if (apiFactory == null) {
            apiFactory = new ApiFactory();
        }
        return apiFactory;
    }
    public ApiService getApiService() {
        return retrofit.create(ApiService.class);
    }
}
