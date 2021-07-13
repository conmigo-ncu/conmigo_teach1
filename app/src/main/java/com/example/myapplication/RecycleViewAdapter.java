package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecycleViewAdapter extends
        RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private List<String> mListString;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mTxt;
        public ViewHolder(View itemView){
            super(itemView);
            mTxt = (TextView) itemView.findViewById(R.id.txt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), mListString.get(getAdapterPosition()),Toast.LENGTH_LONG).show();
        }
    }

    public RecycleViewAdapter(List<String> listString){
        mListString = listString;
    }

    @NonNull
    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycle_view_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.ViewHolder viewHolder, int i) {
        viewHolder.mTxt.setText(mListString.get(i));
    }

    @Override
    public int getItemCount() {
        return mListString.size();
    }
}