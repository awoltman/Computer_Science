import java.util.*;
import java.text.*;

public class Sphere extends Figure  implements INT3
{
	public double radius=0.0;
	String asked=" ";
	public Sphere()
	{
		super();
		radius=2.0;
	}
	public Sphere(String n, double r, String a)
	{
		super(n);
		radius=r;
		asked=a;
		
	}

	public double calculateArea()
	{
		double area=4*Math.PI*Math.pow(radius,2.0);
		try
		{
			if(area > 1000)
			{
				throw new TooLargeArea();
			}
		}
		catch(TooLargeArea t)
		{
			System.out.println(t.getMessage());
		}		
		return area;
	}

	public double calculateVolume()
	{
		double volume=(4/3)*Math.PI*Math.pow(radius,3);
		try
		{
			if(volume > 10000)
			{
				throw new TooLargeVolume();
			}
		}
		catch(TooLargeVolume v)
		{
			System.out.println(v.getMessage());
		}
		return volume;
	}

	
	public Vector secretData()
	{
		 Impl i=new Impl();
		 Vector v3=i.secretData();
		 return v3;
	}

	public ArrayList<String> costToDraw(Vector v4)
	{
		double cost=0.0;
		String str=" ";
		ArrayList<String> strcost=new ArrayList<String>();
		//Vector v4=secretData();
		for(int i=0; i<v4.size(); i++)
		{
			Object o=v4.get(i);
			Customers c=(Customers)o;
			if(c.getType().equals("Architect")&&c.getScore()<600&&asked.equals("area"))
			{
				cost=40*calculateArea();
				try
				{
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				}
				catch(TooLargeCost k)
				{
					System.out.println(k.getMessage());
				}
				str="The area drawing cost for an Architect with score <600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				strcost.add(str);
			}
			else if(c.getType().equals("Architect")&&c.getScore()<600&&asked.equals("volume"))
			{
				cost=80*calculateVolume();
				try
				{
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				}
				catch(TooLargeCost k)
				{
					System.out.println(k.getMessage());
				}
				str="The volume drawing cost for an Architect with score<600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				strcost.add(str);
			}
			else if(c.getType().equals("Architect")&&c.getScore()>=600&&asked.equals("area"))
		    {  
				cost=20*calculateArea();
				try
				{
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				}
				catch(TooLargeCost k)
				{
					System.out.println(k.getMessage());
				}
				str="The area drawing cost for an Architect with score >=600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				strcost.add(str);
			}
			else if(c.getType().equals("Architect")&&c.getScore()>=600&&asked.equals("volume"))
		    {  
				cost=40*calculateVolume();
				try
				{
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				}
				catch(TooLargeCost k)
				{
					System.out.println(k.getMessage());
				}
				str="The volume drawing cost for an Architect with score >=600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				strcost.add(str);
			}
			else if(c.getType().equals("Other")&&c.getScore()<600&&asked.equals("area"))
		    {  
				cost=60*calculateArea();
				try
				{
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				}
				catch(TooLargeCost k)
				{
					System.out.println(k.getMessage());
				}
				str="The area drawing cost for an Other with score <600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				strcost.add(str);
			}
			else if(c.getType().equals("Other")&&c.getScore()<600&&asked.equals("volume"))
		    {  
				cost=120*calculateVolume();
				try
				{
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				}
				catch(TooLargeCost k)
				{
					System.out.println(k.getMessage());
				}
				str="The volume drawing cost for an Other with score <600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				strcost.add(str);
			}
			else if(c.getType().equals("Other")&&c.getScore()>=600&&asked.equals("area"))
		    {  
				cost=40*calculateArea();
				try
				{
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				}
				catch(TooLargeCost k)
				{
					System.out.println(k.getMessage());
				}
				str="The area  drawing cost for an Other with score >=600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				strcost.add(str);
			}
			else if(c.getType().equals("Other")&&c.getScore()>=600&&asked.equals("volume"))
		    {  
				cost=100*calculateVolume();
				try
				{
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				}
				catch(TooLargeCost k)
				{
					System.out.println(k.getMessage());
				}
				str="The volume drawing cost for an Other with score>=600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				strcost.add(str);
			}
        }
		
		return strcost;
	}

	public String toString()
	{
		 String out=super.toString()+"The radius is"+" "+radius+" "+"And the parameter asked for is:"+" "+asked;
		 return out;
	}
}
