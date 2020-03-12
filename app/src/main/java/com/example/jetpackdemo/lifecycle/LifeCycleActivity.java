package com.example.jetpackdemo.lifecycle;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.jetpackdemo.R;

public class LifeCycleActivity extends AppCompatActivity {

    private CustomChronometer chronometer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        ImageView playBasketBallIv = findViewById(R.id.ikun_iv);
        Glide.with(this).load(R.drawable.play_basketball).into(playBasketBallIv);

        chronometer = findViewById(R.id.chronometer);
        getLifecycle().addObserver(chronometer);
    }
}
