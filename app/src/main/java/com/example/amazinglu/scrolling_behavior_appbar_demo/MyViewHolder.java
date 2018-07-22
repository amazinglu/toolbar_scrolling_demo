package com.example.amazinglu.scrolling_behavior_appbar_demo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_text) TextView text;

    public MyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
