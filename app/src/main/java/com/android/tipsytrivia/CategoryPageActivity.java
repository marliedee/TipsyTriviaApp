package com.android.tipsytrivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.tipsytrivia.model.TipsyResponse;
import com.android.tipsytrivia.service.TipsyTriviaApi;
import com.android.tipsytrivia.service.TriviaRetrofit;
import com.bumptech.glide.Glide;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPageActivity extends AppCompatActivity {

    private TextView categoryTextView;
    private ImageView filmImage;
    private ImageView tvImage;
    private ImageView celebrityImage;
    private ImageView musicImage;
    private TipsyResponse tipsyResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        categoryTextView = findViewById(R.id.category);

        filmImage = findViewById(R.id.film);
        Glide.with(this).load(R.drawable.moviez).into(filmImage);
        tvImage = findViewById(R.id.tv);
        Glide.with(this).load(R.drawable.tv1).into(tvImage);
        celebrityImage = findViewById(R.id.marylin);
        Glide.with(this).load(R.drawable.marylin2).into(celebrityImage);
        musicImage = findViewById(R.id.music);
        Glide.with(this).load(R.drawable.music1).into(musicImage);


        filmImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitCall("11", "easy");
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble_anim);
                filmImage.startAnimation(animation);
            }
        });

        tvImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitCall("14", "easy");
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble_anim);
                tvImage.startAnimation(animation);

            }
        });

        celebrityImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitCall("26", "easy");
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble_anim);
                celebrityImage.startAnimation(animation);
            }
        });

        musicImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitCall("12", "easy");
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble_anim);
                musicImage.startAnimation(animation);
            }
        });

    }

    private void retrofitCall(String category, String difficulty) {
        TriviaRetrofit.getInstance()
                .create(TipsyTriviaApi.class)
                .getTrivia(category, difficulty)
                .enqueue(new Callback<TipsyResponse>() {
                    @Override
                    public void onResponse(Call<TipsyResponse> call, Response<TipsyResponse> response) {
                        Log.d("joestag", "onResponse: " + response.body().getResults().get(0).getCategory());
                        Intent intent = new Intent(CategoryPageActivity.this, QuestionsPageActivity.class);
                        intent.putExtra("category", (Serializable) response.body().getResults());
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<TipsyResponse> call, Throwable t) {

                        Log.d("joestag", "onFailure: " + t.getMessage());
                    }
                });

    }
}
