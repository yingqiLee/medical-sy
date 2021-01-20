package com.example.medsy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTabHost;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Map<String, ImageView> imageViewMap = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTabHost fragmentTabHost = findViewById(android.R.id.tabhost);

        fragmentTabHost.setup(this,
                getSupportFragmentManager(),
                android.R.id.tabcontent);

        TabHost.TabSpec tabSpec1 = fragmentTabHost.newTabSpec("tag1")
                .setIndicator(getTabSpecView("tag1",R.drawable.yuyue,"预约"));
        TabHost.TabSpec tabSpec2 = fragmentTabHost.newTabSpec("tag2")
                .setIndicator(getTabSpecView("tag2",R.drawable.find,"发现"));
        TabHost.TabSpec tabSpec3 = fragmentTabHost.newTabSpec("tag3")
                .setIndicator(getTabSpecView("tag3",R.drawable.doctor,"医生"));
        TabHost.TabSpec tabSpec4 = fragmentTabHost.newTabSpec("tag4")
                .setIndicator(getTabSpecView("tag4",R.drawable.my,"我的"));

        fragmentTabHost.addTab(tabSpec1, Appointment.class,null);
        fragmentTabHost.addTab(tabSpec2, Find.class, null);
        fragmentTabHost.addTab(tabSpec3, Doctor.class, null);
        fragmentTabHost.addTab(tabSpec4, My.class, null);

        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                //当切换选项卡时调用
                switch (tabId){
                    case "tag1":
                        imageViewMap.get("tag1").setImageResource(R.drawable.yuyue1);
                        imageViewMap.get("tag2").setImageResource(R.drawable.find);
                        imageViewMap.get("tag3").setImageResource(R.drawable.doctor);
                        imageViewMap.get("tag4").setImageResource(R.drawable.my1);
                        break;
                    case "tag2":
                        imageViewMap.get("tag1").setImageResource(R.drawable.yuyue);
                        imageViewMap.get("tag2").setImageResource(R.drawable.find1);
                        imageViewMap.get("tag3").setImageResource(R.drawable.doctor);
                        imageViewMap.get("tag4").setImageResource(R.drawable.my1);
                        break;
                    case "tag3":
                        imageViewMap.get("tag1").setImageResource(R.drawable.yuyue);
                        imageViewMap.get("tag2").setImageResource(R.drawable.find);
                        imageViewMap.get("tag3").setImageResource(R.drawable.doctor1);
                        imageViewMap.get("tag4").setImageResource(R.drawable.my1);
                        break;
                    case "tag4":
                        imageViewMap.get("tag1").setImageResource(R.drawable.yuyue);
                        imageViewMap.get("tag2").setImageResource(R.drawable.find);
                        imageViewMap.get("tag3").setImageResource(R.drawable.doctor);
                        imageViewMap.get("tag4").setImageResource(R.drawable.my);
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
