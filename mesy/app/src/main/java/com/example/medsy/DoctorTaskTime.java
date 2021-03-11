package com.example.medsy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.medsy.entity.TaskTime;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DoctorTaskTime extends Fragment {
    private EditText yearEditText;
    private EditText weekEditText;
    private EditText dayEditText;
    private Button btnAdd;
    private ListView listView;
    private DoctorTimeAdapter myAdapter;
    private List<TaskTime> dataList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_doctortasktime,container,false);
        TaskTime taskTime1 = new TaskTime("2020","zhouer","shangwu");
        TaskTime taskTime2 = new TaskTime("2020","zhouer","shangwu");
        dataList.add(taskTime1);
        dataList.add(taskTime2);
        //获取视图控件的引用
        yearEditText = view.findViewById(R.id.et_content_year);
        weekEditText = view.findViewById(R.id.et_content_week);
        dayEditText = view.findViewById(R.id.et_content_day);
        btnAdd = view.findViewById(R.id.btn_add);
        listView = view.findViewById(R.id.lv_data);
        setAdapters();
        setListeners();
        return view;
    }

    public void setListeners(){
        MyClickListener clickListener = new MyClickListener();
        btnAdd.setOnClickListener(clickListener);
    }

    public void setAdapters(){
        myAdapter = new DoctorTimeAdapter(getContext(),dataList,R.layout.time_item);
        listView.setAdapter(myAdapter);
    }

    private class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            //点击添加按钮执行
            String content1 = yearEditText.getText().toString();
            String content2 = weekEditText.getText().toString();
            String content3 = dayEditText.getText().toString();
            TaskTime taskTime = new TaskTime(content1,content2,content3);
            dataList.add(taskTime);
            myAdapter.notifyDataSetChanged();
        }
    }
}
