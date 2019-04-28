package com.android.tipsytrivia;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.felipecsl.gifimageview.library.GifImageView;


public class WrongResultActivity extends AppCompatActivity {
    private GifImageView gifImageView;
    private TextView textView;

    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wrong_result);
        textView = findViewById(R.id.wrong_text_results);

        MediaPlayer wrong = MediaPlayer.create(this, R.raw.fail);
        wrong.start();

        gifImageView = findViewById(R.id.drink_ImageView);
        Glide.with(this).load(R.raw.cheers).into(gifImageView);

        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), CategoryPageActivity.class));
                finish();
            }

        };
        handler = new Handler();
        handler.postDelayed(runnable, 5000);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MediaPlayer wrong = MediaPlayer.create(this, R.raw.fail);
        wrong.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null && runnable != null) ;
        handler.removeCallbacks(runnable);
    }
}
