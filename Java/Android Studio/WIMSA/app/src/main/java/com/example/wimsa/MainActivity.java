package com.example.wimsa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText emailET,passwordET;
    String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailET = (EditText) findViewById(R.id.tagEditText);
        passwordET = (EditText) findViewById(R.id.passwordEditText);
        email = emailET.getText().toString();
        password = emailET.getText().toString();

        Button forgotPassword = (Button) findViewById(R.id.forgotPassBtn);
        Button logIn = (Button) findViewById(R.id.logInBtn);
        Button newUser = (Button) findViewById(R.id.newUserBtn);
        logIn.setOnClickListener(this);
        forgotPassword.setOnClickListener(this);
        newUser.setOnClickListener(this);
    }


                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.logInBtn:

                            Intent loginIntent = new Intent(getApplicationContext(), logIn.class);
                            startActivity(loginIntent);
                            break;
                        case R.id.forgotPassBtn:
                            Intent forgotIntent = new Intent(getApplicationContext(), forgotPass.class);
                            startActivity(forgotIntent);
                            break;
                        case R.id.newUserBtn:
                            Intent newIntent = new Intent(getApplicationContext(), newUser.class);
                            startActivity(newIntent);
                            break;
                    }

                }



        }
