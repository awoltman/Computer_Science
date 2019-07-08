package recursion;
import java.util.*;
import java.io.*;
import exception.*;
public class Combinations
{
	public static void main(String[]args)
	{
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter the combination numbers with the population number first followed by the group number: ");
		String numbers=scan.nextLine();
		int answer=0;
		try
		{
		while(!numbers.equals("-1"))
		{
		StringTokenizer stk=new StringTokenizer(numbers," ");
		String n1=stk.nextToken();
		int nu1=Integer.parseInt(n1);
		String n2=stk.nextToken();
		int nu2=Integer.parseInt(n2);
		Combinations c1=new Combinations();
		
		
		if(nu2>=nu1)
			throw new PopulationsGreaterThanGroup();
		
		else
		answer=c1.calculateCombinations(nu1,nu2);
		System.out.println("The combination of this set of number is : "+answer);
		String write="The number of combination for"+nu1+"and "+nu2+" is: "+answer;
		String filename=" output.txt";
		FileOutputStream file = new FileOutputStream(filename);
		OutputStreamWriter filestream= new OutputStreamWriter(file);
		filestream.write(write);
		System.out.println("Please enter the combination numbers with the population number first followed by the group number: ");
		numbers=scan.nextLine();
		filestream.close();
		
		}
		
		}
		
		catch(PopulationsGreaterThanGroup po)
		{
			System.out.println(po.getMessage());
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		System.out.println("Please enter the combination numbers with the population number first followed by the group number: ");
		numbers=scan.nextLine();
		
		
	
		
	}
	public static int calculateCombinations(int n, int p)
	{
		if(p==0)
			return 1;
		else if(n==p)
			return 1;
		else 
			return(calculateCombinations(n-1,p-1)+calculateCombinations(n-1,p));
		
	}
	
}