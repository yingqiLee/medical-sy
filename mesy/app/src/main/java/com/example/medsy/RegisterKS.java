package com.example.medsy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.medsy.entity.Departments;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterKS extends AppCompatActivity {
    private ListView regsiterKSListView;
    private RegisterKSAdapter registerKSAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_keshi);
        regsiterKSListView = findViewById(R.id.regks_listview);
        Departments department1 = new Departments("fuke","zhuanzhifukejibing","xiaofuke");
        Departments department2 = new Departments("fuke","zhuanzhifukejibing","xiaofuke");
        List<Departments> departmentList = new ArrayList<>();
        departmentList.add(department1);
        departmentList.add(department2);
        registerKSAdapter = new RegisterKSAdapter(this,departmentList,R.layout.reg_ks_item);
        regsiterKSListView.setAdapter(registerKSAdapter);
        //跳转对应科室展示具体医生页面
        regsiterKSListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               //待补充获取点击item的信息并传递
               Intent intent = new Intent(RegisterKS.this,RegisterDoctor.class);
               startActivity(intent);
           }
        });
    }
}
