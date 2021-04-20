package com.example.medsy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.medsy.entity.Taskitems;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class FindTasks extends AppCompatActivity {
    private List<Taskitems> datalist = new ArrayList<>();
    private FindTasksAdapter findTasksAdapter;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findtasks);
        Taskitems taskitem1 = new Taskitems("doctor","hospital","time","week","day");
        Taskitems taskitem2 = new Taskitems("doctor","hospital","time","week","day");
        datalist.add(taskitem1);
        datalist.add(taskitem2);
        listView = findViewById(R.id.findtasksList);
        findTasksAdapter = new FindTasksAdapter(FindTasks.this,datalist,R.layout.findtasks_item);
        listView.setAdapter(findTasksAdapter);
    }
}
