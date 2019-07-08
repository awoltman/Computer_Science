package Client.Services.Enums.Help;

public class MaterialCosts
{
	String materialName;
	double unitPrice;
	int quantity;
	static double materialcostforallobjects = 0.0;
	
	
	public MaterialCosts()
	{
		materialName = "";
		unitPrice = 0.0;
		quantity = 0;
	}
	
	public MaterialCosts(String s, double u, int q)
	{
		materialName = s;
		unitPrice = u;
		quantity = q;
	}
	
	//Accessors
	public double getMaterialCost()
	{
		return materialcostforallobjects;
	}
	
	//Mutators
	public void setMaterialName(String s)
	{
		materialName = s;
	}
	
	public void setUnitPrice(double p)
	{
		unitPrice = p;
	}
	
	public void setQuantity(int q)
	{
		quantity = q;
	}
	
	//toString method
	public String toString()
	{
		String out = "The material name is " + materialName + ". The unit price is " + unitPrice + ". The quantity is " + quantity +".";
		return out;
	}
	
	//helper method
	public double materialPrice()
	{
		double matPrice = unitPrice * quantity;
		if(quantity >= 100)
		{
			matPrice = .8 * matPrice;
		}
		else
		{
			matPrice = .9 * matPrice;
		}
		materialcostforallobjects += matPrice;
		System.out.println("The price for the material is " + matPrice + ". The total cost of the materials up to this point is " 
							+ materialcostforallobjects+".");
		return matPrice;
	}
}



