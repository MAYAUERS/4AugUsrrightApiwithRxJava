package com.example.a4augusrrightapiwithrxjava;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    //https://balicuat.bajajallianz.com/INSTAB/ws/api/usright

    public static String BASEURL="https://balicuat.bajajallianz.com/";

    private static Retrofit retrofit=null;

    public static Retrofit getAPIClient(){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;

    }
}
