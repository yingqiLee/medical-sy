package com.example.medsy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.medsy.entity.Doctors;
import com.example.medsy.entity.TaskTime;

import java.util.ArrayList;
import java.util.List;

public class RegTimeAdapter extends BaseAdapter {

    private Context context;
    private List<TaskTime> contexts = new ArrayList<>();
    private int id;

    public RegTimeAdapter(Context context, List<TaskTime> contexts, int id) {
        this.context = context;
        this.contexts = contexts;
        this.id = id;
    }

    @Override
    public int getCount() {
        if (null != contexts){
            return contexts.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (null != contexts){
            return contexts.get(position);
        }
        return null;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            //加载item对应的布局文件
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(id, null);
        }

        //获得每个item的TextView对象和Button对象，并给每个item的Button添加点击事件监听器
        TextView tyear = convertView.findViewById(R.id.time_year);
        TextView tweek = convertView.findViewById(R.id.time_week);
        TextView tday = convertView.findViewById(R.id.time_day);
        tyear.setText(contexts.get(position).getTaskdtime());
        tweek.setText(contexts.get(position).getTaskweek());
        tday.setText(contexts.get(position).getTaskday());
        return convertView;
    }
}
