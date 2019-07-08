import java.util.*;
import java.io.*;
public class TestShapes
{
	public static void main(String[]args)
	{
		ArrayList<DrawShapes> list=new ArrayList<DrawShapes>();
		DrawShapes d1=new DrawShapes();
		Cube cu1=new Cube("Cube",100,"Time new Roman",2.3,10);
		d1=cu1;
		list.add(d1);
		Sphere sp1=new Sphere("Sphere",144,"Calibri",2.3,10.0);
		d1=sp1;
		list.add(d1);
		Cube cu2=new Cube("Cube",200,"Courier",3.0,6);
		d1=cu2;
		list.add(d1);
		for(int i=0; i<list.size(); i++)
		{
			DrawShapes d2=new DrawShapes();
			d2=list.get(i);
			System.out.println(d2.toString());
			/*if(d2.getName().equals("Cube"))
			{
				Cube cu = new Cube();
				cu=(Cube)d2;
				double area=cu.calculateArea();
				double volume=cu.calculateVolume();
				System.out.println("Shape with the id "+i+"Has the area of: "+area+"and the volume of "+volume);
			}
			else if(d2.getName().equals("Sphere"))
			{
				Sphere sp = new Sphere();
				sp=(Sphere)d2;
				double area=cu.calculateArea();
				double volume=cu.calculateVolume();
				System.out.println("Shape with the id "+i+"Has the area of: "+area+"and the volume of "+volume);
			}*/
		}
		Scanner scan=new Scanner(System.in);
		System.out.println("Would you like to write and read the data? ");
		String option=scan.nextLine();
		if(option.equals("yes"))
		{
			FileOutputStream fos=null;
			ObjectOutputStream out=null;
			try
			{

			fos=new FileOutputStream("data.ser");
			out=new ObjectOutputStream(fos);
			for(int y=0; y<list.size(); y++)
			{
				DrawShapes draw=list.get(y);
				//System.out.println(draw.toString());
			    out.writeObject(draw);
			}
			out.close();
			}
			catch(IOException ioe)
			{
			ioe.printStackTrace();
			}
		}
		else 
			System.exit(0);
		
		System.out.println("Would you like to read this file?");
		String option2=scan.nextLine();
		if(option2.equals("Read"))
		{
				ObjectInputStream in=null;
				FileInputStream fis=null;
					
				try
				{
					
					//fis=new FileInputStream("data.ser");
					//in=new ObjectInputStream(fis);
					//DrawShapes sread = new DrawShapes();
					try
					{
						fis=new FileInputStream("data.ser");
					in=new ObjectInputStream(fis);
					DrawShapes sread = new DrawShapes();
							while(true)
							{
										sread=(DrawShapes)in.readObject();
										//double cost=sread.costtoDraw(true);
										//System.out.println(sread.toString()+"and the cost to draw is "+cost);
							}		
						
					}
					catch(EOFException eof) 
					{
							System.out.println(eof.getMessage());
					}	
				}
				catch(IOException ioe)
				{
					System.out.println(ioe.getMessage());
				}
		}
		else 
			System.exit(0);
		
		
	}
}