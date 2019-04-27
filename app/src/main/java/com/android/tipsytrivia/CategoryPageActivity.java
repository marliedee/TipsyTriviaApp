package com.android.tipsytrivia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryPageActivity extends AppCompatActivity {

    private TextView categoryTextView;
    private ImageView filmImage;
    private ImageView tvImage;
    private ImageView celebrityImage;
    private ImageView animalImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        categoryTextView = findViewById(R.id.category);
        filmImage = findViewById(R.id.film);
        tvImage = findViewById(R.id.tv);
        celebrityImage = findViewById(R.id.celebrities);
        animalImage = findViewById(R.id.animals);

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
