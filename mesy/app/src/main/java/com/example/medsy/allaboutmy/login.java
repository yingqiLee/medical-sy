package com.example.medsy.allaboutmy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.medsy.DoctorMainActivity;
import com.example.medsy.HospitalMainActivity;
import com.example.medsy.MainActivity;
import com.example.medsy.R;
import com.example.medsy.entity.Doctors;
import com.example.medsy.entity.Hospitals;
import com.example.medsy.entity.Users;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class login extends AppCompatActivity {
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private EditText phone;
    private EditText pwd;
    private Button button;
    private int flag=0;
    private Handler handler;
    private Users user;
    private Doctors doctor;
    private Hospitals hospital;

    private String phoneText;
    private String pwdText;
    private String info;
    private String load=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = findViewById(R.id.signin);
        checkBox1 = findViewById(R.id.checkbox1);
        checkBox2 = findViewById(R.id.checkbox2);
        phone = findViewById(R.id.phonenumber);
        pwd = findViewById(R.id.password);
        Log.e("顺序1","1");
        Log.e("输入框phone",phoneText+" 加载");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("顺序2","2");
                if(flag==0){

                    phoneText = phone.getText().toString().trim();
                    pwdText = pwd.getText().toString();
                    user = new Users(phoneText,pwdText,flag);
                    Log.e("输入框phone",phoneText+" 0");
                    Gson gson = new Gson();
                    info = gson.toJson(user);
                    load = "user";
                    Log.e("user",info);
                    getData();
                }
                else if(flag==1){
                    phoneText = phone.getText().toString().trim();
                    pwdText = pwd.getText().toString();
                    Log.e("输入框phone",phoneText+" 1");
                    doctor = new Doctors(phoneText,pwdText,flag);
                    Gson gson = new Gson();
                    info = gson.toJson(doctor);
                    load = "Doc";
                    Log.e("doctor",info);
                    getData();
                }
                else if(flag==2){
                    phoneText = phone.getText().toString().trim();
                    pwdText = pwd.getText().toString();
                    Log.e("输入框phone",phoneText+" 2");
                    hospital = new Hospitals(phoneText,pwdText,flag);
                    Gson gson = new Gson();
                    info = gson.toJson(hospital);
                    load = "Hos";
                    Log.e("hospital",info);
                    getData();
                }

            }
        });

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //医生
                flag = 1;
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //医院管理者
                flag = 2;
            }
        });

        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                String info = (String)msg.obj;
                if("密码正确".equals(info)){
                    if(flag==0){
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("phone",phoneText);
                        intent.putExtra("pwd",pwdText);
                        intent.putExtra("Uflag",flag);
                        startActivity(intent);
                        finish();

                    }
                    else if(flag==1){
                        Intent intent = new Intent(getApplicationContext(), DoctorMainActivity.class);
                        intent.putExtra("phone",phoneText);
                        intent.putExtra("pwd",pwdText);
                        intent.putExtra("Uflag",flag);
                        startActivity(intent);
                    }
                    else if(flag==2){
                        Intent intent = new Intent(getApplicationContext(), HospitalMainActivity.class);
                        intent.putExtra("phone",phoneText);
                        intent.putExtra("pwd",pwdText);
                        intent.putExtra("Uflag",flag);
                        startActivity(intent);
                    }
                }
                else if("账号或密码错误".equals(info)){
                    Toast.makeText(getApplicationContext(),info,Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        };
    }
    private void getData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //自己的ip
                    //xxxx对应文件名
                    URL url = new URL("http://36.157.216.55:3306/medical/"+load+"/signin?info="+info);
                    URLConnection conn = url.openConnection();
                    InputStream in = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
                    String c_info = reader.readLine();
                    Log.e("wer", "df" + c_info);
                    wrapperMessage(c_info);
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
