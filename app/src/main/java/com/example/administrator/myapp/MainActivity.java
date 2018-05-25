package com.example.administrator.myapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adapters.FragmentAdapter;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceManager;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.nightonke.boommenu.Util;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private ImageView imageViewInfo, imageViewFriend, imageCircleInfo, imageViewSort;
private ViewPager viewPagermain;
private List<Fragment> list;
private FragmentAdapter fragmentAdapter;
private Intent intent;
private DrawerLayout drawerLayout;
private NavigationView navigationView;
private View headerView;
private LinearLayout linearLayoutinfo;
private BottomNavigationBar bottomNavigationBar;
private BoomMenuButton boomMenuButton;
private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LitePal.getDatabase();

      //ActionBar
//        ActionBar actionBar = getSupportActionBar();
//        assert actionBar != null;
//        actionBar.setDisplayShowHomeEnabled(false);
//        actionBar.setDisplayShowTitleEnabled(false);
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View actionB = inflater.inflate(R.layout.actionbar_create , null);
//        actionBar.setCustomView(actionB);
//        actionBar.setDisplayShowCustomEnabled(true);
//        ((Toolbar) actionB.getParent()).setContentInsetsAbsolute(0,0);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        boomMenuButton = (BoomMenuButton) findViewById(R.id.create_boommenubar) ;
        imageViewSort = (ImageView) findViewById(R.id.imageview_sort);
        imageViewFriend = (ImageView) findViewById(R.id.imageview_friend);
       imageViewInfo = (ImageView) findViewById(R.id.image_circle_small);
        viewPagermain =  (ViewPager) findViewById(R.id.viewpagermain);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar_container);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        headerView = navigationView.inflateHeaderView(R.layout.nav_header);
        linearLayoutinfo = (LinearLayout) headerView.findViewById(R.id.info_layout);
        imageCircleInfo = (ImageView) headerView.findViewById(R.id.image_circle);


        navigationView.setNavigationItemSelectedListener(new MyNavigationItemSelectedListener());
        imageViewInfo.setOnClickListener(new MyClickListener());
        imageCircleInfo.setOnClickListener(new MyClickListener());
        linearLayoutinfo.setOnClickListener(new MyClickListener());
        imageViewFriend.setOnClickListener(new MyClickListener());
        imageViewSort.setOnClickListener(new MyClickListener());
        viewPagermain.addOnPageChangeListener(new MyPageChangeListener());
        list = new ArrayList<>();
        list.add(new FragmentLeft());
        list.add(new FragmentMid());
        list.add(new FragmentRight());

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), list);
        viewPagermain.setAdapter(fragmentAdapter);
        viewPagermain.setCurrentItem(0);

        Log.d("CREATE","create");
// 底部导航
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_menu_paste_holo_light, "计划").setActiveColorResource(R.color.main))
                .addItem(new BottomNavigationItem(R.drawable.ic_menu_home, "广场").setActiveColorResource(R.color.main))
                .addItem(new BottomNavigationItem(R.drawable.friend_small, "消息").setActiveColorResource(R.color.main))
                .setFirstSelectedPosition(0)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(new TabSelectedListener());


//ActionBar BoomMenu
        Log.d("CREATE","create");



        boomMenuButton.setButtonEnum(ButtonEnum.Ham);
        boomMenuButton.setPiecePlaceEnum(PiecePlaceEnum.HAM_3);
        boomMenuButton.setButtonPlaceEnum(ButtonPlaceEnum.HAM_3);
        boomMenuButton.setRippleEffect(false);
       for(int i = 0; i < boomMenuButton.getPiecePlaceEnum().pieceNumber(); i++){

           HamButton.Builder builder = new HamButton.Builder();
            if(i==0) {
                builder.normalTextRes(R.string.plan_everyday);
          //      builder.textGravity(Gravity.CENTER);
                builder.textSize(20);
                boomMenuButton.addBuilder(builder);

            }
           if(i==1) {
               builder.normalTextRes(R.string.plan_days);
               builder.textGravity(Gravity.CENTER);
               builder.textSize(20);

               boomMenuButton.addBuilder(builder);
           }
           if(i==2) {
               builder.normalTextRes(R.string.plan_yourself);

               builder.textSize(20);
               boomMenuButton.addBuilder(builder);
           }
           builder.listener(new OnBMClickListener() {
               @Override
               public void onBoomButtonClick(int index) {
                    switch (index){
                        case 0:
                            Intent intent = new Intent(MainActivity.this, EverydayPlan.class );
                            startActivity(intent);
                            break;
                        case 1:
                            Intent intent1 = new Intent(MainActivity.this, SomedaysPlan.class );
                            startActivity(intent1);
                            break;
                        case 2:
                            break;
                    }
               }
           });
       }


    }



    public class MyClickListener implements View.OnClickListener{
        public void onClick(View v){
            switch (v.getId()){

                case R.id.image_circle_small:

                        drawerLayout.openDrawer(GravityCompat.START);


                    break;
           //     case R.id.imageviewcreate:
                    //choice type (menubar)

        //            break;
                case R.id.image_circle:
                    Intent intent = new Intent(MainActivity.this, SignIn.class);
                    startActivity(intent);
                    break;
                case R.id.info_layout:
                    Intent intent1 = new Intent(MainActivity.this, MyInfoActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.imageview_sort:
                    break;
                case R.id.imageview_friend:
                    break;
            }
        }
    }

    public class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        public void onPageSelected(int position){

            bottomNavigationBar.selectTab(position);

        }
        public void onPageScrolled(int arg0, float arg1, int arg2){

        }
        public void onPageScrollStateChanged(int arg0){

        }
    }


    public class MyNavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {
        public boolean onNavigationItemSelected(MenuItem item){
            switch (item.getItemId()) {
                case R.id.my_plans_finish:
                    Intent intent = new Intent(MainActivity.this, MyPlansFinished.class);
                    startActivity(intent);


                    break;
                case R.id.my_plans_failed:
                    Intent intent1 = new Intent(MainActivity.this, MyPlansFailed.class);
                    startActivity(intent1);

                    break;
                case R.id.collect_menu:
                    break;
                case R.id.color:
                    break;
                case  R.id.setting:
                    break;
            }
            return true;

        }
    }


    public class TabSelectedListener implements BottomNavigationBar.OnTabSelectedListener{
        @Override
        public void onTabUnselected(int position) {

        }

        @Override
        public void onTabSelected(int position) {
            if (position == 0){
                boomMenuButton.setVisibility(View.VISIBLE);
                imageViewFriend.setVisibility(View.GONE);
                imageViewSort.setVisibility(View.GONE);
            }
                    if(position == 1){
                imageViewSort.setVisibility(View.VISIBLE);
                        boomMenuButton.setVisibility(View.GONE);
                        imageViewFriend.setVisibility(View.GONE);
                    }
                    if(position == 2){
                        imageViewFriend.setVisibility(View.VISIBLE);
                        imageViewSort.setVisibility(View.GONE);
                        boomMenuButton.setVisibility(View.GONE);
                    }
                    viewPagermain.setCurrentItem(position);


        }

        @Override
        public void onTabReselected(int position) {

        }
    }


}
