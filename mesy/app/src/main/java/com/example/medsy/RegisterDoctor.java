package com.example.medsy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.medsy.entity.Doctors;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterDoctor extends AppCompatActivity {
    private ListView RegDocListView;
    private RegDoctorAdapter regDoctorAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_doctor);
        RegDocListView = findViewById(R.id.Reg_doc_listview);
        List<Doctors> doctors = new ArrayList<>();
        Doctors doctor1 = new Doctors("yishenga","zhirenyishi","shanchangtangniaobing");
        Doctors doctor2 = new Doctors("yishenga","zhirenyishi","shanchangtangniaobing");
        doctors.add(doctor1);
        doctors.add(doctor2);
        regDoctorAdapter = new RegDoctorAdapter(this,doctors,R.layout.reg_doc_item);
        RegDocListView.setAdapter(regDoctorAdapter);
        //跳转挂号详情单
        RegDocListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(RegisterDoctor.this,RegisterDetail.class);
                startActivity(intent);
            }
        });
    }
}
