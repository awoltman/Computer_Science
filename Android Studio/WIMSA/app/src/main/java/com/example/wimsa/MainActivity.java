package com.example.wimsa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newUser = (Button) findViewById(R.id.newUserBtn);
        Button forgotPassword = (Button) findViewById(R.id.forgotPassBtn);
        Button logIn = (Button) findViewById(R.id.logInBtn);


            logIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent startIntent = new Intent(getApplicationContext(), logIn.class);

                    startActivity(startIntent);
                }
            });
        }
    }
