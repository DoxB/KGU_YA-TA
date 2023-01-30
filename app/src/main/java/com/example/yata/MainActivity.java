package com.example.yata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    Fragment busFragment, subwayFragment, navFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      DrawerLayout(슬라이드 메뉴바) 객체 생성
        DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer);
//      이미지 뷰 객체 생성해서 id로 이벤트 처리
        ImageView imageView = (ImageView)findViewById(R.id.iv_menu);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!drawer.isDrawerOpen(Gravity.LEFT)){
                    drawer.openDrawer(Gravity.LEFT);
                }
                if(drawer.isDrawerOpen(Gravity.LEFT)){
                    drawer.closeDrawers();
                }
            }
        });


        busFragment = new BusFragment();
        subwayFragment = new SubwayFragment();
        navFragment = new NavFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.mainFrame, busFragment).commit();
        TabLayout tabs = (TabLayout) findViewById(R.id.tabLayout);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                int position = tab.getPosition();

                Fragment selected = null;
                if(position == 0){

                    selected = busFragment;

                }else if (position == 1){

                    selected = subwayFragment;

                }else if (position == 2){

                    selected = navFragment;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}