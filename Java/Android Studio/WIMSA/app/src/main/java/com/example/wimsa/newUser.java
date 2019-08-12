package com.example.wimsa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class newUser extends AppCompatActivity implements View.OnClickListener {

    EditText etFirst,etLast,etEmail,etPassword,etcheckpassword;
    UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newuser);
        etFirst = (EditText) findViewById(R.id.snEditText);
        etLast = (EditText) findViewById(R.id.mnEditText);
        etEmail = (EditText) findViewById(R.id.tagEditText);
        etPassword = (EditText) findViewById(R.id.passwordEditText);
        etcheckpassword = (EditText) findViewById(R.id.conPasswordTextView);
        userData = new UserData(this);
        Button register = (Button) findViewById(R.id.regBtn);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regBtn:
                final String first_n = etFirst.getText().toString();
                final String last_n = etLast.getText().toString();
                final String email = etEmail.getText().toString();
                final String password = etPassword.getText().toString();
                final String conpassword = etcheckpassword.getText().toString();
                if(password != conpassword){
                    User regUser = new User(first_n,last_n,email,password);

                    Intent failConfirm = new Intent(getApplicationContext(), newUser.class);
                    startActivity(failConfirm);
                }
                else{
                    Intent loginSuc = new Intent(getApplicationContext(), logIn.class);
                    startActivity(loginSuc);
                }
                break;
        }

    }
}
