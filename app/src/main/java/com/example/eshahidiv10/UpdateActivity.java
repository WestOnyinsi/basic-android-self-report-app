package com.example.eshahidiv10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    // variables for our edit text, button, strings and dbhandler class.
    private EditText activityDescriptionEdt, activityNameEdt, activityLocationEdt, activityDateEdt, activityTimeEdt, activityReporterEdt;
    private Button updateActivityBtn, deleteActivityBtn;
    private DBHandler dbHandler;
    private String activityName, activityDate, activityLocation, activityTime, activityReporter, activityDescription ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_activity);

        // initializing all our variables.
        activityNameEdt = findViewById(R.id.idEdtActivityName);
        activityDateEdt = findViewById(R.id.idEdtActivityDate);
        activityLocationEdt = findViewById(R.id.idEdtActivityLocation);
        activityTimeEdt = findViewById(R.id.idEdtActivityTime);
        activityReporterEdt = findViewById(R.id.idEdtActivityReporter);
        activityDescriptionEdt = findViewById(R.id.idEdtActivityDescription);
        updateActivityBtn = findViewById(R.id.idBtnUpdateActivity);
        deleteActivityBtn = findViewById(R.id.idBtnDelete);


        // getting values from database
        dbHandler = new DBHandler(UpdateActivity.this);
        activityName= getIntent().getStringExtra("name");
        activityDate= getIntent().getStringExtra("date");
        activityLocation= getIntent().getStringExtra("location");
        activityTime= getIntent().getStringExtra("time");
        activityReporter= getIntent().getStringExtra("reporter");
        activityDescription = getIntent().getStringExtra("description");


        // setting data to edit text of our update activity.
        activityNameEdt.setText(activityName);
        activityDateEdt.setText(activityDate);
        activityLocationEdt.setText(activityLocation);
        activityTimeEdt.setText(activityTime);
        activityReporterEdt.setText(activityReporter);
        activityDescriptionEdt.setText(activityDescription);

        // adding on click listener to our update activity button.
        updateActivityBtn.setOnClickListener(v -> {

            // inside this method we are calling an update activity method and passing all our edit text values.
            dbHandler.updateActivity (activityName, activityNameEdt.getText().toString(), activityDateEdt.getText().toString(), activityLocationEdt.getText().toString(), activityTimeEdt.getText().toString(), activityReporterEdt.getText().toString(), activityDescriptionEdt.getText().toString() );

            // displaying a toast message that our activity has been updated.
            Toast.makeText(UpdateActivity.this, "Activity Updated..", Toast.LENGTH_SHORT).show();

            // launching our main activity.
            Intent i = new Intent(UpdateActivity.this, MainActivity.class);
            startActivity(i);
        });

        // adding on click listener for delete button to delete our activity.
        deleteActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling a method to delete our activity.
                dbHandler.deleteActivity(activityName);
                Toast.makeText(UpdateActivity.this, "Deleted the activity", Toast.LENGTH_SHORT).show();

                // launching our main activity.
                Intent i = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
