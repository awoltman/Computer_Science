import java.util.*;
import java.io.*;

public class FigureCost
{
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		ArrayList<Figure> alist = new ArrayList<Figure>();
		String f = "";
		
		while(!f.equals("done"))
		{
			System.out.println("Please enter the shape the length(or radius) and the asked (area or volume) separated by space or type done ");
			f = in.nextLine();
			if(!f.equals("done"))
			{
				StringTokenizer stok = new StringTokenizer(f);
				String lmnop = stok.nextToken();
				//-------------------------------
				String f2 = stok.nextToken();
				double h = Double.parseDouble(f2);
				//--------------------------------
				String f3 = stok.nextToken();
				Figure l = null;
				if(lmnop.equals("sphere"))
				{
					l = new Sphere(lmnop, h, f3);
				}
				else if(lmnop.equals("cube"))
				{
					l = new Cube(lmnop, h, f3);
				}
				alist.add(l);
			}
		}
		
		Customers k = new Customers();
		ArrayList<String> sCheese = new ArrayList<String>();
		Vector l = k.customerData();
		
		String filename = "figures.ser";
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try
		{
			fos = new FileOutputStream(filename, true);
			out = new ObjectOutputStream(fos);
			for(Figure z:alist)
			{
				sCheese.addAll(z.costToDraw(l));
				out.writeObject(z);
			}
			out.close();
			fos.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		
		
		String filename1 = "customers.ser";
		FileOutputStream fos1 = null;
		ObjectOutputStream out1 = null;
		try
		{
			fos1 = new FileOutputStream(filename1, true);
			out1 = new ObjectOutputStream(fos1);
			for(int i = 0; i < l.size(); i++)
			{
				out1.writeObject(l.get(i));	
			}
			out1.close();
			fos1.close();
		}
		catch(IOException ioe1)
		{
			ioe1.printStackTrace();
		}
		
		String filename2 = "cost.ser";
		FileOutputStream fos2 = null;
		ObjectOutputStream out2 = null;
		try
		{
			fos2 = new FileOutputStream(filename2, true);
			out2 = new ObjectOutputStream(fos2);
            System.out.println(sCheese.size());
			
			for(String jk: sCheese)
			{
				out2.writeObject(jk);
                System.out.println(jk);
                System.out.println("hello");
			}
			out2.flush();
			fos2.flush();
		}
		catch(IOException ioe2)
		{
			ioe2.printStackTrace();
		}
		
		System.out.println("If you want the file figures.ser read type the word read otherwise type anything else to stop the program");
		String uIn = in.next();
		if(uIn.equals("read"))
		{
			try
			{
				FileInputStream fIn = new FileInputStream("figures.ser");
				ObjectInputStream o = new ObjectInputStream(fIn);
				while(true)
				{
					Figure something = (Figure)o.readObject();
					System.out.println(something.toString()+"\n");
                    
				}		
			}
			catch(ClassNotFoundException fnf)
			{
				System.out.println("The file was not found");
			}
			catch(IOException ioe)
			{
				System.out.println(ioe.getMessage());
			}
			
		}
		else
		{
			System.exit(0);
		}
		
		System.out.println("If you want the file customers.ser read type the word read otherwise type anything else to stop the program");
		uIn = in.next();
		if(uIn.equals("read"))
		{
			try
			{
				FileInputStream fIn1 = new FileInputStream("Customers.ser");
				ObjectInputStream oIn1 = new ObjectInputStream(fIn1);
				while(true)
				{
					Customers c = (Customers) oIn1.readObject();
					System.out.println("type= " + c.getType()+" score= "+c.getScore());
				}
			}
			catch(ClassNotFoundException fnf)
			{
				System.out.println("The file was not found");
			}
			catch(IOException ioe)
			{
				System.out.println(ioe.getMessage());
			}
		}
		else
		{
			System.exit(0);
		}
		
		System.out.println("If you want the file cost.ser read type the word read otherwise type anything else to stop the program");
		uIn = in.next();
		if(uIn.equals("read"))
		{
			try
			{
                
				FileInputStream fIn2 = new FileInputStream("cost.ser");
				ObjectInputStream oIn2 = new ObjectInputStream(fIn2);
                try{
				while(true)
				{
                    
                    String s = (String)oIn2.readObject();
                    System.out.println(s.toString());
				}
            }
                catch(EOFException eof)
                {
                    System.out.println(eof.getMessage());
                }
			catch(ClassNotFoundException fnf)
			{
				System.out.println("The file was not found");
			}
			finally
            {
                oIn2.close();
            }
        }
            catch(IOException ioe)
            {
                System.out.println(ioe.getMessage());
            }
		
	}
}}