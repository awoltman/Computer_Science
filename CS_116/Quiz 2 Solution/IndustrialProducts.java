//George Koutsogiannakis
package Compiled;
public class IndustrialProducts extends Manufacturing
{
	
	
	int snowFrequency=0;

	public IndustrialProducts()
	{
		super();
		snowFrequency=0;
		
	}

	public IndustrialProducts(String n, int qsold, Locations ar, int ms)
	{
		super(n,qsold,ar);
		snowFrequency=ms;
		
	}

	public int getSnowFrequency()
	{
		return snowFrequency;
	}
	
	public void setSnowFrequency(int mesi)
	{
		snowFrequency=mesi;
	}

	public int getQuantitySold()
	{
		int x=super.getQuantitySold();
		if(area==Locations.Florida&&snowFrequency<3)
           x=x/2;
	
		return x;
	}

	public String toString()
	{
		String out=super.toString()+"The snow frequency is:"+" "+snowFrequency;
		return out;
	}

	public double unitPrice()
	{
		double unitPrice=0.0;
		boolean flag=false;
		try
		{   
			
			if(area==Locations.Illinois||area==Locations.Maryland)
				unitPrice=snowFrequency*10.0;
			else
				unitPrice=snowFrequency*20.0;
			if(unitPrice>500.00)
				throw new HighPriceException();
		
			
		}
		catch (HighPriceException ws)
		{
			System.out.println(ws.getMessage());
			System.out.println(ws.toString());
			flag=true;
		}
		finally
		{
			if(flag)
				unitPrice=500.00;
		}
		
		return unitPrice;
		
	}
}
