package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class personal_info extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_personal_info, container, false);


        ImageButton mySchedule_bottom = v.findViewById(R.id.schedule);
        mySchedule_bottom.setOnClickListener(btnToMySchedule_bottom);
        ImageButton home_bottom = v.findViewById(R.id.home_page);
        home_bottom.setOnClickListener(btnToHome_bottom);
        Button quiz = v.findViewById(R.id.questions);
        quiz.setOnClickListener(toQuiz);

        return v;
    }
    private  View.OnClickListener btnToMySchedule_bottom = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.hidePersonalPage();
            activity.showMySchedule_bottom();
        }
    };
    private  View.OnClickListener btnToHome_bottom = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.hidePersonalPage();
            activity.hideMySchedule();

        }
    };
    private View.OnClickListener toQuiz = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.hidePersonalPage();
            activity.goQuestion1();
        }
    };
}