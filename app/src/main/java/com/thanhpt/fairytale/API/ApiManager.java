package com.thanhpt.fairytale.API;

import com.google.gson.JsonElement;
import com.thanhpt.fairytale.Item.User;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    private static GerritAPI service;
    private static ApiManager apiManager;

    private ApiManager() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fairytaleapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(GerritAPI.class);
    }

    public static ApiManager getInstance() {
        if (apiManager == null) {
            apiManager = new ApiManager();
        }
        return apiManager;
    }

    public void loginUser(RequestBody body, Callback<JsonElement> callback) {
        Call<JsonElement> userCall = service.login(body);
        userCall.enqueue(callback);
    }
    public void signUpUser(RequestBody body, Callback<JsonElement> callback){

        Call<JsonElement> userCall = service.signup(body);
        userCall.enqueue(callback);

    }
    public void getCoutry( Callback<JsonElement> callback){
        Call<JsonElement> usercall = service.getCountry();
        usercall.enqueue(callback);
    }

    public void getCityByCountry(Callback<JsonElement> callback){
        Call<JsonElement> usercall = service.getCityByCountry();
        usercall.enqueue(callback);
    }
    public void getAllCity(Callback<JsonElement> callback){
        Call<JsonElement> usercall = service.getCityByCountry();
        usercall.enqueue(callback);
    }

}
