package com.example.administrator.myapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.com.utils.MyTimePickerDialog;
import com.table.InfoEveryday;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class EverydayPlan extends AppCompatActivity {
private TextView textViewback, endTime, startTime, textViewSave;
private MyTimePickerDialog myTimePickerDialog;
private Context context;
private String minut, hour;
private InfoEveryday infoeveryday;
private EditText edEverydayName, edEverydayWork, edEverydayGoal, edEverydayRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everyday_plan);

        edEverydayName = (EditText) findViewById(R.id.ed_everyday_name);
        edEverydayWork = (EditText) findViewById(R.id.ed_everyday_work);
        edEverydayGoal = (EditText) findViewById(R.id.ed_everyday_goal);
        edEverydayRecord = (EditText) findViewById(R.id.ed_everyday_record);

        textViewback = (TextView) findViewById(R.id.textview_back_everyday);
       startTime = (TextView) findViewById(R.id.starttime);
        textViewSave = (TextView) findViewById(R.id.tv_planeveryday_save);
       endTime = (TextView) findViewById(R.id.endtime);
        textViewSave.setOnClickListener(new MyClickListener());
        textViewback.setOnClickListener(new MyClickListener());
        startTime.setOnClickListener(new MyClickListener());
        endTime.setOnClickListener(new MyClickListener());
        myTimePickerDialog = new MyTimePickerDialog(EverydayPlan.this);
        Log.d("CREATE", "CREATE");
    }

    public class MyClickListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.textview_back_everyday:
                    textViewback.setTextColor(Color.WHITE);
                    finish();
                    break;
                case R.id.starttime:
                    showTimePickerDialog(EverydayPlan.this, 3, startTime, new GregorianCalendar());
                    break;
                case R.id.endtime:
                    showTimePickerDialog(EverydayPlan.this, 3, endTime, new GregorianCalendar());
                    break;
                case R.id.tv_planeveryday_save:
                    SaveEverydayThread thread = new SaveEverydayThread();
                    new Thread(thread).start();
                    break;
            }
        }
    }


    public void showTimePickerDialog(Activity activity, int themeResId, final TextView tv, Calendar calendar) {
        String[] array = ((String)tv.getText()).split(":");
        new TimePickerDialog(activity, themeResId, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                if (minute <10){
                    minut = "0"+String.valueOf(minute);
                }
                if (hourOfDay <10){
                    hour = "0"+String.valueOf(hourOfDay);
                }
                tv.setText(hour +":" + minut);

            }
        }
                ,  Integer.parseInt(array[0])
                , Integer.parseInt(array[1])
        ,true).show();
    }


    public class SaveEverydayThread implements Runnable{


        @Override
        public void run() {
            infoeveryday = new InfoEveryday(null, null, null, 0);
            infoeveryday.setName(String.valueOf(edEverydayName.getText()));
            infoeveryday.setStarttime(String.valueOf(startTime.getText()));
            infoeveryday.setEndtime(String.valueOf(endTime.getText()));
            infoeveryday.setInfo(String.valueOf(edEverydayWork.getText()));
            infoeveryday.setGoal(String.valueOf(edEverydayGoal.getText()));
            infoeveryday.setRecord(String.valueOf(edEverydayRecord.getText()));
            infoeveryday.save();

            Intent intent = new Intent(EverydayPlan.this, MainActivity.class);
            startActivity(intent);



        }
    }










    }







