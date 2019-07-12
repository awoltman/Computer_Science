package com.example.wimsa;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.util.ArrayList;

public class ServerRequest {
    ProgressDialog progressDialog;
    public static final int CONNECTION_TIMEOUT = 1000*15;
    public static final String  SERVER_ADDRESS = "";

    public ServerRequest(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing");
        progressDialog.setMessage("Please wait...");
    }
    public void storeUserDataInBackround(User user, GetUserCallback callback){
        progressDialog.show();
        new StoreUserDataAsyncTask(user,callback).execute();

    }

    public void fetchUserDataInBackround(User user, GetUserCallback callback){
        progressDialog.show();

    }

    public class StoreUserDataAsyncTask extends AsyncTask<Void,Void,Void>{

        User user;
        GetUserCallback userCallback;

        public StoreUserDataAsyncTask(User user, GetUserCallback callback) {
            this.user = user;
            this.userCallback = userCallback;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            ArrayList<NameValuePair> dataToSend = new ArrayList<>();
            dataToSend.add(new BasicNameValuePair("fist name", user.first_name));
            dataToSend.add(new BasicNameValuePair("last name", user.last_name));
            dataToSend.add(new BasicNameValuePair("email", user.email));
            dataToSend.add(new BasicNameValuePair("password", user.password));

            HttpParams httpRequestParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams, CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams, CONNECTION_TIMEOUT);

            HttpClient client = new DefautHttpClient(httpRequestParams);
            HttpPost post = new HttpPost(dataToSend);

            post.setEntity(dataToSend);


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid){

            progressDialog.dismiss();
            userCallback.done(null);
            super.onPostExecute(aVoid);
        }

    }
}
