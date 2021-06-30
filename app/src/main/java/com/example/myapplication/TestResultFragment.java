package com.example.myapplication;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class TestResultFragment extends Fragment {

    private Button confirmBtn;
    private Button retestBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_test_result, container, false);
        retestBtn = mainView.findViewById(R.id.TestResultReTestBtn);
        confirmBtn = mainView.findViewById(R.id.TestResultConfirmBtn);

        //retestBtn.setOnClickListener();
        confirmBtn.setOnClickListener(goBackMainActivity);
        return mainView;
    }

    private View.OnClickListener goBackMainActivity = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FavorMainActivity favorMainActivity = (FavorMainActivity)getActivity();
            favorMainActivity.finish();
        }
    };
}