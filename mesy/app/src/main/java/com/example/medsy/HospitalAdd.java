package com.example.medsy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.medsy.entity.Departments;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HospitalAdd extends Fragment {
    private EditText MaineditText;
    private EditText LittleeidtText;
    private EditText IntroduceText;
    private Button btnAdd;
    private ListView listView;
    private HospitalAddAdapter myAdapter;
    private List<Departments> dataList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hospital_add,container,false);
        final Departments department1 = new Departments("111","222","333");
        Departments department2 = new Departments("111","222","333");
        dataList.add(department1);
        dataList.add(department2);
        MaineditText = view.findViewById(R.id.hos_main_text);
        LittleeidtText = view.findViewById(R.id.hos_little_text);
        IntroduceText = view.findViewById(R.id.hos_introduce_text);
        btnAdd = view.findViewById(R.id.hos_add);
        listView = view.findViewById(R.id.lv_data);
        myAdapter = new HospitalAddAdapter(getContext(),dataList,R.layout.hospital_dep_item);
        listView.setAdapter(myAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Departments departments = new Departments(MaineditText.getText().toString(),LittleeidtText.getText().toString(),IntroduceText.getText().toString());

                dataList.add(departments);
                myAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }
}
