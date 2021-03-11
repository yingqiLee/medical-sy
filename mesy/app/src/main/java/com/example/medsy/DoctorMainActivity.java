package com.example.medsy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.medsy.Contacts;
import com.example.medsy.Doctor;
import com.example.medsy.R;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;

public class DoctorMainActivity extends AppCompatActivity {
    private Map<String, ImageView> imageViewMap = new HashMap<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_main);
        FragmentTabHost fragmentTabHost = findViewById(android.R.id.tabhost);
        fragmentTabHost.setup(this,
                getSupportFragmentManager(),
                android.R.id.tabcontent);

        TabHost.TabSpec tabSpec1 = fragmentTabHost.newTabSpec("tag1")
                .setIndicator(getTabSpecView("tag1",R.drawable.yuyue,"联系人"));
        TabHost.TabSpec tabSpec2 = fragmentTabHost.newTabSpec("tag2")
                .setIndicator(getTabSpecView("tag2",R.drawable.find,"时间"));
        TabHost.TabSpec tabSpec3 = fragmentTabHost.newTabSpec("tag3")
                .setIndicator(getTabSpecView("tag3",R.drawable.doctor,"我的"));

        fragmentTabHost.addTab(tabSpec1, Contacts.class,null);
        fragmentTabHost.addTab(tabSpec2, DoctorTaskTime.class, null);
        fragmentTabHost.addTab(tabSpec3, DoctorMy.class, null);

        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                //当切换选项卡时调用
                switch (tabId){
                    case "tag1":
                        imageViewMap.get("tag1").setImageResource(R.drawable.yuyue1);
                        imageViewMap.get("tag2").setImageResource(R.drawable.find);
                        imageViewMap.get("tag3").setImageResource(R.drawable.doctor);
                        break;
                    case "tag2":
                        imageViewMap.get("tag1").setImageResource(R.drawable.yuyue);
                        imageViewMap.get("tag2").setImageResource(R.drawable.find1);
                        imageViewMap.get("tag3").setImageResource(R.drawable.doctor);
                        break;
                    case "tag3":
                        imageViewMap.get("tag1").setImageResource(R.drawable.yuyue);
                        imageViewMap.get("tag2").setImageResource(R.drawable.find);
                        imageViewMap.get("tag3").setImageResource(R.drawable.doctor1);
                        break;
                    case "tag4":
                        imageViewMap.get("tag1").setImageResource(R.drawable.yuyue);
                        imageViewMap.get("tag2").setImageResource(R.drawable.find);
                        imageViewMap.get("tag3").setImageResource(R.drawable.doctor);
                        break;
                }
            }
        });
    }
    public View getTabSpecView(String tag, int imageResId, String title) {
        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.tabbutton,null);

        ImageView imageView = view.findViewById(R.id.tabbutton_img);
        imageView.setImageResource(imageResId);

        TextView textView = view.findViewById(R.id.tabbutton_text);
        textView.setText(title);

        imageViewMap.put(tag,imageView);
        return view;
    }
}
