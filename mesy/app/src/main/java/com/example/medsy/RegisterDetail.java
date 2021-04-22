package com.example.medsy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.medsy.entity.Doctors;
import com.example.medsy.entity.TaskTime;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterDetail extends AppCompatActivity {
    private Handler handler;
    private ListView regDettailListView;
    private RegTimeAdapter regTimeAdapter;
    private Button button;
    private String hhh_id;
    private String docid;
    private String ksid;
    private int timeid;
    private String doctor;
    private List<TaskTime> lists = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_detail);
        button = findViewById(R.id.reg_button);
        regDettailListView = findViewById(R.id.reg_det_TimeList);

//        List<TaskTime> taskTimes = new ArrayList<>();
//        TaskTime taskTime1 = new TaskTime("nian","zhouer","xiawu");
//        TaskTime taskTime2 = new TaskTime("nian","zhouer","xiawu");
//        taskTimes.add(taskTime1);
//        taskTimes.add(taskTime2);



        Intent intent = getIntent();
        hhh_id = intent.getStringExtra("hid");
        ksid = intent.getStringExtra("ksid");
        docid = intent.getStringExtra("docid");
        doctor = intent.getStringExtra("doctor");
        Log.e("hospital id",hhh_id);
        Log.e("department id",ksid);
        Log.e("department id",docid);
        Log.e("detail doctor",doctor);


        getData();



        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                String Timeinfo = (String) msg.obj;
                Log.e("time info", Timeinfo);
                Type type = new TypeToken<List<Doctors>>() {
                }.getType();
                Gson gson = new Gson();
                List<TaskTime> list = gson.fromJson(Timeinfo.trim(), type);
                Log.e("Time error", list.toString());
                //数据展示至页面
                for (int i = 0; i < list.size(); i++){
                    TaskTime taskTime = new TaskTime();
                    taskTime.setId(list.get(i).getId());
                    taskTime.setFlag(list.get(i).getFlag());
                    taskTime.setTaskdtime(list.get(i).getTaskdtime());
                    taskTime.setTaskweek(list.get(i).getTaskweek());
                    taskTime.setTaskday(list.get(i).getTaskday());
                    lists.add(taskTime);
                }
                regTimeAdapter = new RegTimeAdapter(RegisterDetail.this,lists,R.layout.reg_det_time_item);
                regDettailListView.setAdapter(regTimeAdapter);
                Log.e("加载医生", "加载完成");
            }
        };



        regDettailListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //改变时间flag
                lists.get(i).setFlag("1");
                timeid = lists.get(i).getId();

                //传数据库
                getChangeData();


                Intent intent = new Intent(RegisterDetail.this,Task.class);
                intent.putExtra("ksid",ksid);
                intent.putExtra("hid",hhh_id);
                intent.putExtra("docid",docid);
                intent.putExtra("doctor",doctor);

                TaskTime c_taskTime = new TaskTime();
                c_taskTime.setId(lists.get(i).getId());
                c_taskTime.setFlag(lists.get(i).getFlag());
                c_taskTime.setTaskdtime(lists.get(i).getTaskdtime());
                c_taskTime.setTaskweek(lists.get(i).getTaskweek());
                c_taskTime.setTaskday(lists.get(i).getTaskday());
                Gson gson1 = new Gson();
                String time = gson1.toJson(c_taskTime);
                intent.putExtra("time",time);
                Log.e("detail Gson time", time);


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
    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //查找全部flag=0的医生空闲时间
                    URL url = new URL("http://192.168.2.202:8080/medical/user/xx?docid="+docid);
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
    private void getChangeData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //传输改变flag=1的time；
                    URL url = new URL("http://192.168.2.202:8080/medical/user/xx?docid="+docid+"time_id="+timeid);
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
