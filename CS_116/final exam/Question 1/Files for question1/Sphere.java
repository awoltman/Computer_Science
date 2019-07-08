public class Sphere extends DrawShapes implements VolumeInterface
{
	double radius;
	public Sphere()
	{
		super();
		radius = 0.0;
	}
	public Sphere(String na, int co, String fr, double pe, double si)
	{
		super(na,co,fr,pe);
		radius=si;
		
	}
	public double getRadius()
	{
		return radius;
	}
	public void setRadius(double si1)
	{
		radius=si1;
	}
	public String toString()
	{
		String out="The name of this shape is "+name+"The front of this shape is "+front+"the color of this shape is "+color+"the width of this shape is "+pencilWidth+"And the leangth of the radius is"+ radius;
		return out;
	}
	public double calculateArea()
	{
		double area=(4.0/3.0)*Math.PI*Math.pow(radius,3);
		return area;
	}
	public double calculateVolume()
	{
		double volume=4.0*Math.PI*Math.pow(radius,2);
		return volume;
	}
	public double costtoDraw(boolean check)
	{
		if(check=true)
		{
			cost=0.00;
		}
		else if(check=false)
		{
		     cost=pencilWidth*color*100+100;
		}
		else
		{
			cost=pencilWidth*color*100;
		}
		
		return cost;
	}
}