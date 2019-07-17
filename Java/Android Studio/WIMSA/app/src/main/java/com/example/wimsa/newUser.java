package com.example.wimsa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class newUser extends AppCompatActivity implements View.OnClickListener {

    EditText etFirst,etLast,etEmail,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newuser);
        etFirst = (EditText) findViewById(R.id.snEditText);
        etLast = (EditText) findViewById(R.id.mnEditText);
        etEmail = (EditText) findViewById(R.id.tagEditText);
        etPassword = (EditText) findViewById(R.id.passwordEditText);
        Button register = (Button) findViewById(R.id.regBtn);
        register.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regBtn:
                String first_n = etFirst.getText().toString();
                String last_n = etLast.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                User registeredData = new User(first_n,last_n,email,password);
                break;
        }

    }
}
