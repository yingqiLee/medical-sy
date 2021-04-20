package com.example.medsy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.medsy.entity.Departments;
import com.example.medsy.entity.Taskitems;

import java.util.ArrayList;
import java.util.List;

public class FindTasksAdapter extends BaseAdapter {
    private Context context;
    private List<Taskitems> contents = new ArrayList<>();//需要显示的数据
    private int itemLayoutId;//item对应的布局文件的资源id

    public FindTasksAdapter(Context context, List<Taskitems> contents, int itemLayoutId) {
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

        //获得每个item的TextView对象
        TextView Hos = convertView.findViewById(R.id.find_hos);
        TextView Doc = convertView.findViewById(R.id.find_doc);
        TextView Year = convertView.findViewById(R.id.find_year);
        TextView Week = convertView.findViewById(R.id.find_week);
        TextView Day = convertView.findViewById(R.id.find_day);
        Hos.setText(contents.get(position).getHosName());
        Doc.setText(contents.get(position).getDocName());
        Year.setText(contents.get(position).getT_time());
        Week.setText(contents.get(position).getT_week());
        Day.setText(contents.get(position).getT_day());
        return convertView;
    }
}
