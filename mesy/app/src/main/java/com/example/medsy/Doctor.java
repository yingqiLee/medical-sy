package com.example.medsy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.medsy.entity.Doctors;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Doctor extends Fragment {
    private ListView doctorListView;
    private RegDoctorAdapter doctorAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_doctor,container,false);
        doctorListView = view.findViewById(R.id.doc_List);
        List<Doctors> doctors = new ArrayList<>();
        Doctors doctor1 = new Doctors("yishenga","zhirenyishi","shanchangtangniaobing");
        Doctors doctor2 = new Doctors("yishenga","zhirenyishi","shanchangtangniaobing");
        doctors.add(doctor1);
        doctors.add(doctor2);
        doctorAdapter = new RegDoctorAdapter(getContext(),doctors,R.layout.reg_doc_item);
        //跳转挂号详情单
        doctorListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(),RegisterDetail.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
