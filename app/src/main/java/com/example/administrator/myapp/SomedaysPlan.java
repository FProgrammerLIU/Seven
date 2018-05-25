package com.example.administrator.myapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.com.utils.MyTimePickerDialog;
import com.table.InfoLongday;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class SomedaysPlan extends AppCompatActivity {
    private TextView textViewback, endTime, startTime, tvSave;
    private EditText edName,edGoal, edRecord;
    private MyTimePickerDialog myTimePickerDialog;
    private LinearLayout createStage;
    private Button button_create_stage;
    private String dayofmonthS, monthS;
    private InfoLongday infoLongday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_somedays_plan);
        textViewback = (TextView) findViewById(R.id.tv_back_longday);
        startTime = (TextView) findViewById(R.id.starttime_long);
        tvSave = (TextView) findViewById(R.id.tv_save_longday);
        edName = (EditText) findViewById(R.id.ed_longday_name);
        edGoal = (EditText) findViewById(R.id.ed_longday_goal);
        edRecord = (EditText) findViewById(R.id.ed_longday_record);

       // createStage = (LinearLayout) findViewById(R.id.create_stage);
        final LinearLayout longdayLayout = (LinearLayout) findViewById(R.id.longday_layout);
        endTime = (TextView) findViewById(R.id.endtime_long);
        button_create_stage = (Button) findViewById(R.id.button_create_stage);
        final View view4 = View.inflate(this, R.layout.create_stage, null);

        tvSave.setOnClickListener(new MyClickListener());
        button_create_stage.setOnClickListener(new MyClickListener(){
            public void onClick(View v){

                longdayLayout.addView(view4,0);
                longdayLayout.invalidate();
            }
        });
        textViewback.setOnClickListener(new MyClickListener());
        startTime.setOnClickListener(new MyClickListener());
        endTime.setOnClickListener(new MyClickListener());
        myTimePickerDialog = new MyTimePickerDialog(SomedaysPlan.this);
    }

    public class MyClickListener implements View.OnClickListener{
        public void onClick(View v){
            switch (v.getId()){
                case R.id.tv_back_longday:
                    textViewback.setTextColor(Color.WHITE);
                    finish();
                    break;
                case R.id.starttime_long:
                    showDataPickerDialog(SomedaysPlan.this, 3, startTime, new GregorianCalendar());

                    break;
                case R.id.endtime_long:
                    showDataPickerDialog(SomedaysPlan.this, 3, endTime, new GregorianCalendar());

                    break;
                case R.id.button_create_stage:
                    break;
                case R.id.tv_save_longday:
                    SaveLongdayThread thread = new SaveLongdayThread();
                    new Thread(thread).start();
                    break;
            }
        }

    }



    public void showDataPickerDialog(Activity activity, int themeResId, final TextView tv, Calendar calendar) {
        String[] array = ((String)tv.getText()).split("-");
        new DatePickerDialog(activity, themeResId, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                if (month <10){
                    monthS = "0"+String.valueOf(month);
                }
                if (dayOfMonth<10){
                    dayofmonthS = "0"+String.valueOf(dayOfMonth);
                }
                tv.setText(year +"-"+(monthS+1) + "-" + dayofmonthS);
            }
        }
                , Integer.parseInt(array[0])
                , Integer.parseInt(array[1])
                , Integer.parseInt(array[2])).show();
    }


    public class SaveLongdayThread implements Runnable{

        @Override
        public void run() {
            infoLongday = new InfoLongday(null, null, null, 0);
            infoLongday.setName(String.valueOf(edName.getText()));
            infoLongday.setStarttime(String.valueOf(startTime.getText()));
            infoLongday.setEndtime(String.valueOf(endTime.getText()));
            infoLongday.setGoal(String.valueOf(edGoal.getText()));
            infoLongday.setRecord(String.valueOf(edRecord.getText()));
            infoLongday.save();

            Intent intent = new Intent(SomedaysPlan.this, MainActivity.class);
            startActivity(intent);


        }
    }

}
