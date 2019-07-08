import java.util.*;
import java.text.DecimalFormat;
public class Cube extends Figure  implements INT3
{
	public double length=0.0;
	String asked=" ";
	public Cube()
	{
		super();
		length=2.0;
	}
	public Cube(String n, double l, String a)
	{
		super(n);
		length=l;
		asked=a;
		
	}

	public double calculateArea()
	{
		double area=6*Math.pow(length,2.0);
		try
		{
			if(area > 1000)
			{
				throw new TooLargeArea();
			}
		}
		catch(TooLargeArea a)
		{
			System.out.println(a.getMessage());
		}
		return area;
	}

	public double calculateVolume()
	{
		double volume=Math.pow(length,3);
		try
		{
			if(volume > 10000)
			{
				throw new TooLargeVolume();
			}
		}
		catch(TooLargeVolume t)
		{
			System.out.println(t.getMessage());
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
				 cost=20*calculateArea();
				 try
				 {
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				 }
				 catch(TooLargeCost cE)
				 {
					 System.out.println(cE.getMessage());
				 }
				 str="The area drawing cost for an Architect with score <600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				 strcost.add(str);
			}
			else if(c.getType().equals("Architect")&&c.getScore()<600&&asked.equals("volume"))
			{
				cost=40*calculateVolume();
				try
				 {
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				 }
				 catch(TooLargeCost cE)
				 {
					 System.out.println(cE.getMessage());
				 }
				str="The volume drawing cost for an Architect with score <600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				strcost.add(str);
			}
			else if(c.getType().equals("Architect")&&c.getScore()>=600&&asked.equals("area"))
		    {  
				cost=10*calculateArea();
				try
				 {
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				 }
				 catch(TooLargeCost cE)
				 {
					 System.out.println(cE.getMessage());
				 }
				str="The area area drawing cost for an Architect withscore >=600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				 strcost.add(str);
			}
			else if(c.getType().equals("Architect")&&c.getScore()>=600&&asked.equals("volume"))
		    {  
				cost=20*calculateVolume();
				try
				 {
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				 }
				 catch(TooLargeCost cE)
				 {
					 System.out.println(cE.getMessage());
				 }
				str="The volume drawing cost for an Architect with score >=600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				 strcost.add(str);
			}
			else if(c.getType().equals("Other")&&c.getScore()<600&&asked.equals("area"))
		    {  
				cost=30*calculateArea();
				try
				 {
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				 }
				 catch(TooLargeCost cE)
				 {
					 System.out.println(cE.getMessage());
				 }
				str="The area drawing cost for an Other with score <600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				 strcost.add(str);
			}
			else if(c.getType().equals("Other")&&c.getScore()<600&&asked.equals("volume"))
		    {  
				cost=60*calculateVolume();
				try
				 {
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				 }
				 catch(TooLargeCost cE)
				 {
					 System.out.println(cE.getMessage());
				 }
				str="The volume drawing cost for an Other with score <600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				 strcost.add(str);
			}
			else if(c.getType().equals("Other")&&c.getScore()>=600&&asked.equals("area"))
		    {  
				cost=20*calculateArea();
				try
				 {
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				 }
				 catch(TooLargeCost cE)
				 {
					 System.out.println(cE.getMessage());
				 }
				str="The area drawing cost for an Other with score >=600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				 strcost.add(str);	
			}
			else if(c.getType().equals("Other")&&c.getScore()>=600&&asked.equals("volume"))
		    {  
				cost=50*calculateVolume();
				try
				 {
					if(cost > 400000)
					{
						throw new TooLargeCost();
					}
				 }
				 catch(TooLargeCost cE)
				 {
					 System.out.println(cE.getMessage());
				 }
				str="The volume drawing cost for an Other with score>=600 is"+" "+(new DecimalFormat("#.##")).format(cost);
				 strcost.add(str);
			}

        }
		return strcost;
	}

	public String toString()
	{
		 String out=super.toString()+" "+"The length is"+" "+length+" "+"And the parameter asked for is:"+" "+asked;
		 return out;
	}
}
