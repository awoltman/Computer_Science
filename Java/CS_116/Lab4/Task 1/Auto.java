package main.service;

import main.*;
import main.service.*;
import main.service.enums.*;
import java.text.DecimalFormat;
public class Auto
{
	private String owners_name;
	private double acceleration;
	private int time;
	private CarType ve;
	private static int vehicleID;
	private int currentID;
	private boolean  soldORnot;
    private AutoStore store;

	public Auto()
	{
		owners_name=" ";

		acceleration=0.0;
		time=0;
        soldORnot =false;
        ve = null;
		
		//----initialize the enum attributes to null
		
		vehicleID++;
		currentID=vehicleID;
		
	}

	public Auto(double a, int t, String on, CarType eng)
	{
		vehicleID++;
		currentID=vehicleID;
		soldORnot = false;
		acceleration=a;
		time=t;
		owners_name=on;
		ve=eng;
	
	}

	public String getOwnersName()
	{
		return owners_name;
	}

	public double getAcceleration()
	{

		return acceleration;
	}


	public int getTime()
	{
		return time;
	}

	public int getVehicleID()
	{
		return vehicleID;
	}

	public int getCurrentID()
	{

		return currentID;
	}

	public CarType getCarType()
    {
        return ve;
    }
	public boolean getSoldORnot()
	{
		return soldORnot;
	}

	public AutoStore getAutoStore()
	{
        return store;
	}
	

	public void setOwnersName(String name)
	{
		owners_name=name;
	}

	public void setTime(int t)
	{
		time=t;
	}

	public void setAcceleration(double ac)
	{

		acceleration=ac;

	}



	// enter set method for CarType enum
    public void setCarType(CarType be)
    {
        ve = be;
    }

	// enter the set method for the AutoStore attribute
    public void setAutoStore(AutoStore as)
	{
		store = as;
	}
	
	public void setAutoID(int sid)
	{
		vehicleID=sid;
	}

	public void setCurrentID(int cid)
	{
		currentID=cid;
	}
    public void setSoldORnot(boolean s)
    {
        soldORnot = s;
    }

	public String toString()
	{

		String str="The auto ID is:"+" "+currentID+" "+"The name of the owner is:"+" "+owners_name+" "+"The acceleration is:"+" "+acceleration+
		"m/sec"+" "+"The car type is:"+" "+ve+"And the traveling time is;"+time+" "+"The price of the vehicle is"+" "+ store.getSale()+" "+"The store is"+" "+ store.getStore()+" "+"Sold status ="+" "+soldORnot;
		return str;
	}
	public double calculateV(double i)
	{
        DecimalFormat nf=new DecimalFormat("0.00");
		double velocity=acceleration*time+i;
		String vel=nf.format(velocity);
		double velform=Double.parseDouble(vel);
		return velform;
	}

	public double calculateD(double i, double d)
	{
		DecimalFormat nf=new DecimalFormat("0.00");
		double timed=(double)time;
		double t=Math.pow(timed, 2.0);
		double distance=0.5*acceleration*t+i*time+d;
		String dist=nf.format(distance);
		double distform=Double.parseDouble(dist);
		return distform;
	}

	public double calculateF(int m, double sd)
	{
		DecimalFormat nf=new DecimalFormat("0.00");
		double force=m*Math.pow(calculateV(0.0),2)/(2*sd);
		String forc=nf.format(force);
		double forceform=Double.parseDouble(forc);
		return forceform;
	}

	public boolean equals(Auto v)
	{
		if((this.getAcceleration()==v.getAcceleration())&&(this.getCarType().equals(v.getCarType())))
		   return true;
		else
		    return false;
	}

	
}
