package com.example.wimsa;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.os.AsyncTask;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.net.HttpURLConnection;

public class ServerRequest {
    public static final int CONNECTION_TIMEOUT = 10000;

    public boolean checkIfUser(String em, String pass){
        final String email = em;
        final String password = pass;

        new AsyncLogin().execute(email,password);
    }

    private class AsyncLogin extends AsyncTask<String,String,String>{
        HttpURLConnection conn;
    }


}
