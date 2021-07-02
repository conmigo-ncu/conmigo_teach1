package com.example.myapplication;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class TestResultFragment extends Fragment {

    private Button confirmBtn;
    private Button retestBtn;
    private TextView transportType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_test_result, container, false);
        retestBtn = mainView.findViewById(R.id.TestResultReTestBtn);
        confirmBtn = mainView.findViewById(R.id.TestResultConfirmBtn);

        transportType = mainView.findViewById(R.id.transport_type_result);


        // toolbar 設定
        Toolbar toolbar = mainView.findViewById(R.id.TravelTest_toolbar);
        MainActivity mainActivity = (MainActivity)getActivity();
        mainActivity.setSupportActionBar(toolbar);
        mainActivity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        mainActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.hideTestResult();
                mainActivity.showPersonalPage();
            }
        });

        retestBtn.setOnClickListener(goRetest);
        confirmBtn.setOnClickListener(goBackMainActivity);
        return mainView;
    }

    private View.OnClickListener goBackMainActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MainActivity mainActivity = (MainActivity)getActivity();
            mainActivity.hideTestResult();
            mainActivity.showPersonalPage();
        }
    };

    public View.OnClickListener goRetest = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            MainActivity mainActivity = (MainActivity)getActivity();
            mainActivity.hideTestResult();
            mainActivity.goQuestion1();
        }
    };
}