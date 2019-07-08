public class Cube extends DrawShapes
{
	int side=0;
	public Cube()
	{
		super();		
	}
	public Cube(String na, int co, String fr, double pe, int si)
	{
		super(na,co,fr,pe);
		side=si;
		
	}
	public int getSide()
	{
		return side;
	}
	public void setSide(int si1)
	{
		side=si1;
	}
	public String toString()
	{
		String out="The name of this shape is "+name+"The front of this shape is "+front+"the color of this shape is "+color+"the width of this shape is "+pencilWidth+"And the leangth of the side is"+ side;
		return out;
	}
	public double calculateArea()
	{
		double area=Math.pow(this.getSide(),3);
		return area;
	}
	public double calculateVolume()
	{
		double volume=6.0*Math.pow(this.getSide(),2);
		return volume;
	}
}