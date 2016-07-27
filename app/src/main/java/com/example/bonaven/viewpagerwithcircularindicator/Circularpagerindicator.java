package com.example.bonaven.viewpagerwithcircularindicator;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;

import me.relex.circleindicator.CircleIndicator;

public class Circularpagerindicator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circularpagerindicator);
        getSupportActionBar().hide();
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new myadapter(getSupportFragmentManager()));

        //Bind the title indicator to the adapter
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);


    }
    public void skip(View view){
        Intent intent= new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
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

