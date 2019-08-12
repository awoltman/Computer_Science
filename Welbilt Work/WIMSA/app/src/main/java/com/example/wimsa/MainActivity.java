package com.example.wimsa;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText emailET,passwordET;
    private ProgressBar progressBar;
    String email,password;
    UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailET = (EditText) findViewById(R.id.tagEditText);
        passwordET = (EditText) findViewById(R.id.passwordEditText);
        email = emailET.getText().toString();
        password = emailET.getText().toString();
        progressBar = (ProgressBar) findViewById(R.id.logInProgressBar);
        userData = new UserData(this);


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
                            User user = new User(password,email);
                            userData.storedUserData(user);
                            userData.setUserLoggedIn(true);
                            progressBar.setVisibility(View.VISIBLE);
                            

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
