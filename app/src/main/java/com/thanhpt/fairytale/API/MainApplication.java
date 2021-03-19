package com.thanhpt.fairytale.API;

import android.app.Application;

public class MainApplication extends Application {
    public static ApiManager apiManager;

    @Override
    public void onCreate() {
        super.onCreate();
        apiManager = ApiManager.getInstance();
    }
}
