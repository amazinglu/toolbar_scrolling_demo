package com.example.amazinglu.scrolling_behavior_appbar_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.main_recycler_view) RecyclerView recyclerView;

    private MyAdapter adapter;

    /**
     * implement scrolling behavior using CoordinatorLayout and AppBarLayout
     *
     * Standard App bar scrolling with only Toolbar
     * details in activity_main.xml
     * https://android.jlelse.eu/scrolling-behavior-for-appbars-in-android-41aff9c5c468
     * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,
                DividerItemDecoration.VERTICAL));
        adapter = new MyAdapter(fakeData());
        recyclerView.setAdapter(adapter);
    }

    private List<String> fakeData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 20; ++i) {
            data.add("item " + i);
        }
        return data;
    }
}
