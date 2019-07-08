import java.util.Vector;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class  Customers implements Serializable
{
	
	public String type=" ";
	public int score=0;

	public void setType(String ty)
	{
		type=ty;
	}

	public void setScore(int sc)
    {
		score=sc;
	}

	public String getType()
	{
		return type;
	}

	public int getScore()
	{
		return score;
	}
	
	public Vector customerData()
	{
		String as = "";
		Vector v=new Vector();
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the 2 pieces of information for type and score for a customer object separated by space or type done ");
		while(!as.equals("done"))
		{
			as = in.nextLine();
			if(!as.equals("done"))
			{
				StringTokenizer stok = new StringTokenizer(as);
				String as1 = stok.nextToken();
				Customers c1=new Customers();
				c1.setType(as1);
				String as2 = stok.nextToken();
				int score = Integer.parseInt(as2);
				c1.setScore(score);
				v.add(c1);
				System.out.println("Please enter the 2 pieces of information for type and score for a customer object separated by space or type done ");
			}
		}
		return v;
	}
}
