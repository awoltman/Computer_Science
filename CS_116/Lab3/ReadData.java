package andrew.woltman;
import andrew.RodClient;
import andrew.woltman.Rod;
import java.util.*;
import java.io.*;
import java.text.*;
public class ReadData
{
    public double[] expantion;
    public double[] young;
    public ReadData()
    {
        expantion = null;
        young = null;
    }
    public double[] getExpan()
    {
        return expantion;
    }
    public double[] getYoung()
    {
        return young;
    }
    public void setExpan(double[] em)
    {
        em = expantion;
    }
    public void setYoung(double[] you)
    {
        you = young;
    }
	public Vector vectorData(String filename)
	{
        Vector v = new Vector();
        try{
        int counter = 0;
		File ofile = new File(filename);
		Scanner scan = new Scanner(ofile);
		while(scan.hasNextLine())
		{
			scan.nextLine();
			counter++;
		}
        
		expantion= new double[counter];
		young= new double[counter];
		Scanner scan1 = new Scanner(ofile);
		for(int i =0; i < counter; i++)
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
            String seventh = stk.nextToken();
            int temp = Integer.parseInt(seventh);
			Rod newRod = new Rod(temp,second, are, len);
			newRod.setMaterialCategory(newMC);
            v.add(newRod);
			expantion[i] =  a;
			young[i] = Y;
	   }
            ReadData m = new ReadData();
            m.setExpan(expantion);
            m.setYoung(young);
        }
        catch(IOException ioe)
        {
            System.out.println("Something went wrong!!");
        }
        return v;
    }
    public static Vector  sortVector(Vector unsorted)
	{
        Vector sorted= unsorted;
		int subarraylength = 0;
		int index = 0;
		for(int j = 0; j < sorted.size()-1 ; j++)
		{
			index = j;
			for(int k = j+1; k<sorted.size(); k++)
			{
                Object o2 = sorted.elementAt(k);
                Rod newone = (Rod)o2;
                Object o3 = sorted.get(index);
                Rod newerone = (Rod)o3;
				if(newone.getTemp() < newerone.getTemp())
                {
					index = k;
				}
			}
            
            Rod smaller = (Rod)sorted.get(index);
            sorted.set(index,sorted.get(j));
            sorted.set(j, smaller);
		}

		return sorted;
	}
    public int searchVector(Vector sv,int key)
    {
        int start = 0;
        int end = sv.size()-1;
        while(end >= start)
        {
            int middle = (start+end)/2;
            Rod middleRod = (Rod)sv.get(middle);
            if(middleRod.getTemp() == key)
            {
                return middle;
            }
            else if(middleRod.getTemp() > key)
            {
                end = middle-1;
            }
            else
            {
                start = middle+1;
            }
        }
        return -1;
    } 
}