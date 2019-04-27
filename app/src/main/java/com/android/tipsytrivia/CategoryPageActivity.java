package com.android.tipsytrivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tipsytrivia.model.TipsyResponse;
import com.android.tipsytrivia.service.TipsyTriviaApi;
import com.android.tipsytrivia.service.TriviaRetrofit;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPageActivity extends AppCompatActivity {

    private TextView categoryTextView;
    private ImageView filmImage;
    private ImageView tvImage;
    private ImageView celebrityImage;
    private ImageView animalImage;
    private TipsyResponse tipsyResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        categoryTextView = findViewById(R.id.category);
        filmImage = findViewById(R.id.film);
        tvImage = findViewById(R.id.tv);
        celebrityImage = findViewById(R.id.celebrities);
        animalImage = findViewById(R.id.animals);


        filmImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitCall("11", "easy");
                //overridePendingTransition(R.spin_anim.);
            }
        });

        tvImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitCall("14", "easy");

            }
        });

        celebrityImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitCall("26", "easy");
            }
        });

        animalImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofitCall("12", "easy");
            }
        });


    }
    private void retrofitCall(String category, String difficulty){
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

//        filmImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        tvImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        celebrityImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
//        animalImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }
}
