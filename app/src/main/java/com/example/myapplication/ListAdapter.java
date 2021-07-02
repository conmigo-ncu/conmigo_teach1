package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

public class ListAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_items, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);
    }

    @Override
    public int getItemCount() {
        return LandscapeData.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private CheckBox kinds;
        public ListViewHolder(View itemView){
            super(itemView);
            kinds = itemView.findViewById(R.id.sight_kinds);
            itemView.setOnClickListener(this);
        }
        public void bindView(int i){
            kinds.setText(LandscapeData.title[i]);
            kinds.setBackgroundResource(LandscapeData.image[i]);
        }
        public void onClick(View view){

        }
    }
}
