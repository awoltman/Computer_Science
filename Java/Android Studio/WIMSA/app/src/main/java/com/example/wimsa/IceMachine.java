package com.example.wimsa;

public class IceMachine {

    String serial_number,condencer_serial_number,modelnumber;

    public IceMachine(String SN,String CSN,String MN) {
        this.serial_number = SN;
        this.condencer_serial_number = CSN;
        this.modelnumber =  MN;
    }

    public IceMachine(String SN,String MN) {
        this.serial_number = SN;
        this.condencer_serial_number = "none";
        this.modelnumber =  MN;
    }

}
