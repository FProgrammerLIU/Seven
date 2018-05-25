package com.example.administrator.myapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adapters.FragmentAdapter;
import com.adapters.PlansAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.com.utils.Plans;
import com.table.InfoEveryday;
import com.table.InfoLongday;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018\5\15 0015.
 */

public class FragmentLeft extends Fragment {
    private List<InfoEveryday> plansList = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {


        View view = inflater.inflate(R.layout.fragmentleft, null);
        plansList.clear();
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<InfoEveryday> infoEverydays = DataSupport.findAll(InfoEveryday.class);
//        List<InfoLongday> infoLongdays = DataSupport.findAll(InfoLongday.class);

        for(InfoEveryday infoEveryday:infoEverydays){
            InfoEveryday infoEveryday1 = new InfoEveryday(infoEveryday.getName(), infoEveryday.getStarttime(),infoEveryday.getEndtime(), infoEveryday.getKeepday());
            plansList.add(infoEveryday1);
        }
//        for (InfoLongday infoLongday:infoLongdays){
//            InfoEveryday infoEveryday2 = new InfoEveryday(infoLongday.getName(), infoLongday.getStarttime(),infoLongday.getEndtime(), infoLongday.getKeepday());
//            plansList.add(infoEveryday2);
//        }




            RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
        TextView textView = (TextView) getActivity().findViewById(R.id.no_plans_text);
       if(plansList.isEmpty()){
            recyclerView.setVisibility(View.GONE);
           textView.setVisibility(View.VISIBLE);

       }else {
        recyclerView.setVisibility(View.VISIBLE);
        textView.setVisibility(View.GONE);

       }
       // recyclerView.setVisibility(View.VISIBLE);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        PlansAdapter adapter = new PlansAdapter(R.layout.plans_recycler_item,plansList);

        adapter.setOnItemClickListener(new MyItemClickListener());
        adapter.setOnItemLongClickListener(new MyItemCLonglickListener());
        recyclerView.setAdapter(adapter);

        adapter.openLoadAnimation();



    }

    public class MyItemClickListener implements BaseQuickAdapter.OnItemClickListener{

        @Override
        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            Intent intent = new Intent(getActivity(), PlanInfoEveryday.class);
                            intent.putExtra("position", String.valueOf(position+1));
                          getActivity().startActivity(intent);
        }
    }

    public class MyItemCLonglickListener implements BaseQuickAdapter.OnItemLongClickListener{

        @Override
        public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
            return false;


        }
    }

}
