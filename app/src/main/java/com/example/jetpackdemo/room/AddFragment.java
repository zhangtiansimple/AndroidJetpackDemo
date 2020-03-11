package com.example.jetpackdemo.room;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jetpackdemo.R;

import java.util.Objects;

//Entity
//Dao
//Database

public class AddFragment extends Fragment {

    private AddViewModel mViewModel;

    private String name, works;

    public static AddFragment newInstance() {
        return new AddFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddViewModel.class);
        // TODO: Use the ViewModel
        initView();
    }

    private void initView() {
        final EditText nameEt = Objects.requireNonNull(getView()).findViewById(R.id.name_et);
        final EditText worksEt = Objects.requireNonNull(getView()).findViewById(R.id.works_et);
        Objects.requireNonNull(getView()).findViewById(R.id.btn_sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameEt.getText().toString();
                works = worksEt.getText().toString();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(works)) {
                    Toast.makeText(getContext(), "请输入完整信息！", Toast.LENGTH_SHORT).show();
                    return;
                }
                insert();
                NavController controller = Navigation.findNavController(getView());
                controller.navigate(R.id.action_addFragment_to_worksFragment);
            }
        });
    }

    private void insert() {
        WorksRepository.getInstance(getContext()).getWorksDao().insert(new WorksEntity(name, works));
    }
}
