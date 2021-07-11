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
import android.widget.ImageButton;
//import android.widget.ListAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Question_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question_1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Question_1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Question_1.
     */
    // TODO: Rename and change types and number of parameters
    public static Question_1 newInstance(String param1, String param2) {
        Question_1 fragment = new Question_1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

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

        return v;
    }
    private View.OnClickListener last_page = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity activity = (MainActivity) getActivity();
            activity.hideQuestion_1();
        }
    };

}