package com.android.tipsytrivia;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.felipecsl.gifimageview.library.GifImageView;


public class WrongResultActivity extends AppCompatActivity {
    private GifImageView gifImageView;
    private TextView textView;

    private Handler handler;
    private Runnable runnable;
    private MediaPlayer wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wrong_result);

        wrong = MediaPlayer.create(this, R.raw.fail);
        wrong.start();
        textView = findViewById(R.id.wrong_text_results);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wobble_anim);
        textView.startAnimation(animation);

        gifImageView = findViewById(R.id.drink_ImageView);
        Glide.with(this).load(R.raw.cheers).into(gifImageView);

        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), CategoryPageActivity.class));
                wrong.release();
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
