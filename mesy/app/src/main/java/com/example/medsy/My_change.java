package com.example.medsy;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medsy.entity.Users;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class My_change extends AppCompatActivity {
    private TextView text_name;
    private TextView text_phone;
    private ImageView butn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_change);
        text_name = findViewById(R.id.user_name);
        text_phone = findViewById(R.id.user_iphone);
        butn = findViewById(R.id.change_jiantou);
        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Users users = new Users();
        String newName = text_name.getText().toString();
        String newPhone = text_phone.getText().toString();
        users.setuName(newName);
        users.setuPhone(newPhone);
        //Gson传输
    }
}
