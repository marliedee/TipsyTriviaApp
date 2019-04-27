package com.android.tipsytrivia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.tipsytrivia.model.TipsyResponse;
import com.android.tipsytrivia.service.TipsyTriviaApi;
import com.android.tipsytrivia.service.TriviaRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Button startgame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        startgame = findViewById(R.id.start);

        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent play = new Intent(getApplicationContext(), CategoryPageActivity.class);
                startActivity(play);
            }
        });


    }
}