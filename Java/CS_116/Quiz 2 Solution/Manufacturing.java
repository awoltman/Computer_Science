//George Koutsogiannakis
package Compiled;
public abstract class Manufacturing 
{
	String productName=null;
	int quantitySold=0;
	Locations area=null;
	
	public Manufacturing()
	{
		productName="No Name Yet";
		quantitySold=0;;
		area=null;
	}

	public Manufacturing(String n, int qs, Locations ga)
	{
		productName=n;
		quantitySold=qs;
		area=ga;
	}

	public String getProductName()
	{
		return productName;
	}
	
	public int getQuantitySold()
	{
		return quantitySold;
	}

	public Locations getState()
	{
		return area;
	}

	public void setProductName(String pn)
	{
		productName=pn;
	}

	public void setQuantitySold(int quso)
	{
		quantitySold=quso;
	}

	public void setState(Locations geo)
	{
		area=geo;
	}

	public String toString()
	{
		String out="The product name is:"+" "+productName+" "+"The quantity sold is:"+" "+quantitySold+" "+"The state where it was sold is:"+" "+area+" ";
		return out;
	}

	public abstract double unitPrice() throws HighPriceException;
}
