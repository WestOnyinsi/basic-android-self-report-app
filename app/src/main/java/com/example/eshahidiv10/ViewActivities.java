package com.example.eshahidiv10;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewActivities extends AppCompatActivity {

    // creating variables for our array list,
    // dbhandler, adapter and recycler view.
    private ArrayList<Modal> ModalArrayList;
    private DBHandler dbHandler;
    private RVAdapter activityRVAdapter;
    private RecyclerView RV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_activities);

        // initializing our all variables.
        ModalArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewActivities.this);

        // getting our report activity
        // list from db handler class.
        ModalArrayList = dbHandler.readActivities();

        // on below line passing our array lost to our adapter class.
        activityRVAdapter = new RVAdapter(ModalArrayList, ViewActivities.this);
        RV = findViewById(R.id.idRVActivities);

        // setting layout manager for our recycler view.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewActivities.this, RecyclerView.VERTICAL, false);
        RV.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        RV.setAdapter(activityRVAdapter);
    }
}
