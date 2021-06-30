package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FunctionBarFragment extends Fragment {

    private ImageButton mySchedualButton;
    private ImageButton homeButton;
    private ImageButton recomandButton;
    private ImageButton searchButton;
    private ImageButton userButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainview =  inflater.inflate(R.layout.fragment_function_bar, container, false);
        mySchedualButton = mainview.findViewById(R.id.schedule);
        recomandButton = mainview.findViewById(R.id.rcmd);
        homeButton = mainview.findViewById(R.id.home_page);
        searchButton = mainview.findViewById(R.id.exam);
        userButton = mainview.findViewById(R.id.user_page);

        //go to my trip list
        mySchedualButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(getActivity(), MainActivity.class);
                startActivity(it);
            }
        });

        //go to recomand page
        recomandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //go to home page
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //go to search page
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return mainview;
    }
}