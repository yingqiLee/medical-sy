package com.example.medsy;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.medsy.entity.Hospitals;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//预约界面
public class Register extends AppCompatActivity {
    private ListView hoslistView;
    private RegHosListAdapter hosListAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        hoslistView = findViewById(R.id.Reg_hos_listview);
        List<Hospitals> hospitalsList = new ArrayList<>();
        Hospitals hospital1 = new Hospitals("yiyuana","sanjijiadeng","zongheyiyuan","haopingdiyi");
        Hospitals hospital2 = new Hospitals("yiyuanb","sanjijiadeng","zongheyiyuan","haopingdiyi");
        hospitalsList.add(hospital1);
        hospitalsList.add(hospital2);
        hosListAdapter = new RegHosListAdapter(this,hospitalsList,R.layout.reghositem);
        hoslistView.setAdapter(hosListAdapter);
        //listview设置监听，点击每一个item跳转对应
        //跳转对应医院展示并选择科室
        hoslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //待补充获取点击item的信息并传递

                Intent intent = new Intent(Register.this,RegisterKS.class);
                startActivity(intent);
            }
        });

    }
}
