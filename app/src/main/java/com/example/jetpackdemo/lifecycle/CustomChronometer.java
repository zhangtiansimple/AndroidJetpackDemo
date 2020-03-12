package com.example.jetpackdemo.lifecycle;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class CustomChronometer extends Chronometer implements LifecycleObserver {

    private long watchedTime;

    public CustomChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected void onStart() {
        setBase(SystemClock.elapsedRealtime() - watchedTime);
        start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected void onStop() {
        watchedTime = SystemClock.elapsedRealtime() - getBase();
        stop();
    }
}
