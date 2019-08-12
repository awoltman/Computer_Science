package com.example.wimsa;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class User {

    String first_name,last_name,password,email;
    ArrayList<IceMachine> ice_machine;

    @SerializedName("response")
    private String Response;

    @SerializedName("first_name")
    private String firstname;

    @SerializedName("last_name")
    private String lastname;

    @SerializedName("ice_machines")
    private String icemachine;

    public String getResponse() {
        return Response;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getIcemachine() {
        return icemachine;
    }

    public User(String fn, String ln, String em, String pass) {
        this.first_name = fn;
        this.last_name = ln;
        this.password = pass;
        this.email = em;
    }

    public User(String em,String pass, IceMachine  userIceMachines){
        this.password = pass;
        this.email = em;
        this.ice_machine.add(userIceMachines);
    }

    public User(String em,String pass){
        this.password = pass;
        this.email = em;
    }

}
