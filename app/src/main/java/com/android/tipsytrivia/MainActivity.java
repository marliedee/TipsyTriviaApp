package com.android.tipsytrivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.tipsytrivia.model.TipsyResponse;
import com.android.tipsytrivia.service.TipsyTriviaApi;
import com.android.tipsytrivia.service.TriviaRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TriviaRetrofit.getInstance()
                .create(TipsyTriviaApi.class)
                .getTrivia("14", "easy")
                .enqueue(new Callback<TipsyResponse>() {
                    @Override
                    public void onResponse(Call<TipsyResponse> call, Response<TipsyResponse> response) {
                        Log.d("joestag", "onResponse: " + response.body().getResults().get(0).getCategory());

                    }

                    @Override
                    public void onFailure(Call<TipsyResponse> call, Throwable t) {

                        Log.d("joestag", "onFailure: " + t.getMessage());
                    }
                });

    }
}
