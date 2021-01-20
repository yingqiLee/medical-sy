package com.example.medsy.allaboutmy;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medsy.R;

public class userpwd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userpwd);
    }



//    private PwdEditText p;
//    private EditText userMsgNum;
//    private Button userSignup;
//    private Button userGetMsg;
//    private TextView numTv;
//    private SQLiteDatabase db;
//    private MyDataBaseHelper helper;
//    QMUITipDialog tip;
//    private ImageView logo;
//
//
//    //msg需要
//
//    private String phone_number;
//    private String cord_number;
//    EventHandler eventHandler;
//    private int time = 60;
//    private boolean flag = true;
//
//
//
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_user_msg);
////        getView();
////        initDataBase();
////        QMUISwipeBackActivityManager.init(getApplication());
////        SharedPreferences sharedPreferences =getSharedPreferences("stu",MODE_PRIVATE);
////        String stuJson=sharedPreferences.getString("stujson",null);
////        if(null!=stuJson){
////            StudentInfo studentInfo=new StuInfoHttpUtil().getStuInfo(stuJson);
////            Glide.with(getApplicationContext()).load(studentInfo.getStuImg()).into(logo);
////        }
//
////        eventHandler = new EventHandler() {
////            public void afterEvent(int event, int result, Object data) {
////                Message msg=new Message();
////                msg.arg1=event;
////                msg.arg2=result;
////                msg.obj=data;
////                handler.sendMessage(msg);
////            }
////        };
////
////        SMSSDK.registerEventHandler(eventHandler);
//
//
//    //        p.setOnTextChangeListener(new PwdEditText.OnTextChangeListener() {
////            @Override
////            public void onTextChange(String pwd) {
////                        if(pwd.length() == p.getTextLength()){
////                            Toast.makeText(userMsgActivity.this,pwd,Toast.LENGTH_SHORT).show();
////                        }
////            }
////        });
////
////        userGetMsg.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                if (judPhone())//去掉左右空格获取字符串
////                {
////                    //验证机制
////                    SMSSDK.getVerificationCode("86", phone_number);
////                    //edit_cord.requestFocus();
////                    //动画效果
////                    numTv.setVisibility(View.INVISIBLE);
////                    ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(userGetMsg, "translationX", 0, -2000);
////                    ObjectAnimator scaleY2 = ObjectAnimator.ofFloat(userMsgNum, "translationX", 0, -2000);
////                    // 创建一个属性动画集合,
////                    AnimatorSet animSet1 = new AnimatorSet();
////                    animSet1.play(scaleY1).with(scaleY2);
////                    animSet1.setDuration(1100);
////                    animSet1.start();
////                    ObjectAnimator alpha4 = ObjectAnimator.ofFloat(p, "alpha", 0, 1);
////                    ObjectAnimator alpha3 = ObjectAnimator.ofFloat(userSignup, "alpha", 0, 1);
////                    AnimatorSet animSet3 = new AnimatorSet();
////                    animSet3.play(alpha3).with(alpha4);
////                    animSet3.setDuration(1300);
////                    animSet3.start();
////                    userSignup.setVisibility(View.VISIBLE);
////                    p.setVisibility(View.VISIBLE);
////                    numTv.setVisibility(View.INVISIBLE);
////                    numTv.setText(phone_number);
////                }
////            }
////        });
////
////
////
////        userSignup.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                if(judCord())
////                    SMSSDK.submitVerificationCode("86",phone_number,cord_number);
////                    flag=false;
////            }
////        });
////
////
////
////
////
////    }
////
////
//    public void getView(){
//        p = findViewById(R.id.p);
//        userGetMsg = findViewById(R.id.userGetMsg);
//        userSignup = findViewById(R.id.userSignup);
//        userMsgNum = findViewById(R.id.userMsgNum);
//        numTv = findViewById(R.id.numTv);
//        p.setVisibility(View.INVISIBLE);
//        userSignup.setVisibility(View.INVISIBLE);
//        numTv.setVisibility(View.INVISIBLE);
//        logo=findViewById(R.id.usermsgLogo);
//    }
//
//    private void initDataBase() {
//        helper=new MyDataBaseHelper(getApplicationContext(),"infos",null,1);
//        db=helper.getWritableDatabase();
//    }
////
////
////    Handler handler=new Handler()
////    {
////        @Override
////        public void handleMessage(Message msg) {
////            super.handleMessage(msg);
////            int event=msg.arg1;
////            int result=msg.arg2;
////            Object data=msg.obj;
////            if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
////                if(result == SMSSDK.RESULT_COMPLETE) {
////                    boolean smart = (Boolean)data;
////                    if(smart) {
////                        Toast.makeText(getApplicationContext(),"该手机号已经注册过，请重新输入",
////                                Toast.LENGTH_LONG).show();
////                        userMsgNum.requestFocus();
////                        return;
////                    }
////                }
////            }
////            if(result==SMSSDK.RESULT_COMPLETE)
////            {
////                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
////                    Toast.makeText(getApplicationContext(), "验证码输入正确",
////                            Toast.LENGTH_LONG).show();
////                    StuInfoHttpUtil util = new StuInfoHttpUtil(getApplicationContext());
////                    SharedPreferences sharedPreferences = userMsgActivity.this.getSharedPreferences("stu",MODE_PRIVATE);
////                    String stujson = sharedPreferences.getString("stujson",null);
////                    StudentInfo stuInfo = util.getStuInfo(stujson);
////                    //TODO sharedpreference读取之前字符串
////                    util.sendPhone(phone_number,stuInfo.getStuPassword(),stuInfo.getStuName());
////
////
//////                    EventBean eventBean=new EventBean();
//////                    //发布粘性事件
//////                    eventBean.setMsg(phone_number);
//////                    eventBean.setTag(6397);
//////                    eventBean.setWhat(6397);
//////                    EventBus.getDefault().postSticky(eventBean);
////
////
////                    ContentValues cv1=new ContentValues();
////                    cv1.put("stuDirectionId",stuInfo.getStuDirectionId());
////                    cv1.put("stuStuid",stuInfo.getStuId());
////                    cv1.put("stuPassword",stuInfo.getStuPassword());
////                    cv1.put("stuEmail",stuInfo.getStuEmail());
////                    cv1.put("stuTelephone",phone_number);
////                    cv1.put("stuStatus",stuInfo.getStuStatus());
////                    cv1.put("stuName",stuInfo.getStuName());
////                    cv1.put("stuClass",stuInfo.getStuClass());
////                    cv1.put("stuMajor",stuInfo.getStuMajor());
////                    cv1.put("stuImg",stuInfo.getStuImg());
////                    if(new StuInfoUtil().exist(stuInfo.getStuStuid(),db)){
////                        String whereClause = "stuStuId=?";
////                        String[] whereArgs={stuInfo.getStuStuid()};
////                        db.update("stuInfo",cv1,whereClause,whereArgs);
////                    }else{
////                        db.insert("stuInfo",null,cv1);
////                    }
////                    Log.e("lyq","手机号绑定成功");
////                    //页面跳转
////                    Intent in = new Intent(userMsgActivity.this,PersonalInfoActivity.class);
////                    startActivity(in);
////                    overridePendingTransition(R.anim.infromright, R.anim.outtoleft);
////
////
////
////
////                }
////            }
////            else
////            {
////                if(flag)
////                {
////                    userGetMsg.setVisibility(View.VISIBLE);
////                    tip=new QMUITipDialog.Builder(userMsgActivity.this).setIconType(3).setTipWord("验证码获取失败请重新获取").create();
////                    tip.show();
////                    new Thread(){
////                        @Override
////                        public void run() {
////                            try {
////                                sleep(2000);
////                                tip.dismiss();
////                            } catch (InterruptedException e) {
////                                e.printStackTrace();
////                            }
////                        }
////                    }.start();
////                    userMsgNum.requestFocus();
////                }
////                else
////                {
////                    tip=new QMUITipDialog.Builder(userMsgActivity.this).setIconType(3).setTipWord("验证码输入错误").create();
////                    tip.show();
////                    new Thread(){
////                        @Override
////                        public void run() {
////                            try {
////                                sleep(2000);
////                                tip.dismiss();
////                            } catch (InterruptedException e) {
////                                e.printStackTrace();
////                            }
////                        }
////                    }.start();
////                }
////            }
////        }
////
////    };
////
//
////
////    private boolean judCord()
////    {
////        if(TextUtils.isEmpty(p.getText().toString().trim()))
////        {
////            Toast.makeText(userMsgActivity.this,"请输入您的验证码",Toast.LENGTH_LONG).show();
////            p.requestFocus();
////            return false;
////        }
////        else if(p.getText().toString().trim().length()!=4)
////        {
////            Toast.makeText(userMsgActivity.this,"您的验证码位数不正确",Toast.LENGTH_LONG).show();
////            p.requestFocus();
////
////            return false;
////        }
////        else
////        {
////            cord_number=p.getText().toString().trim();
////            return true;
////        }
////
////    }
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_msg);
//        getView();
//        initDataBase();
//        QMUISwipeBackActivityManager.init(getApplication());
//        SharedPreferences sharedPreferences = getSharedPreferences("stu", MODE_PRIVATE);
//        String stuJson = sharedPreferences.getString("stujson", null);
//        if (null != stuJson) {
//            StudentInfo studentInfo = new StuInfoHttpUtil().getStuInfo(stuJson);
//            Glide.with(getApplicationContext()).load(studentInfo.getStuImg()).into(logo);
//        }
//
//        eventHandler = new EventHandler() {
//            public void afterEvent(int event, int result, Object data) {
//                Message msg = new Message();
//                msg.arg1 = event;
//                msg.arg2 = result;
//                msg.obj = data;
//                handler.sendMessage(msg);
//            }
//        };
//
//        p.setOnTextChangeListener(new PwdEditText.OnTextChangeListener() {
//            @Override
//            public void onTextChange(String pwd) {
//                if (pwd.length() == p.getTextLength()) {
//                    Toast.makeText(userMsgActivity.this, pwd, Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        userGetMsg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (judPhone())//去掉左右空格获取字符串
//                {
//                    //验证机制
//                    SMSSDK.getVerificationCode("86", userMsgNum.getText().toString().trim());
//                    //edit_cord.requestFocus();
//                    //动画效果
//                    numTv.setVisibility(View.INVISIBLE);
//                    ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(userGetMsg, "translationX", 0, -2000);
//                    ObjectAnimator scaleY2 = ObjectAnimator.ofFloat(userMsgNum, "translationX", 0, -2000);
//                    // 创建一个属性动画集合,
//                    AnimatorSet animSet1 = new AnimatorSet();
//                    animSet1.play(scaleY1).with(scaleY2);
//                    animSet1.setDuration(1100);
//                    animSet1.start();
//                    ObjectAnimator alpha4 = ObjectAnimator.ofFloat(p, "alpha", 0, 1);
//                    ObjectAnimator alpha3 = ObjectAnimator.ofFloat(userSignup, "alpha", 0, 1);
//                    AnimatorSet animSet3 = new AnimatorSet();
//                    animSet3.play(alpha3).with(alpha4);
//                    animSet3.setDuration(1300);
//                    animSet3.start();
//                    userSignup.setVisibility(View.VISIBLE);
//                    p.setVisibility(View.VISIBLE);
//                    numTv.setVisibility(View.INVISIBLE);
//                    numTv.setText(userMsgNum.getText().toString().trim());
//                }
//            }
//        });
//
//
//
//        userSignup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (judCord())
//                    Log.e("lyq ","hello");
//                SMSSDK.submitVerificationCode("86", userMsgNum.getText().toString().trim(), p.getText().toString().trim());
//                flag = false;
//            }
//        });
//    }
//
//
//
//
//
//
//    Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            int event = msg.arg1;
//            int result = msg.arg2;
//            Object data = msg.obj;
//            if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
//                if (result == SMSSDK.RESULT_COMPLETE) {
//                    boolean smart = (Boolean) data;
//                    if (smart) {
//                        Toast.makeText(getApplicationContext(), "该手机号已经注册过，请重新输入",
//                                Toast.LENGTH_LONG).show();
//                        userMsgNum.requestFocus();
//                        return;
//                    }
//                }
//            }
//            if (result == SMSSDK.RESULT_COMPLETE) {
//                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
//                    Toast.makeText(getApplicationContext(), "验证码输入正确",
//                            Toast.LENGTH_LONG).show();
//                    StuInfoHttpUtil util = new StuInfoHttpUtil(getApplicationContext());
//                    SharedPreferences sharedPreferences = userMsgActivity.this.getSharedPreferences("stu", MODE_PRIVATE);
//                    String stujson = sharedPreferences.getString("stujson", null);
//                    StudentInfo stuInfo = util.getStuInfo(stujson);
//                    //TODO sharedpreference读取之前字符串
//                    util.sendPhone(userMsgNum.getText().toString().trim(), stuInfo.getStuPassword(), "" + stuInfo.getStuStuid(), getApplicationContext());
//
//                    ContentValues cv1 = new ContentValues();
//                    cv1.put("stuDirectionId", stuInfo.getStuDirectionId());
//                    cv1.put("stuStuid", stuInfo.getStuId());
//                    cv1.put("stuPassword", stuInfo.getStuPassword());
//                    cv1.put("stuEmail", stuInfo.getStuEmail());
//                    cv1.put("stuTelephone", userMsgNum.getText().toString().trim());
//                    cv1.put("stuStatus", stuInfo.getStuStatus());
//                    cv1.put("stuName", stuInfo.getStuName());
//                    cv1.put("stuClass", stuInfo.getStuClass());
//                    cv1.put("stuMajor", stuInfo.getStuMajor());
//                    cv1.put("stuImg", stuInfo.getStuImg());
//                    if (new StuInfoUtil().exist(stuInfo.getStuStuid(), db)) {
//                        String whereClause = "stuStuId=?";
//                        String[] whereArgs = {stuInfo.getStuStuid()};
//                        db.update("stuInfo", cv1, whereClause, whereArgs);
//                    } else {
//                        db.insert("stuInfo", null, cv1);
//                    }
//                    Log.e("lyq", "手机号绑定成功");
//                    //页面跳转
//                    Intent in = new Intent(userMsgActivity.this, PersonalInfoActivity.class);
//                    startActivity(in);
//                    overridePendingTransition(R.anim.infromright, R.anim.outtoleft);
//
//                }
//            } else {
//                if (flag) {
//                    userGetMsg.setVisibility(View.VISIBLE);
//                    tip = new QMUITipDialog.Builder(userMsgActivity.this).setIconType(3).setTipWord("验证码获取失败请重新获取").create();
//                    tip.show();
//                    new Thread() {
//                        @Override
//                        public void run() {
//                            try {
//                                sleep(2000);
//                                tip.dismiss();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }.start();
//                    userMsgNum.requestFocus();
//                } else {
//                    tip = new QMUITipDialog.Builder(userMsgActivity.this).setIconType(3).setTipWord("验证码输入错误").create();
//                    tip.show();
//                    new Thread() {
//                        @Override
//                        public void run() {
//                            try {
//                                sleep(2000);
//                                tip.dismiss();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }.start();
//                }
//            }
//        }
//
//    };
//
//
//    private boolean judPhone() {
//        if (TextUtils.isEmpty(userMsgNum.getText().toString().trim())) {
//            Toast.makeText(userMsgActivity.this, "请输入您的电话号码", Toast.LENGTH_LONG).show();
//            userMsgNum.requestFocus();
//            return false;
//        } else if (userMsgNum.getText().toString().trim().length() != 11) {
//            Toast.makeText(userMsgActivity.this, "您的电话号码位数不正确", Toast.LENGTH_LONG).show();
//            userMsgNum.requestFocus();
//            return false;
//        } else {
//            phone_number = userMsgNum.getText().toString().trim();
//            return true;
//        }
//    }
//
//    private boolean judCord() {
//        if (TextUtils.isEmpty(p.getText().toString().trim())) {
//            Toast.makeText(userMsgActivity.this, "请输入您的验证码", Toast.LENGTH_LONG).show();
//            p.requestFocus();
//            return false;
//        } else if (p.getText().toString().trim().length() != 4) {
//            Toast.makeText(userMsgActivity.this, "您的验证码位数不正确", Toast.LENGTH_LONG).show();
//            p.requestFocus();
//
//            return false;
//        } else {
//            cord_number = p.getText().toString().trim();
//            return true;
//        }
//
//    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user_msg);
//        getView();
//        initDataBase();
//        QMUISwipeBackActivityManager.init(getApplication());
//        SharedPreferences sharedPreferences = getSharedPreferences("stu", MODE_PRIVATE);
//        String stuJson = sharedPreferences.getString("stujson", null);
//        if (null != stuJson) {
//            StudentInfo studentInfo = new StuInfoHttpUtil().getStuInfo(stuJson);
//            Glide.with(getApplicationContext()).load(studentInfo.getStuImg()).into(logo);
//        }


    //测试版本点击事件
