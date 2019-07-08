package andrew;
import andrew.woltman.*;
import java.util.*;
import java.io.*;
public class RodClient
{
	public static void main(String[]args)
	{
		
		String readyOrNot = args[0];
		if(readyOrNot.equals("textready"))
		{
		try{
		File ofile = new File("coefficients.txt");
		Scanner scan = new Scanner(ofile);
		int counter = 0;
		
		while(scan.hasNextLine())
		{
			scan.nextLine();
			counter++;
		}
		Rod[] saved = new Rod[counter];
		double [] expantion = new double[counter];
		double [] young = new double[counter];
		double [] expantionLength= new double[counter];
		double [] youngForce = new double[counter];
		Scanner scan1 = new Scanner(ofile);
		for(int i =0; i < saved.length; i++)
		{
			String line = scan1.nextLine();
			StringTokenizer stk = new StringTokenizer(line, ",");
			String first = stk.nextToken();
			MaterialCategories newMC = MaterialCategories.valueOf(first);
			
			String second = stk.nextToken();
			String third = stk.nextToken();
			double are = Double.parseDouble(third);
			String forth = stk.nextToken();
			double len = Double.parseDouble(forth);
			String fifth = stk.nextToken();
			double a = Double.parseDouble(fifth);
			String sixth = stk.nextToken();
			double Y = Double.parseDouble(sixth);
			Rod newRod = new Rod(second, are, len);
			newRod.setMaterialCategory(newMC);
			saved[i] = newRod;
			expantion[i] =  a;
			young[i] = Y;
		}
		for(int j = 0; j < counter ; j++)
		{
			System.out.println("Please enter the temperature change for:"+ saved[j].getMaterial());
			Scanner scan2 = new Scanner(System.in);
			double dt = scan2.nextDouble();
			System.out.println("________________FIRST OUTPUT REQUIRED_________________");
			Rod dod = new Rod(saved[j].getMaterial(),saved[j].getArea(),saved[j].getLength());
			System.out.println(expantion[j]);
			double expan = dod.calculateExpansion(expantion[j], dt);
			double force = dod.calculateForce(young[j], expan);
			System.out.println("The expansion is:"+" "+ expan);
			System.out.println("The force is:"+" "+force);
			expantionLength[j] = expan;
			youngForce[j] = force;
		}
		double [] sortedForce = selectionSort(youngForce);
		System.out.println(sortedForce.length);
		System.out.println("_______SECOND OUTPUT REQUIRED_____");
		System.out.println("The greatest force required is:"+" "+sortedForce[0]);
		
		for(int l = 0; l < counter; l++)
		{
			if(youngForce[l]==sortedForce[0])
			{
				System.out.println(saved[l].toString());
			}
		}
		
		System.out.println("--------THIRD OUTPUT REQUIRED________");
		for(int k = 0; k < counter; k++)
		{
			
			System.out.println(saved[k].toString());
		}
		}
		catch(IOException ioe)
		{
			System.out.println("Something went wrong");
		}
	}
	else
		System.out.println("I cant provide data unless the text file is ready!");
}
	public static double[] selectionSort(double[] unsorted)
	{
		double[] sorted = new double[unsorted.length];
		for(int i= 0; i < unsorted.length; i++)
		{
			sorted[i]= unsorted[i];
		}
		int subarraylength = 0;
		int index = 0;
		for(int j = 0; j <= sorted.length-1 ; j++)
		{
			subarraylength= sorted.length-1;
			index = 0;
			for(int k = 0; k<subarraylength; k++)
			{
				if(sorted[k] > sorted[index])
				{
					index = k;
				}
			}
			double temp = sorted[index];
			sorted[index] = sorted[sorted.length-j-1];
			sorted[sorted.length-j-1]=temp;
		}
		return sorted;
	}
	
}