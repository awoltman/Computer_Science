package com.example.wimsa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMachine extends AppCompatActivity implements View.OnClickListener {

    EditText snET, mnET, tagET, locET;
    String serialNumber,modelNumber,tag,location;
    UserData addNewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addmachine);
        Button submitButton = (Button) findViewById(R.id.subMitBtn);
        Button backButton = (Button) findViewById(R.id.backBtn);

        snET = (EditText) findViewById(R.id.snEditText);
        mnET = (EditText) findViewById(R.id.mnEditText);
        tagET = (EditText) findViewById(R.id.tagEditText);
        locET = (EditText) findViewById(R.id.locEditText);

        serialNumber = snET.getText().toString();
        modelNumber = mnET.getText().toString();
        tag = tagET.getText().toString();
        location = locET.getText().toString();

        submitButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.subMitBtn:

                IceMachine newIceMachine = new IceMachine(serialNumber,modelNumber,tag,location);
                addNewData.addNewMachine(newIceMachine);
                Intent subIntent = new Intent(getApplicationContext(), logIn.class);

                startActivity(subIntent);
                break;
            case R.id.backBtn:
                Intent forgotIntent = new Intent(getApplicationContext(), logIn.class);
                startActivity(forgotIntent);
                break;

        }

    }

}