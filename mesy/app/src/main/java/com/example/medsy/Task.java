package com.example.medsy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.medsy.entity.Doctors;
import com.example.medsy.entity.TaskTime;
import com.example.medsy.entity.Tasks;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Task extends AppCompatActivity {
    private TextView doc_name;
    private TextView doc_title;
    private TextView doc_skill;
    private EditText u_name;
    private EditText u_disease;
    private Button button;
    private String hos_id;
    private String ksid;
    private String docid;
    private String doctor;
    private String time;
    private Doctors doctors;
    private TaskTime taskTime;
    private Handler handler;
    private String task_info;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_task);

        doc_name = findViewById(R.id.reg_doc_name);
        doc_title = findViewById(R.id.reg_doc_title);
        doc_skill = findViewById(R.id.reg_doc_skill);
        u_name = findViewById(R.id.reg_name);
        u_disease = findViewById(R.id.reg_disease);

        Intent intent = getIntent();
        hos_id = intent.getStringExtra("hid");
        ksid = intent.getStringExtra("ksid");
        docid = intent.getStringExtra("docid");
        doctor = intent.getStringExtra("doctor");
        time = intent.getStringExtra("time");
        Log.e("hospital id",hos_id);
        Log.e("department id",ksid);
        Log.e("department id",docid);
        Log.e("detail doctor",doctor);
        Log.e("detail time",time);

        Gson gson = new Gson();
        doctors = gson.fromJson(doctor.trim(),Doctors.class);
        taskTime = gson.fromJson(time.trim(),TaskTime.class);

        doc_name.setText(doctors.getDname());
        doc_title.setText(doctors.getDtitle());
        doc_skill.setText(doctors.getDskill());


        button = findViewById(R.id.task_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //传输task信息
                Tasks tasks = new Tasks();
                tasks.setDocId(Integer.parseInt(docid));
                tasks.setHosId(Integer.parseInt(hos_id));
                tasks.setIntroduction(u_disease.getText().toString());
                tasks.setT_uName(u_name.getText().toString());
                tasks.setT_time(taskTime.getTaskdtime());
                taskTime.setTaskweek(taskTime.getTaskweek());
                taskTime.setTaskday(taskTime.getTaskday());
                Gson gson1 = new Gson();
                task_info = gson1.toJson(taskTime);
                getData();
                finish();
            }
        });

    }
    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://192.168.2.202:8080/medical/user/xx?tasks="+task_info);
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    String info = reader.readLine();
                    Log.e("wer", "df" + info);
                    wrapperMessage(info);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    private void wrapperMessage(String info){
        Message msg = Message.obtain();
        msg.obj = info;
        handler.sendMessage(msg);
    }
}
