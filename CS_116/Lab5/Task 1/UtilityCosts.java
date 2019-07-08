package Client.Services.Enums.Help;

public class UtilityCosts
{
	double electricity;
	double gas;
	double water;
	static double utilcostsforallobjects = 0.0;
	
	public UtilityCosts()
	{
		electricity = 0.0;
		gas = 0.0;
		water = 0.0;
	}
	
	public UtilityCosts(double eCost, double gCost, double wCost)
	{
		electricity = eCost;
		gas = gCost;
		water = wCost;
	}
	
	//Accessors
	//Check if you need more here
	public double getUtilCosts()
	{
		return utilcostsforallobjects;
	}
	
	//Mutators
	public void setElectricity(double x)
	{
		electricity = x;
	}
	
	public void setGas(double g)
	{
		gas = g;
	}
	
	public void setWater(double w)
	{
		water = w;
	}
	
	//toString method
	public String toString()
	{
		String out = "The electricity cost is " + electricity +". The gas cost is "+ gas + ". The water cost is "+water+".";
		return out;
	}
	
	//helper method
	public double totalUtilCosts()
	{
		double sumUtil = electricity+gas+water;
		utilcostsforallobjects += sumUtil;
		System.out.println("The total cost for this utility is " + sumUtil + ". The total cost for all the utilities up to this point is " 
							+ utilcostsforallobjects);
		return sumUtil;
	}
}












