package com.example.yata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    Fragment busFragment, subwayFragment, navFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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