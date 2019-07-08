package Client.Services.Enums.Help;

public class Rent
{
	String location;
	int yearOfLeasing;
	int buildingNumber;
	static double rentcostforallobjects = 0;
	
	public Rent()
	{
		location = "";
		yearOfLeasing = 0;
		buildingNumber = 0;
	}
	
	public Rent(String l, int y, int b)
	{
		location = l;
		yearOfLeasing = y;
		buildingNumber = b;
	}
	
	//Accessors
	public double getRentCost()
	{
		return rentcostforallobjects;
	}
	
	//Mutators
	public void setLocation(String l)
	{
		location = l;
	}
	
	public void setYearOfLeasing(int y)
	{
		yearOfLeasing = y;
	}
	
	public void setBuildingNumber(int bN)
	{
		buildingNumber = bN;
	}
	
	//toString method
	public String toString()
	{
		String out = "The location is " + location + ". The year of leasing is " + yearOfLeasing + ". The building number is " + buildingNumber+".";
		return out;
	}
	
	//helper method
	public double rent()
	{
		double locationDouble = Double.parseDouble(location);
		double buildingRent = locationDouble * yearOfLeasing * 150/buildingNumber;
		rentcostforallobjects += buildingRent;
		System.out.println("The rent of the building is " + buildingRent + ". The total cost of all the rent up to this point is "+rentcostforallobjects
							+ ".");
		return buildingRent;
	}
	
	
}





