package com.example.a4augusrrightapiwithrxjava;

import com.google.gson.JsonObject;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
//https://balicuat.bajajallianz.com/INSTAB/ws/api/usright
    @POST("INSTAB/ws/api/usright")
//    Observable<SucessResponse> getAllAPIResponse(@Body JsonObject jsonObject);
    //Single<SucessResponse> getAllAPIResponse(@Body JsonObject jsonObject);

  //  Flowable<SucessResponse> getAllAPIResponse(@Body JsonObject jsonObject);
    Maybe<SucessResponse> getAllAPIResponse(@Body JsonObject jsonObject);
}
