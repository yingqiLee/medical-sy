package com.example.medsy;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.medsy.entity.Doctors;
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
//预约界面
public class Register extends AppCompatActivity {
    private Handler handler;
    private ListView hoslistView;
    private RegHosListAdapter hosListAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        final List<Hospitals> lists=new ArrayList<>();
        hoslistView = findViewById(R.id.Reg_hos_listview);
//        final List<Hospitals> hospitalsList = new ArrayList<>();
//        Hospitals hospital1 = new Hospitals("yiyuana","sanjijiadeng","zongheyiyuan","haopingdiyi");
//        Hospitals hospital2 = new Hospitals("yiyuanb","sanjijiadeng","zongheyiyuan","haopingdiyi");
//        hospitalsList.add(hospital1);
//        hospitalsList.add(hospital2);
//        hosListAdapter = new RegHosListAdapter(this,hospitalsList,R.layout.reghositem);
//        hoslistView.setAdapter(hosListAdapter);
        Log.e("进入测试","1111111");
        getData();
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                String Hospitalinfo = (String) msg.obj;
                Log.e("info", Hospitalinfo);
                Type type = new TypeToken<List<Hospitals>>() {
                }.getType();
                Gson gson = new Gson();
                List<Hospitals> list = gson.fromJson(Hospitalinfo.trim(), type);
                Log.e("Hospital error", list.toString());
                //数据展示至页面
                for (int i = 0; i < list.size(); i++){
                    Hospitals hospital = new Hospitals();
                    hospital.setName(list.get(i).getName());
                    hospital.setGrade(list.get(i).getGrade());
                    hospital.setRank(list.get(i).getRank());
                    hospital.setType(list.get(i).getType());
                    lists.add(hospital);
                }
                Log.e("加载医院", "加载完成");
                hosListAdapter = new RegHosListAdapter(Register.this,lists,R.layout.reghositem);
                hoslistView.setAdapter(hosListAdapter);
            }
        };
        //listview设置监听，点击每一个item跳转对应
        //跳转对应医院展示并选择科室
        hoslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //待补充获取点击item的信息并传递
                Log.e("hospital点击测试",lists.get(i).getName());

                Intent intent = new Intent(Register.this,RegisterKS.class);
                //根据医院id查找对应医院全部科室
                intent.putExtra("hname",lists.get(i).getName());
                intent.putExtra("hid",lists.get(i).getId());
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
                    URL url = new URL("http://192.168.2.202:8080/medical/user/xx?");
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
