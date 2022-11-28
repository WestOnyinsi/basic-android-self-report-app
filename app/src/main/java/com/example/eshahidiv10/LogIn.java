package com.example.eshahidiv10;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {// creating variables for our edit text and buttons.
    private EditText userNameEdt, passwordEdt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // initializing our edit text  and buttons.
        userNameEdt = findViewById(R.id.idEdtUserName);
        passwordEdt = findViewById(R.id.idEdtPassword);
        loginBtn = findViewById(R.id.idBtnLogin);

        // adding on click listener for our button.
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // on below line we are getting data from our edit text.
                String userName = userNameEdt.getText().toString();
                String password = passwordEdt.getText().toString();

                //integrity constraints
                if (userName.equals("wonyinsi@usiu.ac.ke") && password.equals("admin") ) {
                    Toast.makeText(LogIn.this, "Logging in...", Toast.LENGTH_SHORT).show();

                    Intent w = new Intent(LogIn.this, MainActivity.class);
                    startActivity(w);

                }

                else if (TextUtils.isEmpty(userName) && TextUtils.isEmpty(password)) {
                    Toast.makeText(LogIn.this, "Please enter user name and password", Toast.LENGTH_SHORT).show();

                }

                else{
                    Toast.makeText(LogIn.this, "Please enter valid email and password", Toast.LENGTH_SHORT).show();

                }



            }
        });
    }

}