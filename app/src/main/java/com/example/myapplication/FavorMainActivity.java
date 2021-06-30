package com.example.myapplication;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FavorMainActivity extends AppCompatActivity {

    private FragmentManager fmgr;
    private ToolsBarFragment toolsBarFragment;
    private FunctionBarFragment funcBarFragment;
    private Q1Fragment q1Fragment;
    private Q2Fragment q2Fragment;
    private TestResultFragment testResultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_favor_main);
        fmgr = getSupportFragmentManager();
        toolsBarFragment = new ToolsBarFragment();
        q1Fragment = new Q1Fragment();
        q2Fragment = new Q2Fragment();
        funcBarFragment = new FunctionBarFragment();
        testResultFragment = new TestResultFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.funcbar, funcBarFragment, "funcBar")
                .add(R.id.titlebar, toolsBarFragment, "titleBar")
                .add(R.id.Qcontainer, q1Fragment, "q1Fragment")
                .add(R.id.Qcontainer, q2Fragment, "q2Fragment")
                .add(R.id.Qcontainer, testResultFragment, "testResult")
                .hide(q2Fragment)
                .hide(testResultFragment)
                .commit();
    }

    public void showQ2Fragment(){
        getSupportFragmentManager().beginTransaction()
                .show(q2Fragment)
                .commit();
    }

    public void hideQ2fragment(){
        getSupportFragmentManager().beginTransaction()
                .hide(q2Fragment)
                .commit();
    }

    public void showTestResultFragement(){
        getSupportFragmentManager().beginTransaction()
                .show(testResultFragment)
                .commit();
    }

    public void hideQ1fragement(){
        getSupportFragmentManager().beginTransaction()
                .show(q1Fragment)
                .commit();
    }

}