package com.example.myapplication;

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
public class Q1Fragment extends Fragment {
    private Button nextTestBtn; //下一步按鈕
    private RecyclerView recyclerView; //載入圖片按鈕
    public final String[] titles = new String[]{
            "美食",
            "風景",
            "文化古蹟",
            "購物中心",
            "藝文展覽",
    };
    public final int[] images = new int[]{
            R.drawable.kind_1,
            R.drawable.kind_2,
            R.drawable.kind_3,
            R.drawable.kind_4,
            R.drawable.kind_5
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_q1, container, false);
        nextTestBtn = mainView.findViewById(R.id.Q1_nextTest);
        nextTestBtn.setOnClickListener(goQ2Fragment);

        recyclerView = mainView.findViewById(R.id.attractionBtn_recycleView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        AttractionTypeAdapter adapter = new AttractionTypeAdapter(images, titles);
        recyclerView.setAdapter(adapter);

        return mainView;
    }

    private View.OnClickListener goQ2Fragment = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FavorMainActivity favorMainActivity = (FavorMainActivity)getActivity();
            favorMainActivity.showQ2Fragment();
        }
    };
}