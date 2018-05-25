package com.com.utils;

/**
 * Created by Administrator on 2018\5\15 0015.
 */

public class Plans {
    public String name,starttime, endtime, info, goal, record;
    public int days;
    public int keepday;



    public Plans(String name,String starttime, String endtime, int keepday){
        this.name = name;
        this.starttime = starttime;
        this.endtime = endtime;
        this.keepday = keepday;
        this.days = days;
    }
    public String getStarttime() {
        return starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public String getInfo() {
        return info;
    }

    public String getGoal() {
        return goal;
    }

    public String getRecord() {
        return record;
    }

    public int getKeepday() {
        return keepday;
    }



    public String getName(){
        return name;
    }
    public int getDays(){
        return days;
    }
}
