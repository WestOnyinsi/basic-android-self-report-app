package com.example.eshahidiv10;

import android.os.Bundle;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ActivityDisplay extends AppCompatActivity {
    // creating variables for our array list,
        // dbhandler, adapter and recycler view.
        private ArrayList<Modal> ModalArrayList;
        private DBHandler dbHandler;
        private RVAdapter2 activityRVAdapter;
        private RecyclerView RV;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_display);

            // initializing our all variables.
            ModalArrayList = new ArrayList<>();
            dbHandler = new DBHandler(com.example.eshahidiv10.ActivityDisplay.this);

            // getting our report activity
            // list from db handler class.
            ModalArrayList = dbHandler.readActivities();

            // on below line passing our array lost to our adapter class.
            activityRVAdapter = new RVAdapter2(ModalArrayList, com.example.eshahidiv10.ActivityDisplay.this);
            RV = findViewById(R.id.idRVActivities);

            // setting layout manager for our recycler view.
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(com.example.eshahidiv10.ActivityDisplay.this, RecyclerView.VERTICAL, false);
            RV.setLayoutManager(linearLayoutManager);

            // setting our adapter to recycler view.
            RV.setAdapter(activityRVAdapter);
        }
    }
