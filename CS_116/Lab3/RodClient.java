package andrew;
import andrew.woltman.ReadData;
import andrew.woltman.Rod;
import andrew.woltman.MaterialCategories;
import java.util.*;
import java.io.*;
public class RodClient
{
	public static void main(String[]args)
	{
		
		String fileName = args[0];
		if(fileName.equals("coefficients.txt"))
		{
       ReadData m = new ReadData();
       Vector newRods = m.vectorData(fileName);
       Vector sortedRods = m.sortVector(newRods);
       double[] expantion = m.getExpan();
       double[] young = m.getYoung();
       for(int i =newRods.size()-1; i>=0;i--)
       {
           
           Rod dod = (Rod)sortedRods.get(i);
           System.out.println(sortedRods.get(i));
           double bob = dod.calculateExpansion(expantion[dod.getCurrentID()-1]);
           System.out.println("The expantion is:"+" "+bob);
           double bob2 = dod.calculateForce(young[dod.getCurrentID()-1],bob);
           System.out.println("The force is:"+" "+bob2);
           System.out.println(" ");
       }
       System.out.println("//FIND TEMPERATURE OUTPUT");
       int key =89;
       int temp = m.searchVector(sortedRods,key);
       System.out.println(temp);
       if(temp != (-1))
       {
       System.out.println("The object was found and is:"+" "+sortedRods.get(temp));
       }
       System.out.println(" ");
       int key2 =156;
       int temp2 = m.searchVector(sortedRods,key2);
       if(temp2 != -1)
       {
       System.out.println("The current id with temp "+key2+" is:"+temp2);
       }
       else
       {
           System.out.println("No Rod has a temp of:"+" "+key2);
       }
       
	}
	else
		System.out.println("I cant provide data unless the text file is ready!");
    }	
}