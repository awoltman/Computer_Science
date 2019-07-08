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
		Vector l = k.customerData();
		ArrayList<String> sCheese = new ArrayList<String>();
		
		FileOutputStream file;
		OutputStreamWriter filestream;
		try
		{
			file = new FileOutputStream("output.txt", true);
			filestream = new OutputStreamWriter(new BufferedOutputStream(file));
			for(int i = 0; i < alist.size(); i++)
			{
				for(int j = 0; j < l.size(); j++)
				{
					System.out.println("The Customer is: type= " + (((Customers) l.get(j)).getType() + " score = " + (((Customers) l.get(j)).getScore())));
					filestream.write("The Customer is: type= " + (((Customers) l.get(j)).getType() + " score = " + (((Customers) l.get(j)).getScore())));
				}
				sCheese = alist.get(i).costToDraw(l);
			
				for(int h = 0; h < sCheese.size(); h++)
				{
					System.out.println(sCheese.get(h));
					filestream.write(sCheese.get(h));
				}
			}
			filestream.flush();
			file.close();
		}
		catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
			
		}
		
		System.out.println("Would you like to read the file? Enter yes or no ");
		String uIn = in.next();
		if(uIn.equals("yes"))
		{
			FileInputStream phi;
			BufferedReader read; 
			try
			{
				phi = new FileInputStream("output.txt");
				read = new BufferedReader(new InputStreamReader(phi));
				String g = " ";
				int index = 0; 
				int count = 0;
				while((g= read.readLine())!=null)
				{
					System.out.println(g);
				}
				phi.close();
				read.close();
			}
			catch(IOException ioe)
			{
				System.out.println(ioe.getMessage());
			}
		}
		
	}
}
