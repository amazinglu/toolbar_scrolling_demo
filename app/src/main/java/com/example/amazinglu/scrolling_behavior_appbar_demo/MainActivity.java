package com.example.amazinglu.scrolling_behavior_appbar_demo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.main_recycler_view) RecyclerView recyclerView;

    private MyAdapter adapter;

    /**
     * Creating the Flexible Space with Image Pattern
     *
     * https://android.jlelse.eu/scrolling-behavior-for-appbars-in-android-41aff9c5c468
     *
     * 注意：
     * 在toolbar中设置fitsSystemWindows是没有用的，在AppBarLayout中设置才行
     * imageView要设置itsSystemWindows和height要match_parent, 然后image才可以作为status bar的background
     * */

    @SuppressLint("RestrictedApi")
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
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

    private Context getContext() {
        return MainActivity.this;
    }
}
