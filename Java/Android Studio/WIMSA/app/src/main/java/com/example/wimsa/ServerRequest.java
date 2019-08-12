package com.example.wimsa;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;


public class ServerRequest {

    String loginEmail,loginPassword;
    boolean inOut = false;

    public boolean ServerRequest(String email, String password){
        this.loginEmail = email;
        this.loginPassword = password;

        new AsyncLogin().execute(email,password);

        return false;
    }

    }
    protected void onPreExecute(){

    }

    private class AsyncLogin extends AsyncTask<String,String,String>{

    }
}
