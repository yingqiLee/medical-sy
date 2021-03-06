package com.example.medsy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class My extends Fragment {
    private ImageView settings;
    private ImageView tasksmap;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_my,container,false);
        settings = view.findViewById(R.id.u_change_image);
        tasksmap = view.findViewById(R.id.u_findtask_image);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),My_change.class);
                startActivity(intent);

            }
        });
        tasksmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),FindTasks.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
