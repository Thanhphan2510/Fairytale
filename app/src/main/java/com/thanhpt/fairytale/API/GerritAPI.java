package com.thanhpt.fairytale.API;

import com.google.gson.JsonElement;
import com.thanhpt.fairytale.Item.User;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GerritAPI {
    @POST("login.php")
    Call<JsonElement> login(@Body RequestBody body);

    @POST("signup.php")
    Call<JsonElement> signup(@Body RequestBody body);

    @GET("getCountriesList.php")
    Call<JsonElement> getCountry();

    @GET("getCityByCountry.php")
    Call<JsonElement> getCityByCountry();
    @GET("/region/get-regions")
    Call<JsonElement> getAllCity();
}
