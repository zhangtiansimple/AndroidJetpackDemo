package com.example.jetpackdemo.paging;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.room.WorksEntity;
import com.example.jetpackdemo.room.WorksRepository;

public class PagingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        final PagingAdapter adapter = new PagingAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LiveData<PagedList<WorksEntity>> datas = new LivePagedListBuilder<>(WorksRepository.getInstance(this).getWorksDao().getWorksForPaging(), 15).build();
        datas.observe(this, new Observer<PagedList<WorksEntity>>() {
            @Override
            public void onChanged(PagedList<WorksEntity> worksEntities) {
                adapter.submitList(worksEntities);
            }
        });
    }
}
