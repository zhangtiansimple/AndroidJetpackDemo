package com.example.jetpackdemo.room;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jetpackdemo.R;

import java.util.List;

public class WorksFragment extends Fragment {

    private WorksViewModel mViewModel;
    private TextView mResultTv;

    public static WorksFragment newInstance() {
        return new WorksFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.works_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(WorksViewModel.class);
        // TODO: Use the ViewModel
        final NavController controller = Navigation.findNavController(getView());
        mResultTv = getView().findViewById(R.id.tv_desc);
        getView().findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.navigate(R.id.action_worksFragment_to_addFragment);
            }
        });
        getView().findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchAll();
            }
        });
        getView().findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAll();
            }
        });
    }

    private void deleteAll() {
        WorksRepository.getInstance(getContext()).getWorksDao().deleteAll();
    }

    private void searchAll() {
        List<WorksEntity> list = WorksRepository.getInstance(getContext()).getWorksDao().getWorks();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getWorks()).append(" ").append(list.get(i).getName()).append("\n");
        }
        mResultTv.setText(sb.toString());
    }
}