//        userGetMsg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                    numTv.setVisibility(View.INVISIBLE);
//                    ObjectAnimator scaleY1 = ObjectAnimator.ofFloat(userGetMsg, "translationX", 0, -2000);
//                    ObjectAnimator scaleY2 = ObjectAnimator.ofFloat(userMsgNum, "translationX", 0, -2000);
//                    // 创建一个属性动画集合,
//                    AnimatorSet animSet1 = new AnimatorSet();
//                    animSet1.play(scaleY1).with(scaleY2);
//                    animSet1.setDuration(1100);
//                    animSet1.start();
//                    ObjectAnimator alpha4 = ObjectAnimator.ofFloat(p, "alpha", 0, 1);
//                    ObjectAnimator alpha3 = ObjectAnimator.ofFloat(userSignup, "alpha", 0, 1);
//                    AnimatorSet animSet3 = new AnimatorSet();
//                    animSet3.play(alpha3).with(alpha4);
//                    animSet3.setDuration(1300);
//                    animSet3.start();
//                    userSignup.setVisibility(View.VISIBLE);
//                    p.setVisibility(View.VISIBLE);
//                    numTv.setVisibility(View.INVISIBLE);
//                    numTv.setText(userMsgNum.getText().toString().trim());
//
//            }
//        });

