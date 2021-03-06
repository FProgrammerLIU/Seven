package com.table;

import com.chad.library.adapter.base.entity.SectionEntity;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2018\5\20 0020.
 */

public class InfoEveryday extends DataSupport{
    private int id;
    private String name;
    private String starttime;
    private String endtime;
    private String info;
    private String goal;
    private String record;
    private int keepday;

    public InfoEveryday(String name, String starttime,String endtime,int keepday){
            this.name = name ;
            this.starttime =starttime;
            this.endtime = endtime;
            this.keepday =keepday;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public int getKeepday() {
        return keepday;
    }

    public void setKeepday(int keepday) {
        this.keepday = keepday;
    }

}
