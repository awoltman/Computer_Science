import java.io.*;
public class DrawShapes implements Serializable 
{
	String name=" ";
	int color=0;
	String front=" ";
	double pencilWidth=0.00;
	public double cost;
	public DrawShapes()
	{
		name="anyname";
		color=0;
		front="anyfront";
		pencilWidth=0.0;
	}
	public DrawShapes(String na, int co, String fr, double pe)
	{
		name=na;
		color=co;
		front=fr;
		pencilWidth=pe;
	}
	public String getName()
	{
		return name;
	}
	public int getColor()
	{
		return color;
	}
	public String getFront()
	{
		return front;
		
	}
	public double getWidth()
	{
		return pencilWidth;
	}
	public void setName(String na1)
	{
		name=na1;
	}
	public void setColor(int co1)
	{
		color=co1;
	}
	public void setFront(String fr1)
	{
		front=fr1;
	}
	public void setWidth(double pe1)
	{
		pencilWidth=pe1;
	}
	public boolean eqauls(DrawShapes dr)
	{
		boolean flag=false;
		if(dr.getName()==this.getName()&&dr.getColor()==this.getColor())
			flag=true;
		return flag;
	}
	public String toString()
	{
		String out="The name of this shape is "+name+"The front of this shape is "+front+"the color of this shape is "+color+"the width of this shape is "+pencilWidth;
		return out;
	}
	
	public double costtoDraw(boolean check)
	{
		cost=0.00;
		if(check=true)
			cost=0.00;
		else 
			cost=pencilWidth*color*100;
		return cost;
	}
	
}