//
////    测试版本的点击事件
//        userSignup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                StuInfoHttpUtil util = new StuInfoHttpUtil();
//                SharedPreferences sharedPreferences = userMsgActivity.this.getSharedPreferences("stu",MODE_PRIVATE);
//                String stujson = sharedPreferences.getString("stujson",null);
//                StudentInfo stuInfo = util.getStuInfo(stujson);
//                    //TODO sharedpreference读取之前字符串
//                util.sendPhone(userMsgNum.getText().toString().trim(),stuInfo.getStuPassword(),""+stuInfo.getStuStuid(),getApplicationContext());
//                ContentValues cv1=new ContentValues();
//                    cv1.put("stuDirectionId",stuInfo.getStuDirectionId());
//                    cv1.put("stuStuid",stuInfo.getStuId());
//                    cv1.put("stuPassword",stuInfo.getStuPassword());
//                    cv1.put("stuEmail",stuInfo.getStuEmail());
//                    cv1.put("stuTelephone",phone_number);
//                    cv1.put("stuStatus",stuInfo.getStuStatus());
//                    cv1.put("stuName",stuInfo.getStuName());
//                    cv1.put("stuClass",stuInfo.getStuClass());
//                    cv1.put("stuMajor",stuInfo.getStuMajor());
//                    cv1.put("stuImg",stuInfo.getStuImg());
//                    if(new StuInfoUtil().exist(stuInfo.getStuStuid(),db)){
//                        String whereClause = "stuStuId=?";
//                        String[] whereArgs={stuInfo.getStuStuid()};
//                        db.update("stuInfo",cv1,whereClause,whereArgs);
//                    }else{
//                        db.insert("stuInfo",null,cv1);
//                    }
//
//
//            }
//        });





}
