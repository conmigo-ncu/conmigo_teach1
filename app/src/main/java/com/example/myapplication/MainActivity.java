package com.example.myapplication;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //切換頁面物件
    private Conmigo_exe home;
    private my_schedule schedule_page;
    private add_schedule add_sch;
    private personal_info user;
    private Question_1 q1;

    private Q1Fragment q1Fragment;
    private Q2Fragment q2Fragment;;
    private TestResultFragment testResultFragment;

    //spinner物件
    private  Spinner spn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home = new Conmigo_exe();
        schedule_page = new my_schedule();
        add_sch = new add_schedule();
        user = new personal_info();
//        q1 = new Question_1();
        //personal info Test
        q1Fragment = new Q1Fragment();
        q2Fragment = new Q2Fragment();
        testResultFragment = new TestResultFragment();
        //FragmentManager fragmentManager = getFragmentManager();


        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, home, "Home")
                .add(R.id.frame, schedule_page, "My Schedule")
                .add(R.id.frame, add_sch, "Add Schedule")
                .add(R.id.frame, user, "Personal Page")
                .add(R.id.frame, q1Fragment, "Question 1")
                .add(R.id.frame, q2Fragment, "Question 2")
                .add(R.id.frame, testResultFragment, "TestResult")
                .hide(schedule_page)
                .hide(add_sch)
                .hide(user)
                .hide(q1Fragment)
                .hide(q2Fragment)
                .hide(testResultFragment)
                .commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigate);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        //spinner
        /*spn = findViewById(R.id.spinner1);

        List<String> sort_way = new ArrayList<>();
        sort_way.add(0,"依創建時間排序");
        sort_way.add("依地區排序");
        sort_way.add("依標籤排序");

        ArrayAdapter<String> selected;
        selected = new ArrayAdapter(this, R.layout.selected_layout,sort_way);
        selected.setDropDownViewResource(R.layout.dropdown_layout );

        spn.setAdapter(selected);  */
    }

    public void showAddSchedule(){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)
                .show(add_sch)
                .commit();
    }

    /**************************************************
     * 下方 menu跳轉 Fragment 方法
     **************************************************/
    public void showMySchedule(){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)
                .show(schedule_page)
                .commit();
    }
    public void showMySchedule_bottom(){
        getSupportFragmentManager().beginTransaction()
                //.setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)
                .show(schedule_page)
                .commit();
    }

    public void showPersonalPage(){
        getSupportFragmentManager().beginTransaction()
                //.setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)
                .show(user)
                .commit();
    }

    public void hideMySchedule(){
        getSupportFragmentManager().beginTransaction()
                //.setCustomAnimations(R.anim.no_anim, R.anim.trans_out_to_right)
                .hide(schedule_page)
                .commit();
    }
    public void hideAddSchedule(){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.no_anim, R.anim.trans_out_to_right)
                .hide(add_sch)
                .commit();
    }

    public void hidePersonalPage(){
        getSupportFragmentManager().beginTransaction()
                //.setCustomAnimations(R.anim.no_anim, R.anim.trans_out_to_right)
                .hide(user)
                .commit();
    }

    public void showHomeFragement(){
        getSupportFragmentManager().beginTransaction()
                .show(home)
                .commit();
    }

    public void hideHomeFragement(){
        getSupportFragmentManager().beginTransaction()
                .hide(home)
                .commit();
    }

    /*************************************************************
     * 個人測驗 Fragement
     *************************************************************/
    public void goQuestion1(){
        getSupportFragmentManager().beginTransaction()
                .show(q1Fragment)
                .commit();
    }

    public void hideQuestion1(){
        getSupportFragmentManager().beginTransaction()
                //.setCustomAnimations(R.anim.no_anim, R.anim.trans_out_to_right)
                .hide(q1Fragment)
                .commit();
    }

    public void goQuestion2(){
        getSupportFragmentManager().beginTransaction()
                .show(q2Fragment)
                .commit();
    }

    public void hideQuestion2(){
        getSupportFragmentManager().beginTransaction()
                .hide(q2Fragment)
                .commit();
    }

    public void goTestResult(){
        getSupportFragmentManager().beginTransaction()
                .show(testResultFragment)
                .commit();
    }

    public void hideTestResult(){
        getSupportFragmentManager().beginTransaction()
                .hide(testResultFragment)
                .commit();
    }

    /*************************************************
     * 建立下方 menu的listener
     *************************************************/
    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            hideQuestion1();
            switch (menuItem.getItemId()){

                case R.id.schedule_menuitem:
                    showMySchedule();
                    return true;
                case R.id.recommand_menuitem:
                    showHomeFragement();
                    return true;
                case R.id.home_menuitem:
                    showHomeFragement();
                    return true;
                case R.id.search_menuitem:
                    showHomeFragement();
                    return true;
                case R.id.user_menuitem:
                    showPersonalPage();
                    return true;
            }
            return false;
        }
    };
}