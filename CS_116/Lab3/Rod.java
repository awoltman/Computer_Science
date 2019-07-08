//package andrew.woltman;
//import andrew.RodClient;
import java.text.*;
public class Rod
{
	private MaterialCategories materialBase;
	private String material;
	private double area;
	private double length;
	private int  temp;
	static int id;
	int currentid;
	
	public Rod()
	{
		materialBase = null;
		material = "any";
		area =	-0.1;
		length = -0.1;
		temp = 0;
		id++;
		currentid = id;
	}
	public Rod(int newTemp,String newMaterial, double newArea, double newLength)
	{
		temp = newTemp;
		material = newMaterial;
		area = newArea;
		length = newLength;
		id++;
		currentid = id;
	}
	public int getTemp()
	{
		return temp;
	}
	public int getCurrentID()
	{
		return currentid;
	}
	public MaterialCategories getMaterialCategory()
	{
		return materialBase;
	}
	public String getMaterial()
	{
		return material;
	}
	public double getArea()
	{
		return area;
	}
	public double getLength()
	{
		return length;
	}
	public void setMaterialCategory(MaterialCategories mc)
	{
		materialBase = mc;
	}
	public void setMaterial(String mat)
	{
		material = mat;
	}
	public void setArea(double ar)
	{
		area = ar;
	}
	public void setLength(double leng)
	{
		length = leng;
	}
	public void setTemp(int tem)
	{
		temp = tem;
	}
	public boolean equals(Rod newRod)
	{
		if((this.getMaterialCategory().equals(newRod.getMaterialCategory())) && this.getMaterial().equals(newRod.getMaterial()))
			return true;
		else
			return false;
	}
	public String toString()
	{
		String str = "The category is:"+" "+materialBase+" "+"The name of the material is:"+" "+material+" "+"The length is:"+" "+length+" "+"The cross area is:"+" "+area+" "+"The temperature is:"+" "+temp+" "+"The object id is:"+" "+currentid;
		return str;
	}
	public double calculateExpansion(double a)
	{
		double d= a*this.getLength()*this.getTemp();
		DecimalFormat df= new DecimalFormat("0.0000"); 
		String ds= df.format(d);
		double dl=Double.parseDouble(ds);
		return dl;
	}
	
	public double calculateForce(double y, double dl)
	{
		
		if(length <= 0)
		{
			double force= -1.0;
			return force;
		}
		else
		{
			DecimalFormat df2= new DecimalFormat("0.00");
			double f= y*area*dl/this.getLength();
			String fs= df2.format(f);
			double force= Double.parseDouble(fs);
			return force;
		}
		
	}
	
	
	
	
	
	
	
}