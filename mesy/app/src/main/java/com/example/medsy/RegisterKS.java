package com.example.medsy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.medsy.entity.Departments;
import com.example.medsy.entity.Hospitals;
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

public class RegisterKS extends AppCompatActivity {
    private String h_id;
    private Handler handler;
    private ListView regsiterKSListView;
    private RegisterKSAdapter registerKSAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_keshi);
        regsiterKSListView = findViewById(R.id.regks_listview);
        final List<Departments> list = new ArrayList<>();
        Departments department1 = new Departments("fuke","zhuanzhifukejibing","xiaofuke");
        Departments department2 = new Departments("fuke","zhuanzhifukejibing","xiaofuke");
        List<Departments> departmentList = new ArrayList<>();
        departmentList.add(department1);
        departmentList.add(department2);
        registerKSAdapter = new RegisterKSAdapter(this,departmentList,R.layout.reg_ks_item);
        regsiterKSListView.setAdapter(registerKSAdapter);
        //获取医院id
        Intent intent = getIntent();
        h_id = intent.getStringExtra("hid");
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                String KeShiinfo = (String) msg.obj;
                Log.e("info", KeShiinfo);
                Type type = new TypeToken<List<Departments>>() {
                }.getType();
                Gson gson = new Gson();
                List<Departments> list = gson.fromJson(KeShiinfo.trim(), type);
                Log.e("error", list.toString());
                //数据展示至页面
                for (int i = 0; i < list.size(); i++){
                    Departments department = new Departments();
                    department.setMain(list.get(i).getMain());
                    department.setLittle(list.get(i).getLittle());
                    department.setIntroduce(list.get(i).getIntroduce());
                    list.add(department);
                }
                registerKSAdapter = new RegisterKSAdapter(RegisterKS.this,list,R.layout.reg_ks_item);
                regsiterKSListView.setAdapter(registerKSAdapter);
                Log.e("加载科室", "加载完成");
            }
        };
        //跳转对应科室展示具体医生页面
        regsiterKSListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               //待补充获取点击item的信息并传递
               Intent intent = new Intent(RegisterKS.this,RegisterDoctor.class);
               intent.putExtra("ksid",list.get(i).getKid());
               startActivity(intent);
           }
        });
    }
    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //查找全部医院
                    URL url = new URL("http://xx:8080/medical/xxxx?hid="+h_id);
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
