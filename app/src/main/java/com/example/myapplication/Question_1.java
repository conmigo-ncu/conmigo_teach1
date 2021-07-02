package com.example.myapplication;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
//import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
//import android.widget.ListAdapter;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Question_1 extends Fragment {

    private Button nextBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question_1, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.landscape);
        ListAdapter listAdapter = new ListAdapter() ;
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        ImageButton upper_page = v.findViewById(R.id.upperPage);
        upper_page.setOnClickListener(last_page);

        nextBtn = v.findViewById(R.id.Q1_nextBtn);
        nextBtn.setOnClickListener(goQ2);

        return v;
    }
    private View.OnClickListener last_page = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.hideQuestion1();
        }
    };

    private View.OnClickListener goQ2 = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();

        }
    };
}