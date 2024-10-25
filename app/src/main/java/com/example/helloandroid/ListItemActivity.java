package com.example.helloandroid;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class ListItemActivity extends AppCompatActivity{
    ImageGalleryAdapter adapter;
    RecyclerView recyclerView;
    OnDataClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_item);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        List<Data> list = getData();

        recyclerView = findViewById(R.id.recyclerView);
        listener = new OnDataClickListener() {
            @Override
            public void click(int index) {
                Toast.makeText(ListItemActivity.this, "clicked item index is " + index, Toast.LENGTH_LONG).show();
            }
        };

        adapter = new ImageGalleryAdapter(list, getApplicationContext(), listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
    }

    // Sample data for RecyclerView
    private List<Data> getData()
    {
        List<Data> list = new ArrayList<>();
        list.add(new Data("First Exam", "May 23, 2015", "Best Of Luck"));
        list.add(new Data("Second Exam", "June 09, 2015", "b of l"));
        list.add(new Data("My Test Exam", "April 27, 2017", "This is testing exam .."));

        return list;
    }
}
