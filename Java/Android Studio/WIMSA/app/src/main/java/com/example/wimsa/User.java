package com.example.wimsa;

public class User {

    String first_name,last_name,password,email;

    public User(String fn,String ln,String pass,String em) {
        this.first_name = fn;
        this.last_name = ln;
        this.password = pass;
        this.email = em;
    }
    public User(String pass,String em){
        this.password = pass;
        this.email = em;
    }
}
