package com.adapters;

import android.content.ClipData;
import android.content.Intent;
import android.hardware.camera2.CameraCaptureSession;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.com.utils.Plans;
import com.example.administrator.myapp.PlanInfoEveryday;
import com.example.administrator.myapp.R;
import com.table.InfoEveryday;

import java.util.List;

/**
 * Created by Administrator on 2018\5\15 0015.
 */

public class PlansAdapter extends BaseQuickAdapter<InfoEveryday, BaseViewHolder>  {
    private List<InfoEveryday> plansList;
  //  private ViewHolder holder;
    private PlanInfoEveryday planInfo;

    public PlansAdapter(int layoutResId, List<InfoEveryday> data){

        super(layoutResId, data);
        plansList = data;
    }

    protected void convert(BaseViewHolder holder, InfoEveryday item){

        int position = holder.getLayoutPosition();
        InfoEveryday infoEveryday =  plansList.get(position);

        Log.d("CREATE",String.valueOf(infoEveryday));

        Log.d("CREATE",String.valueOf(infoEveryday.getName()));

        holder.setText(R.id.planstext ,infoEveryday.getName());
        holder.setText(R.id.planscount, String.valueOf(infoEveryday.getKeepday()));
//        Log.d("CREATE",infoEveryday.getStarttime());

        holder.setText(R.id.planstime,infoEveryday.getStarttime()+"\n"+"———"+"\n"+infoEveryday.getEndtime());
    }












//    static class ViewHolder extends RecyclerView.ViewHolder {
//        View planView;
//        TextView textViewName, textViewCount, textViewTime;
//
//        public ViewHolder(View view) {
//            super(view);
//            planView = view;
//        //    imageView = (ImageView) view.findViewById(R.id.plansimage);
//            textViewTime = (TextView) view.findViewById(R.id.planstime) ;
//            textViewName = (TextView) view.findViewById(R.id.planstext);
//            textViewCount = (TextView) view.findViewById(R.id.planscount);
//
//        }
//
//    }
//
//    public PlansAdapter(List list) {
//        plansList = list;
//    }
//
//    public ViewHolder onCreateViewHolder(ViewGroup container, int viewType) {
//        //
//        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.plans_recycler_item, container, false);
//        final ViewHolder holder = new ViewHolder(view);
//
//        holder.planView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = holder.getAdapterPosition();
//                //Plans plan = plansList.get(position);
//                //    Toast.makeText(v.getContext(), plan.getName(), Toast.LENGTH_SHORT).show();
//                          Intent intent = new Intent(v.getContext(), PlanInfoEveryday.class);
//                            intent.putExtra("position", String.valueOf(position));
//                          holder.planView.getContext().startActivity(intent);
//
//
//
//            }
//        });
//
//        return holder;
//    }
//
//    public void onBindViewHolder(ViewHolder holder, int position) {
//
//         plans = plansList.get(position);
//       // Plans plans = plansList.get(position);
//        holder.textViewName.setText(plans.getName());
//        holder.textViewCount.setText(String.valueOf(plans.getKeepday()));
//        //Log.d("CREATE",plans.getStarttime());
//
//        holder.textViewTime.setText(plans.getStarttime()+"\n"+"———"+"\n"+plans.getEndtime());
//    }
//
//    public int getItemCount() {
//        return plansList.size();
//    }


}