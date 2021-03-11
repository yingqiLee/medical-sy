package com.example.medsy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medsy.entity.Departments;
import com.example.medsy.entity.Hospitals;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RegisterKSAdapter extends BaseAdapter {

    private Context context;
    private List<Departments> contexts = new ArrayList<>();
    private int id;

    public RegisterKSAdapter(Context context, List<Departments> contexts, int id) {
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
        if (null == convertView){
            //加载item对应的布局文件
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(id,null);
        }

        //获得每个item的TextView对象和Button对象，并给每个item的Button添加点击事件监听器
        TextView depMain = convertView.findViewById(R.id.main);
        TextView depIntroduce= convertView.findViewById(R.id.introduce);
        TextView depLittle = convertView.findViewById(R.id.little);
        depMain.setText(contexts.get(position).getMain());
        depIntroduce.setText(contexts.get(position).getIntroduce());
        depLittle.setText(contexts.get(position).getLittle());
//        Button button = convertView.findViewById(R.id.btn_delete);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //实现删除数据
//                contents.remove(position);
//                notifyDataSetChanged();
//            }
//        });
        return convertView;
    }
//    private int getDrawableID(String str) {
//        try {
//            String name = str;
//            Field field = R.drawable.class.getField(name);
//            int DrawableID = 0;
//            DrawableID = field.getInt(new R.drawable());
//            return DrawableID;
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//            return 0;
//        }
//        catch (NoSuchFieldException e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
}
