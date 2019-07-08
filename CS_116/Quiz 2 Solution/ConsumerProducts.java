//George Koutsogiannakis
package Compiled;
public class  ConsumerProducts extends Manufacturing
{
	
	
	String weather=" ";
	int index=0;

	public ConsumerProducts()
	{
		super();
		weather=" ";
		index=0;
		
	}

	public ConsumerProducts(String n, int qsold, Locations ar, String ss, int ind)
	{
		super(n,qsold,ar);
		weather=ss;
		index=ind;
		
	}

	public String getWeather()
	{
		return weather;
	}
	
	public void setWeather(String scsi)
	{
		weather=scsi;
	}

	public int getIndex()
	{
		return index;
	}

	public void setIndex(int i)
	{
		index=i;
	}

	public String toString()
	{
		String out=super.toString()+"The weather is:"+" "+weather+" "+"The index multiplier is:"+" "+index;
		return out;
	}

	public int getQuantitySold()
	{
		int x=super.getQuantitySold();
		if(weather.equals("windy"))
		   x=x+50;
	    return x;
	}

	public double unitPrice()
	{
		double unitPrice=0.0;
		boolean flag=false;
		try
		{  
			
			if((area==Locations.Illinois||area==Locations.Maryland))
			{
				if(weather.equals("fair"))
				  unitPrice=index*100;
			    else 
				  unitPrice=index*200;
			}
			if((area==Locations.California||area==Locations.Florida))
			{
				if(weather.equals("fair"))
				  unitPrice=index*120.00;
			    else
				  unitPrice=index*150.00;
			}
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

