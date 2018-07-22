package com.example.amazinglu.scrolling_behavior_appbar_demo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {

    private List<String> data;

    public MyAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String itemText = data.get(position);
        MyViewHolder viewHolder = (MyViewHolder)  holder;
        viewHolder.text.setText(itemText);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
