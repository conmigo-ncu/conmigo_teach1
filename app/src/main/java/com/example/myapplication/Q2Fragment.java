package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Q2Fragment extends Fragment {

    private View mainView;
    private Button drive;
    private Button pb_transport;
    private Button send;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView =  inflater.inflate(R.layout.fragment_q2, container, false);
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
        }
        else if(v.getId()==R.id.pb_transport){
            pb_transport.setSelected(true);
            drive.setTextColor(GREEN);
            pb_transport.setTextColor(WHITE);
            drive.setSelected(false);
        }
    }

    private View.OnClickListener goResultTestFragement = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FavorMainActivity favorMainActivity = (FavorMainActivity) getActivity();
            favorMainActivity.hideQ2fragment();
            favorMainActivity.showTestResultFragement();
        }
    };
}