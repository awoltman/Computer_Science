package com.example.wimsa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class forgotPass extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotpass);

        Button subButton = (Button) findViewById(R.id.subMitBtn);
        subButton.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.logInBtn:
                Intent loginIntent = new Intent(getApplicationContext(), logIn.class);
                startActivity(loginIntent);
                break;
        }

    };
}
