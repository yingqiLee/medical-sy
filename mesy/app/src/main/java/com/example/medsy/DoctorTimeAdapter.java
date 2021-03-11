package com.example.medsy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.medsy.entity.TaskTime;

import java.util.ArrayList;
import java.util.List;

public class DoctorTimeAdapter extends BaseAdapter {
    private Context context;
    private List<TaskTime> contents = new ArrayList<>();//需要显示的数据
    private int itemLayoutId;//item对应的布局文件的资源id

    public DoctorTimeAdapter(Context context, List<TaskTime> contents, int itemLayoutId) {
        this.context = context;
        this.contents = contents;
        this.itemLayoutId = itemLayoutId;
    }

    @Override
    public int getCount() {
        if (null != contents){
            return contents.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (null != contents){
            return contents.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (null == convertView){
            //加载item对应的布局文件
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(itemLayoutId,null);
        }

        //获得每个item的TextView对象和Button对象，并给每个item的Button添加点击事件监听器
        TextView yeartext= convertView.findViewById(R.id.tv_content_year);
        TextView weektext = convertView.findViewById(R.id.tv_content_week);
        TextView daytext = convertView.findViewById(R.id.tv_content_day);
        yeartext.setText(contents.get(position).getTaskdtime());
        weektext.setText(contents.get(position).getTaskweek());
        daytext.setText(contents.get(position).getTaskday());
        Button button = convertView.findViewById(R.id.btn_delete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实现删除数据
                contents.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
}
