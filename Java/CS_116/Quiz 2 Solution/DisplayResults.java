//George Koutsogiannakis
package Compiled;
import java.util.*;
import java.io.*;
public class DisplayResults
{
	public static void main(String[] args) 
	{
		SalesCalculations sales=new SalesCalculations();
		ArrayList<Manufacturing> product=sales.dataReader();
		
		for(Manufacturing p: product)
		{
		   System.out.println(p.toString());
		   try
		   {
				
		   		 System.out.println("For product:"+" "+p.getProductName()+" "+"The unit price is:"+" "+p.unitPrice());
		   }
		   catch (HighPriceException wr)
		   {
				System.out.println("I threw the exception in the client");
		   }
		  
		   
		}
		System.out.println("***********************************************************"+"\n");
		//System.out.println("0");
		double compsales=sales.totalConsumerSales(product);
		//System.out.println("1");
		double telsales=sales.totalIndustrialSales(product);
		//System.out.println("2");
		System.out.println("The total consumer sales is:"+" "+compsales);
		System.out.println("The total industrial sales is:"+" "+telsales);
		System.out.println("The total sales is"+" "+(compsales+telsales));

		
		  
	}
}
