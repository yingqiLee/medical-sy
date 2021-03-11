package com.example.medsy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.medsy.entity.TaskTime;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterDetail extends AppCompatActivity {
    private ListView regDettailListView;
    private RegTimeAdapter regTimeAdapter;
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_detail);
        button = findViewById(R.id.reg_button);
        Log.e("找到id","111");
        List<TaskTime> taskTimes = new ArrayList<>();
        TaskTime taskTime1 = new TaskTime("nian","zhouer","xiawu");
        TaskTime taskTime2 = new TaskTime("nian","zhouer","xiawu");
        taskTimes.add(taskTime1);
        taskTimes.add(taskTime2);
        regDettailListView = findViewById(R.id.reg_det_TimeList);
        regTimeAdapter = new RegTimeAdapter(this,taskTimes,R.layout.reg_det_time_item);
        regDettailListView.setAdapter(regTimeAdapter);
        regDettailListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(RegisterDetail.this,Task.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterDetail.this,Chat.class);
                startActivity(intent);
            }
        });

    }
}
