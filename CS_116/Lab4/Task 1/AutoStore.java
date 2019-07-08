package main.service;
import main.*;
import main.service.*;
import main.service.enums.*;

public class AutoStore
{
	Auto car;
	private Stores ve;
	double sale =0.0; 
	static int id=0;
	int currentID=0;


	public AutoStore()
	{
        sale = 0.0;
        ve = null;
        car = null;
		id++;
		currentID=id;
	}

	public AutoStore(double s)
	{
		sale=s;
        ve = null;
        car = null;
		id++;
		currentID=id;
	}

	public Stores getStore()
	{
        return ve;
	}

	public double getSale()
	{
		return sale;
	}

	public Auto getAuto()
    {
        return car;
    } 


	public int getCurrentID()
	{
		return currentID;
	}
    
    public void setStoreType(Stores newStore)
    {
        ve = newStore;
    }

	public void setCarType(Auto ct)
	{
        car = ct;
	}

	public void setSale(double sa)
	{
		sale=sa;
	}

	public void setCar(Auto newCar)
	{
        car = newCar;
	}

	public void setCurrentID(int cid)
	{
		currentID=cid;
	}

	public String toString()
	{
		String out="The store is: "+" "+ve+" "+"The sale price of the car is: "+" "+sale+" "+"The car is: "+" "+car.getCarType()+" "+"The auto store object id is: "+currentID+"The auto is"+car.toString();
		return out;
	}
}
