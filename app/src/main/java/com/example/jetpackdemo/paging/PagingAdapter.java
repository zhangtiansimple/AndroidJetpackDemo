package com.example.jetpackdemo.paging;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.room.WorksEntity;

public class PagingAdapter extends PagedListAdapter<WorksEntity, PagingAdapter.CustomViewHolder> {

    protected PagingAdapter() {
        super(new DiffUtil.ItemCallback<WorksEntity>() {
            @Override
            public boolean areItemsTheSame(@NonNull WorksEntity oldItem, @NonNull WorksEntity newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull WorksEntity oldItem, @NonNull WorksEntity newItem) {
                return !oldItem.getName().equals(newItem.getName()) && !oldItem.getWorks().equals(newItem.getWorks());
            }
        });
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paging_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        WorksEntity worksEntity = getItem(position);
        if (worksEntity != null) {
            holder.worksTv.setText(worksEntity.getWorks());
            holder.nameTv.setText(worksEntity.getName());
        } else {
            holder.worksTv.setText("loading..");
        }
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView nameTv, worksTv;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.tv_name);
            worksTv = itemView.findViewById(R.id.tv_works);
        }
    }
}
