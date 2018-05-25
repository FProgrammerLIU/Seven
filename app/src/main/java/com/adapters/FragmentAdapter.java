package com.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018\5\15 0015.
 */

public class FragmentAdapter extends FragmentPagerAdapter{
    private List<Fragment> mlist;
    private FragmentManager mfragmentManager;
    public FragmentAdapter(FragmentManager fragmentManager, List<Fragment> list){
        super(fragmentManager);
        this.mlist = list;
    }
        public Fragment getItem(int arg0){
            return mlist.get(arg0);//show which page
        }
        public int getCount(){
            return mlist.size();//page count
        }

}
