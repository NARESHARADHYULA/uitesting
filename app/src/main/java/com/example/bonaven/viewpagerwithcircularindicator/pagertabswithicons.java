package com.example.bonaven.viewpagerwithcircularindicator;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;

public class pagertabswithicons extends AppCompatActivity implements MaterialTabListener {
    MaterialTabHost tabHost;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagertabswithicons);
        getSupportActionBar().hide();
        viewPager = (ViewPager) findViewById(R.id.pagerfortabs);
        myadapter viewpageadapter=new myadapter(getSupportFragmentManager());
        viewPager.setAdapter(viewpageadapter);
        //Bind the title indicator to the adapter
        tabHost   = (MaterialTabHost) this.findViewById(R.id.materialTabHost);
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                tabHost.setSelectedNavigationItem(position);
                if(position==2){
                    Intent intent= new Intent(getApplicationContext(),slidingpageviewer.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        // insert all tabs from pagerAdapter data
        for (int i = 0; i < viewpageadapter.getCount(); i++) {
            tabHost.addTab(
                    tabHost.newTab()
                            .setIcon(getIcon(i))
                            .setTabListener(this)
            );
        }


    }
    public Drawable getIcon(int i){
        if (i==1) return getResources().getDrawable(R.drawable.notification);
        else  if(i==2)  return getResources().getDrawable(R.drawable.ic_people_outline_black_24dp);
        else return getResources().getDrawable(R.drawable.ic_arrow_forward_white_24dp);
    }
    @Override
    public void onTabSelected(MaterialTab tab) {
        int position =tab.getPosition();
        viewPager.setCurrentItem(position);
        tabHost.setSelectedNavigationItem(position);
    }

    @Override
    public void onTabReselected(MaterialTab tab) {

    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }
    public  class myadapter extends FragmentPagerAdapter {
        public myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            if(position==0){
                return "BlankFragment";
            }
            else if(position==1){
                return  "BlankFragment1()";
            }
            else{
                return "BlankFragment2()";
            }
        }

        @Override
        public Fragment getItem(int position) {

            if(position==0){
                return new BlankFragment();
            }
            else if(position==1){
                return new BlankFragment1();
            }
            else{
                return new BlankFragment2();
            }

        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
