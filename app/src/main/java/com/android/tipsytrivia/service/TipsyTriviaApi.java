package com.android.tipsytrivia.service;

import com.android.tipsytrivia.model.TipsyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TipsyTriviaApi {

    @GET("api.php?amount=10")
    Call<TipsyResponse> getTrivia();
}
