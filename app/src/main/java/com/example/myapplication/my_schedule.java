package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link my_schedule#newInstance} factory method to
 * create an instance of this fragment.
 */
public class my_schedule extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public my_schedule() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment my_schedule.
     */
    // TODO: Rename and change types and number of parameters
    public static my_schedule newInstance(String param1, String param2) {
        my_schedule fragment = new my_schedule();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_my_schedule);
    }

    private void setContentView(int fragment_my_schedule) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setContentView(R.layout.fragment_my_schedule);
        View v = inflater.inflate(R.layout.fragment_my_schedule, container, false);

        //spinner 設定
        String [] sort_way =
                {"依創建時間排序", "依地區排序", "依標籤排序", };
        Spinner spn = (Spinner) v.findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),R.layout.selected_layout, sort_way);
        adapter.setDropDownViewResource(R.layout.dropdown_layout);
        spn.setAdapter(adapter);

        //fab按鈕
        FloatingActionButton add_sch = v.findViewById(R.id.new_sch);
        add_sch.setOnClickListener(btnToAdd);

        /*ImageButton home = v.findViewById(R.id.home_page);
        home.setOnClickListener(back_to_home);
        ImageButton user = v.findViewById(R.id.user_page);
        user.setOnClickListener(toUser);  */

        return v;
    }
    private View.OnClickListener btnToAdd = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.showAddSchedule();
        }
    };
   /* private  View.OnClickListener back_to_home = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.hideMySchedule();
        }
    };
    private  View.OnClickListener toUser = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.showPersonalPage();
        }
    };  */
}