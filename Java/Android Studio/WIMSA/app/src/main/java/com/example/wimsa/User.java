package com.example.wimsa;

import java.util.ArrayList;

public class User {

    String first_name,last_name,password,email;
    ArrayList<IceMachine> ice_machine;

    public User(String fn,String ln,String pass,String em) {
        this.first_name = fn;
        this.last_name = ln;
        this.password = pass;
        this.email = em;
    }

    public User(String pass,String em, IceMachine  userIceMachines){
        this.password = pass;
        this.email = em;
        this.ice_machine.add(userIceMachines);
    }

    public User(String pass,String em){
        this.password = pass;
        this.email = em;
    }

}
