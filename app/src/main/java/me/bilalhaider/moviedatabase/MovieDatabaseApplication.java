package me.bilalhaider.moviedatabase;

import android.app.Application;

import me.bilalhaider.moviedatabase.data.network.API;
import me.bilalhaider.moviedatabase.data.network.ApiService;

public class MovieDatabaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static API getApiService() {
        return ApiService.createService(API.class);
    }
}
