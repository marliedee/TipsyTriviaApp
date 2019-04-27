package com.android.tipsytrivia.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TriviaRetrofit {
    private static Retrofit instance;

    private TriviaRetrofit() {
    }

    public static Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl("https://opentdb.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return instance;
    }
}
