package com.example.jetpackdemo.databinding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.jetpackdemo.R;

public class DataBindingActivity extends AppCompatActivity {

    private DataBindingViewModel viewModel;

    private ActivityDatabindingBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        viewModel = new ViewModelProvider(this).get(DataBindingViewModel.class);
        binding.setData(viewModel);
        binding.setLifecycleOwner(this);
    }
}
