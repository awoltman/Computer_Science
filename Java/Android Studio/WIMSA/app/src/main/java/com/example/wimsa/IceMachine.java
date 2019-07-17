package com.example.wimsa;

public class IceMachine {

    String serial_number,modelnumber,location,tag;


    public IceMachine(String SN,String MN,String Tag,String loc) {

        this.serial_number = SN;
        this.modelnumber =  MN;
        this.location = loc;
        this.tag = Tag;
    }

    public IceMachine(String SN,String MN) {
        this.serial_number = SN;
        this.modelnumber =  MN;
    }

}
