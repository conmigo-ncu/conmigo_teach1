package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
    Fragment fragment = null;
    private Conmigo_exe home;
    private my_schedule schedule_page;
    private add_schedule add_sch;
    private personal_info user;
    private Question_1 q1;
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
        q1 = new Question_1();

        BottomNavigationView nav = findViewById(R.id.nav_buttons);
        nav.setOnNavigationItemSelectedListener(nav_change);

        nav.getMenu().findItem(R.id.nav_home).setChecked(true);

        //FragmentManager fragmentManager = getFragmentManager();


        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, home, "Home")
                .add(R.id.frame, schedule_page, "My Schedule")
                .add(R.id.frame, add_sch, "Add Schedule")
                .add(R.id.frame, user, "Personal Page")
                .add(R.id.frame, q1, "Question 1")
                .hide(schedule_page)
                .hide(add_sch)
                .hide(user)
                .hide(q1)
                .commit();




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
    public BottomNavigationView.OnNavigationItemSelectedListener nav_change = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            fragment = null;
            switch (menuItem.getItemId()){
                case R.id.nav_home:
                    showHome();
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frame, home).commit();
                    return true;
                    //break;
                case R.id.nav_myTrip:
                    //fragment = new Conmigo_exe();
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frame, schedule_page).commit();
                    showMySchedule();
                    //showAddSchedule();
                    return true;
                    //break;
                case R.id.nav_user:
                    showPersonalPage();
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frame, user).commit();
                    return true;
                    //break;
            }
            /*getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment)

                    .add(R.id.frame, q1, "Question 1")
                    .add(R.id.frame, add_sch, "Add Schedule")
                    .add(R.id.frame, user, "Personal Page")
                    .add(R.id.frame, schedule_page, "My Schedule")
                    .add(R.id.frame, user, "Personal Page")
                    .hide(q1)
                    .hide(schedule_page)
                    .hide(add_sch)
                    .hide(user)
                    .commit();   */

            return false;
        }
    };

    public void showHome(){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, home)
                //.setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)
                //.show(home)
                .commit();

    }
    public void showMySchedule(){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, schedule_page)
                //.setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)
                //.show(schedule_page)
                .commit();
        //showAddSchedule();

    }
    public void hideMySchedule(){
        getSupportFragmentManager().beginTransaction()
                .hide(schedule_page)
                .commit();

    }
   /* public void showMySchedule_bottom(){
        getSupportFragmentManager().beginTransaction()
                //.setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)
                .show(schedule_page)
                .commit();
    }  */
    public void showAddSchedule(){
        //if(fragment.isAdded()){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, add_sch)
                    .setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)
                    //.show(add_sch)
                    .commit();
        //}
        /*else{
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)
                    .show(add_sch)
                    .commit();
        }*/
        /*getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)
                .show(add_sch)
                .commit();  */
    }
    public void showPersonalPage(){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, user)
                //.setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)
                .show(user)
                .commit();
    }
    public void showQuestion_1(){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, q1)
                //.setCustomAnimations(R.anim.trans_in_from_right, R.anim.no_anim)
                //.show(q1)
                .commit();
    }

    public void hideAddSchedule(){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.no_anim, R.anim.trans_out_to_right)
                .replace(R.id.frame, schedule_page)
                //.hide(add_sch)
                .commit();
    }
    public void hideHome(){
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.no_anim, R.anim.trans_out_to_right)
                .hide(home)
                .commit();
    }
    public void hidePersonalPage(){
        getSupportFragmentManager().beginTransaction()
                //.setCustomAnimations(R.anim.no_anim, R.anim.trans_out_to_right)
                .hide(user)
                .commit();
    }
    public void hideQuestion_1(){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,user)
                //.setCustomAnimations(R.anim.no_anim, R.anim.trans_out_to_right)
                .hide(q1)
                .commit();
    }
}