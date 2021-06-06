package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Conmigo_exe#//newInstance} factory method to
 * create an instance of this fragment.
 */
public class Conmigo_exe extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;

    public Conmigo_exe() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     //* @param param1 Parameter 1.
    // * @param param2 Parameter 2.
     * @return A new instance of fragment Conmigo_exe.
     */
    // TODO: Rename and change types and number of parameters
    /*public static Conmigo_exe newInstance(String param1, String param2) {
        Conmigo_exe fragment = new Conmigo_exe();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (getArguments() != null) {
           // mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
       // }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.conmigo_home, container, false);

        Button mySchedule = v.findViewById(R.id.my_schedule);
        ImageButton mySchedule_bottom = v.findViewById(R.id.schedule);
        ImageButton user_bottom = v.findViewById(R.id.user_page);
        mySchedule.setOnClickListener(btnToMySchedule);
        mySchedule_bottom.setOnClickListener(btnToMySchedule_bottom);
        user_bottom.setOnClickListener(btnToUser_bottom);

        return v;
    }
    private  View.OnClickListener btnToMySchedule = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.showMySchedule();
        }
    };
    private  View.OnClickListener btnToMySchedule_bottom = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.showMySchedule_bottom();
        }
    };
    private  View.OnClickListener btnToUser_bottom = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.showPersonalPage();
        }
    };
}