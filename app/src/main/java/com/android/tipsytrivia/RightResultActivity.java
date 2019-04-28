package com.android.tipsytrivia;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.felipecsl.gifimageview.library.GifImageView;

public class RightResultActivity extends AppCompatActivity {

    private GifImageView gifImageView;
    private TextView textView;

    private Handler handler;
    private Runnable runnable;
    private MediaPlayer right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_results);

        right = MediaPlayer.create(this, R.raw.yay);
        right.start();

        textView = findViewById(R.id.right_text_results);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble_anim);
        textView.startAnimation(animation);

        gifImageView = findViewById(R.id.correct);
        Glide.with(this).load(R.raw.correct).into(gifImageView);

        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), CategoryPageActivity.class));
                right.release();
                finish();
            }

        };
        handler = new Handler();
        handler.postDelayed(runnable, 5000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (handler != null && runnable != null) ;
        handler.removeCallbacks(runnable);
    }
}

