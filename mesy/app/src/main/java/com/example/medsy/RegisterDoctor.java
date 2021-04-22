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
import com.example.medsy.entity.Doctors;
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

public class RegisterDoctor extends AppCompatActivity {
    private Handler handler;
    private ListView RegDocListView;
    private RegDoctorAdapter regDoctorAdapter;
    private String hh_id;
    private String ks_id;
    private List<Doctors> lists = new ArrayList<>();;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_doctor);
        RegDocListView = findViewById(R.id.Reg_doc_listview);

        //获取hid、depratmentsid;
        Intent intent = getIntent();
        hh_id = intent.getStringExtra("hid");
        ks_id = intent.getStringExtra("ksid");
        Log.e("hospital id",hh_id);
        Log.e("department id",ks_id);


        getData();
//        List<Doctors> doctors = new ArrayList<>();
//        Doctors doctor1 = new Doctors("yishenga","zhirenyishi","shanchangtangniaobing");
//        Doctors doctor2 = new Doctors("yishenga","zhirenyishi","shanchangtangniaobing");
//        doctors.add(doctor1);
//        doctors.add(doctor2);


        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);

                String DoctorShiinfo = (String) msg.obj;
                Log.e("doctor info", DoctorShiinfo);
                Type type = new TypeToken<List<Doctors>>() {
                }.getType();
                Gson gson = new Gson();
                List<Doctors> list = gson.fromJson(DoctorShiinfo.trim(), type);
                Log.e("Keshi error", list.toString());
                //数据展示至页面
                for (int i = 0; i < list.size(); i++){
                    Doctors doctor1 = new Doctors();
                    doctor1.setDname(list.get(i).getDname());
                    doctor1.setDdepartment(list.get(i).getDdepartment());
                    doctor1.setDtitle(list.get(i).getDtitle());
                    doctor1.setDskill(list.get(i).getDskill());
                    lists.add(doctor1);
                }
                regDoctorAdapter = new RegDoctorAdapter(RegisterDoctor.this,lists,R.layout.reg_doc_item);
                RegDocListView.setAdapter(regDoctorAdapter);
                Log.e("加载医生", "加载完成");
            }
        };

        //跳转挂号详情单
        RegDocListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(RegisterDoctor.this,RegisterDetail.class);
                intent.putExtra("ksid",lists.get(i).getD_uid());
                intent.putExtra("hid",hh_id);
                intent.putExtra("docid",lists.get(i).getD_uid());


                Doctors doctor2 = new Doctors();
                doctor2.setDname(lists.get(i).getDname());
                doctor2.setDdepartment(lists.get(i).getDdepartment());
                doctor2.setDskill(lists.get(i).getDskill());
                doctor2.setDtitle(lists.get(i).getDtitle());
                Gson gson = new Gson();
                String doctor = gson.toJson(doctor2);
                intent.putExtra("doctor",doctor);


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
                    URL url = new URL("http://192.168.2.202:8080/medical/user/xx?ksid="+ks_id+"hid="+hh_id);
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
