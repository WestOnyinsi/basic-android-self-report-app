package com.example.eshahidiv10;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText activityDescriptionEdt, activityNameEdt, activityLocationEdt, activityDateEdt, activityTimeEdt, activityReporterEdt;
    private Button addActivityBtn, readActivityBtn, displayActivityBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        activityNameEdt = findViewById(R.id.idEdtActivityName);
        activityDateEdt = findViewById(R.id.idEdtActivityDate);
        activityLocationEdt = findViewById(R.id.idEdtActivityLocation);
        activityTimeEdt = findViewById(R.id.idEdtActivityTime);
        activityReporterEdt = findViewById(R.id.idEdtActivityReporter);
        activityDescriptionEdt = findViewById(R.id.idEdtActivityDescription);
        addActivityBtn = findViewById(R.id.idBtnAddActivity);
        readActivityBtn = findViewById(R.id.idBtnReadActivity);
        displayActivityBtn= findViewById(R.id.idBtnDisplayActivity);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add activity button.
        addActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String activityName = activityNameEdt.getText().toString();
                String activityDate = activityDateEdt.getText().toString();
                String activityLocation = activityLocationEdt.getText().toString();
                String activityTime = activityTimeEdt.getText().toString();
                String activityReporter = activityReporterEdt.getText().toString();
                String activityDescription = activityDescriptionEdt.getText().toString();




                // validating if the text fields are empty or not.
                if (activityName!=null && activityDate.isEmpty() && activityReporter.isEmpty() ){
                    Toast.makeText(MainActivity.this, "Please enter Activity name, date and reporter", Toast.LENGTH_SHORT).show();
                    return;}



                if (activityName.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter Activity name", Toast.LENGTH_SHORT).show();
                    return;}
                if (activityDate.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter Activity date", Toast.LENGTH_SHORT).show();
                    return;}
                if (activityReporter.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter Reporter name", Toast.LENGTH_SHORT).show();
                    return;
                }
                // if all required fields are filled then proceed to confirmation screen
                if(activityName!=null && activityDate!=null && activityReporter!=null){
                    Toast.makeText(MainActivity.this, "Please confirm details", Toast.LENGTH_SHORT).show();
                }

                //passing values to confirmation activity
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("activityName", activityName);
                i.putExtra("activityDate", activityDate);
                i.putExtra("activityLocation", activityLocation);
                i.putExtra("activityTime", activityTime);
                i.putExtra("activityReporter", activityReporter);
                i.putExtra("activityDescription", activityDescription);


                startActivity(i);


            }
        });

        readActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, ViewActivities.class);
                startActivity(i);
            }
        });
        displayActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new activity via a intent.
                Intent i = new Intent(MainActivity.this, ActivityDisplay.class);
                startActivity(i);
            }
        });
    }
}
