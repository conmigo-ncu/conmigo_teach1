package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
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
public class ToolsBarFragment extends Fragment {

    private View mainView;
    private ImageButton abovePage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_tools_bar, container, false);
        abovePage = mainView.findViewById(R.id.abovePage);
        abovePage.setOnClickListener(goBackLastPage);
        return mainView;
    }

    private View.OnClickListener goBackLastPage = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FavorMainActivity favorMainActivity = new FavorMainActivity();
        }
    };
}