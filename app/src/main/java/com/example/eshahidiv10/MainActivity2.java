package com.example.eshahidiv10;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText activityDescriptionEdt, activityNameEdt, activityLocationEdt, activityDateEdt, activityTimeEdt, activityReporterEdt;
    private Button addActivityBtn;
    private DBHandler dbHandler;
    String activityName;
    String activityDate;
    String activityLocation;
    String activityTime;
    String activityReporter;
    String activityDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // initializing all our variables.
        activityNameEdt = findViewById(R.id.idEdtActivityName);
        activityDateEdt = findViewById(R.id.idEdtActivityDate);
        activityLocationEdt = findViewById(R.id.idEdtActivityLocation);
        activityTimeEdt = findViewById(R.id.idEdtActivityTime);
        activityReporterEdt = findViewById(R.id.idEdtActivityReporter);
        activityDescriptionEdt = findViewById(R.id.idEdtActivityDescription);
        addActivityBtn = findViewById(R.id.idBtnAddActivity);


        Intent i = getIntent();
        activityName= i.getStringExtra("activityName");
        activityNameEdt.setText(activityName);

        activityDate= i.getStringExtra("activityDate");
        activityDateEdt.setText(activityDate);

        activityLocation= i.getStringExtra("activityLocation");
        activityLocationEdt.setText(activityLocation);

        activityTime= i.getStringExtra("activityTime");
        activityTimeEdt.setText(activityTime);

        activityReporter= i.getStringExtra("activityReporter");
        activityReporterEdt.setText(activityReporter);

        activityDescription = i.getStringExtra("activityDescription");
        activityDescriptionEdt.setText(activityDescription);




        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity2.this);

        // below line is to add on click listener for our add course button.
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
                    Toast.makeText(MainActivity2.this, "Please enter Activity name, date and reporter", Toast.LENGTH_SHORT).show();
                    return;}



                if (activityName.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Please enter Activity name", Toast.LENGTH_SHORT).show();
                    return;}
                if (activityDate.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Please enter Activity date", Toast.LENGTH_SHORT).show();
                    return;}
                if (activityReporter.isEmpty()){
                    Toast.makeText(MainActivity2.this, "Please enter Reporter name", Toast.LENGTH_SHORT).show();
                    return;
                }


                // on below line we are calling a method to add new
                //activity to sqlite data and pass all our values to it.
                dbHandler.addNewActivity(activityName, activityDate, activityLocation, activityTime, activityReporter, activityDescription);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity2.this, "Activity has been added.", Toast.LENGTH_SHORT).show();



                //launch main activity
                Intent w = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(w);
            }
        });

    };
}
