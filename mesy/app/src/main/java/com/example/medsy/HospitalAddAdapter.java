package com.example.medsy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.medsy.R;
import com.example.medsy.entity.Departments;

import java.util.ArrayList;
import java.util.List;

public class HospitalAddAdapter extends BaseAdapter {

    private Context context;
    private List<Departments> contents = new ArrayList<>();//需要显示的数据
    private int itemLayoutId;//item对应的布局文件的资源id

    public HospitalAddAdapter(Context context, List<Departments> contents, int itemLayoutId) {
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
        TextView Maintext = convertView.findViewById(R.id.hos_main_text);
        TextView LittleView = convertView.findViewById(R.id.hos_little_text);
        TextView IntroduceView = convertView.findViewById(R.id.hos_introduce_text);
        Maintext.setText(contents.get(position).getMain());
        LittleView.setText(contents.get(position).getLittle());
        IntroduceView.setText(contents.get(position).getIntroduce());
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
