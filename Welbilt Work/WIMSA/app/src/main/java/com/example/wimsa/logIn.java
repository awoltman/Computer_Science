package com.example.wimsa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class logIn extends AppCompatActivity implements View.OnClickListener {

    UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button logout = (Button) findViewById(R.id.logOutBtn);
        logout.setOnClickListener(this);

        userData = new UserData(this);

    }
    @Override
    protected void onStart(){
        super.onStart();
        if(authenticate() == true){

        }else {
            startActivity(new Intent(logIn.this,MainActivity.class));
        }
    }

    private boolean authenticate(){
        return userData.getUserLoggedIn();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.logOutBtn:
                userData.clearUserData();
                userData.setUserLoggedIn(false);
                Intent loginIntent = new Intent(logIn.this  , MainActivity.class);
                startActivity(loginIntent);
                break;
        }
    }
}