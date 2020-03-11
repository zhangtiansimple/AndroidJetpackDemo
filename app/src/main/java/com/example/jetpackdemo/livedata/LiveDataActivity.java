package com.example.jetpackdemo.livedata;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.jetpackdemo.R;

public class LiveDataActivity extends AppCompatActivity {

    private TextView mCxkTv, mJayTv;

    private LiveDataViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        viewModel = new ViewModelProvider(this).get(LiveDataViewModel.class);

        mCxkTv = findViewById(R.id.tv_cxk);
        mJayTv = findViewById(R.id.tv_jay);

        viewModel.getTicketJay().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mJayTv.setText(String.valueOf(viewModel.getTicketJay().getValue()));
            }
        });

        viewModel.getTickCxk().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mCxkTv.setText(String.valueOf(viewModel.getTickCxk().getValue()));
            }
        });

        findViewById(R.id.btn_cxk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addCxk();
            }
        });

        findViewById(R.id.btn_jay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.addJay();
            }
        });
    }
}
