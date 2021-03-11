package com.example.medsy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Appointment extends Fragment {
    private TextView zj;
    private TextView yy;
    private TextView gh;
    private TextView wz;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_appointment,container,false);
        //获取预约首页的跳转textviewid
        zj = view.findViewById(R.id.zjText);
        yy = view.findViewById(R.id.yyText);
        gh = view.findViewById(R.id.ghText);
        wz = view.findViewById(R.id.wzdtText);
        //预约首页跳转页面
        zj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进入专家推荐页面
                Intent intent = new Intent(view.getContext(),Expert.class);
                startActivity(intent);

            }
        });
        yy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进入医院排行页面
                //测试进入医生登录页面
                Intent intent = new Intent(view.getContext(),DoctorMainActivity.class);
                startActivity(intent);
            }
        });
        gh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进入挂号页面
                Intent intent = new Intent(view.getContext(),Register.class);
                startActivity(intent);
            }
        });
        wz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //进入问诊大厅页面
                Intent intent = new Intent(view.getContext(),Consultation.class);
                startActivity(intent);
            }
        });
        return view;

    }
}
