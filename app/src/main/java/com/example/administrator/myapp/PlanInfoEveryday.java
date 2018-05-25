package com.example.administrator.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.com.utils.Plans;
import com.table.InfoEveryday;

import org.litepal.crud.DataSupport;

import java.util.List;

public class PlanInfoEveryday extends AppCompatActivity {

    public TextView everydayName, everydayTime, everydayWork, everydayGoal, everydayRecord ,tvback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_info_everyday);
        Intent intent = getIntent();
        String position = intent.getStringExtra("position");
        everydayName = (TextView) findViewById(R.id.tv_plan_name);
        everydayTime = (TextView) findViewById(R.id.tv_plan_time);
        everydayWork = (TextView) findViewById(R.id.tv_plan_info);
        everydayGoal = (TextView) findViewById(R.id.tv_plan_goal);
        everydayRecord = (TextView) findViewById(R.id.tv_plan_record);
        tvback = (TextView) findViewById(R.id.pie_back);
        tvback.setOnClickListener(new MyClickListener());
      //  everydayName.setText(position);

        List<InfoEveryday> infoEverydays = DataSupport.where("id = ?", position ).find(InfoEveryday.class);
        for(InfoEveryday infoEveryday:infoEverydays){
            everydayName.setText(infoEveryday.getName());
            everydayTime.setText(infoEveryday.getStarttime()+"\n"+infoEveryday.getEndtime());
            everydayWork.setText(infoEveryday.getInfo());
            everydayGoal.setText(infoEveryday.getGoal());
            everydayRecord.setText(infoEveryday.getRecord());
        }

    }

    public class MyClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.pie_back:
                    finish();
                    break;
            }
        }
    }

}
