package com.example.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Q2Fragment extends Fragment {

    private View mainView;
    private Button drive;
    private Button pb_transport;
    private Button send;
    Bundle bundle = new Bundle();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView =  inflater.inflate(R.layout.fragment_q2, container, false);

        Toolbar toolbar = mainView.findViewById(R.id.TravelTest_toolbar);
        MainActivity mainActivity = (MainActivity)getActivity();
        mainActivity.setSupportActionBar(toolbar);
        mainActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        mainActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.hideQuestion2();
                mainActivity.goQuestion1();
            }
        });

        drive = mainView.findViewById(R.id.drive);
        drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectButton(v);
            }
        });

        pb_transport = mainView.findViewById(R.id.pb_transport);
        pb_transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectButton(v);
            }
        });

        send = mainView.findViewById(R.id.send);
        send.setEnabled(false);
        send.setOnClickListener(goResultTestFragement);
        return mainView;
    }

    public void selectButton(View v){
        int WHITE = getResources().getColor(R.color.theme_white);
        int GREEN = getResources().getColor(R.color.theme_green);

        if(v.getId()==R.id.drive){
            drive.setSelected(true);
            drive.setTextColor(WHITE);
            pb_transport.setTextColor(GREEN);
            pb_transport.setSelected(false);
            //bundle.putString("transport_type", drive.getText().toString());
            //Toast.makeText(v.getContext(), drive.getText(), Toast.LENGTH_LONG).show();
        }
        else if(v.getId()==R.id.pb_transport){
            pb_transport.setSelected(true);
            drive.setTextColor(GREEN);
            pb_transport.setTextColor(WHITE);
            drive.setSelected(false);
            //bundle.putString("transport_type", pb_transport.getText().toString());
            //Toast.makeText(v.getContext(), pb_transport.getText(), Toast.LENGTH_LONG).show();
        }

        send.setEnabled(true);
    }

    private View.OnClickListener goResultTestFragement = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            MainActivity mainActivity = (MainActivity) getActivity();
            mainActivity.hideQuestion2();
            mainActivity.goTestResult();
        }
    };
}