package com.example.myapplication;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AttractionTypeAdapter extends RecyclerView.Adapter<AttractionTypeAdapter.ViewHolder> {

    private int[] attractionImagesList;
    private String[] attractionTypesList;


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView; // 設定Button的背景圖片
        private TextView textView; // 設定圖片的文字
        private CheckBox checkBox; // 圖片的checkbox

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.attractionTypeBtn_image);
            textView = itemView.findViewById(R.id.attractionTypeBtn_txt);
            checkBox = itemView.findViewById(R.id.attractionTypeBtn_checkbox);
            checkBox.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), attractionTypesList[getAdapterPosition()], Toast.LENGTH_SHORT).show();
        }
    }

    public AttractionTypeAdapter(int[] attractionImagesList, String[] attractionTypesList){
            this.attractionImagesList = attractionImagesList;
            this.attractionTypesList = attractionTypesList;
    }

    @NonNull
    @Override
    public AttractionTypeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //建立一個view
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.attraction_type_item, viewGroup, false
        );
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AttractionTypeAdapter.ViewHolder viewHolder, int i) {
        viewHolder.imageView.setImageResource(attractionImagesList[i]);
        viewHolder.textView.setText(attractionTypesList[i]);
    }

    @Override
    public int getItemCount() {
        return attractionTypesList.length;
    }
}
