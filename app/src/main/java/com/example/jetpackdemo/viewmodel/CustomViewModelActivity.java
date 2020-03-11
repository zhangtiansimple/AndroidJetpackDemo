package com.example.jetpackdemo.viewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.jetpackdemo.R;

public class CustomViewModelActivity extends AppCompatActivity {

    private CustomViewModel viewModel;

    private TextView mCxkTv, mJayTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        mCxkTv = findViewById(R.id.tv_cxk);
        mJayTv = findViewById(R.id.tv_jay);
        viewModel = new ViewModelProvider(this).get(CustomViewModel.class);
        mCxkTv.setText(String.valueOf(viewModel.getTicketCxk()));
        mJayTv.setText(String.valueOf(viewModel.getTicketJay()));

        findViewById(R.id.btn_cxk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setTicketCxk(viewModel.getTicketCxk() + 1);
                mCxkTv.setText(String.valueOf(viewModel.getTicketCxk()));
            }
        });

        findViewById(R.id.btn_jay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setTicketJay(viewModel.getTicketJay() + 1);
                mJayTv.setText(String.valueOf(viewModel.getTicketJay()));
            }
        });
    }
}
