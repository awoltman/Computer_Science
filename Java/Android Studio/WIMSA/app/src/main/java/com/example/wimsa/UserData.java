package com.example.wimsa;

import android.content.Context;
import android.content.SharedPreferences;

public class UserData {
    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocal;

    public UserData(Context context){
        userLocal = context.getSharedPreferences(SP_NAME,0);
    }
    public void storedUserData(User user){
        SharedPreferences.Editor spEditor = userLocal.edit();
        spEditor.putString("First Name", user.first_name);
        spEditor.putString("Last Name", user.last_name);
        spEditor.putString("Email", user.email);
        spEditor.putString("Password", user.password);
        spEditor.commit();

    }
    public User getLoggedInUser(){
        String first = userLocal.getString("first_name","");
        String last = userLocal.getString("last_name","");
        String email = userLocal.getString("email","");
        String pass = userLocal.getString("password","");

        User storedUser = new User(first,last,email,pass);
        return storedUser;
    }
    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocal.edit();
        spEditor.putBoolean("LoggedIn",loggedIn);
        spEditor.commit();
    }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userLocal.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
