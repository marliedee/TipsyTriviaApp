package com.android.tipsytrivia.service;

import com.android.tipsytrivia.model.TipsyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TipsyTriviaApi {

    @GET("api.php?amount=10&category=&difficulty=&type=multiple")
    Call<TipsyResponse>getTrivia(@Query("category") String category,
                                 @Query("difficulty") String difficulty);
}
