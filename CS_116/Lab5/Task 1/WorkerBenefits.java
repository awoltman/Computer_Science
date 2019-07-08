package Client;
import Client.Services.Worker;
import Client.Services.Engineer;
import Client.Services.AdministrativePersonnel;
import Client.Services.Management;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;
import Client.Services.Engineer;
import java.util.Scanner;
import Client.Services.Enums.Jobs;

public class WorkerBenefits
{
	
	//Not sure what it means by comment out the main method, so if need be, delete it.
	/*public static void main(String[] args)
	{
		WorkerBenefits thing = new WorkerBenefits();
		ArrayList<Worker> yayWork = thing.listOfWorkers();
		thing.displayData(yayWork);
	}
	*/
	
	public ArrayList<Worker>  listOfWorkers()
	{
		Worker[] working = null;
		try
		{
			File file = new File("workers.txt");
			Scanner scan = new Scanner(file);
			int count = 0;
			while(scan.hasNextLine())
			{
				String line = scan.nextLine();
				count++;
			}
			working = new Worker[count];
			int index = 0;
			Scanner scan1 = new Scanner(file);
			while(scan1.hasNextLine())
			{
				String line1 = scan1.nextLine();
				StringTokenizer stok2 = new StringTokenizer(line1, ",");
				String work = stok2.nextToken();
				Jobs j = Jobs.NONE;
				if(work.equals("ELECTRICAL_ENGINEER"))
				{
					j = Jobs.ELECTRICAL_ENGINEER;
				}
				else if(work.equals("ENGINEERING_MANAGER"))
				{
					j = Jobs.ENGINEERING_MANAGER;
				}
				else if(work.equals("ADMISTRATIVE_MANAGER"))
				{
					j = Jobs.ADMISTRATIVE_MANAGER;
				}
				else if(work.equals("ADMINISTRATIVE_SECRETARY"))
				{
					j = Jobs.ADMINISTRATIVE_SECRETARY;
				}
				else if(work.equals("MECHANICAL_ENGINEER"))
				{
					j = Jobs.MECHANICAL_ENGINEER;
				}
				else
				{
					j = Jobs.ADMINISTRATIVE_ASSISTANT;
				}
				String name = stok2.nextToken();
				String social = stok2.nextToken();
				int socSec = Integer.parseInt(social);
				
				String exp = stok2.nextToken();
				int expW = Integer.parseInt(exp);
				
				String last = stok2.nextToken();
				double benefits = Double.parseDouble(last);
				
				double hours = 0;
				if(j.equals(Jobs.ENGINEERING_MANAGER) || j.equals(Jobs.ADMISTRATIVE_MANAGER) || j.equals(Jobs.ADMINISTRATIVE_SECRETARY) || j.equals(Jobs.ADMINISTRATIVE_ASSISTANT))
				{
					String hour = stok2.nextToken();
					hours = Double.parseDouble(hour);
				}
			
				if(j.equals(Jobs.ELECTRICAL_ENGINEER) || j.equals(Jobs.MECHANICAL_ENGINEER))
				{
					working[index] = new Engineer(name, socSec, expW, j, benefits);
				}
				else if(j.equals(Jobs.ENGINEERING_MANAGER) || j.equals(Jobs.ADMISTRATIVE_MANAGER))
				{
					working[index] = new Management(name, socSec, expW, j, benefits, hours);
				}
				else
				{
					working[index] = new AdministrativePersonnel(name, socSec, expW, j, benefits, hours);
				}
				index++;
			}
			
			
		}
		catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
		
		ArrayList<Worker> arr = new ArrayList<Worker>();
		for(int i = 0; i < working.length; i++)
		{
			arr.add(working[i]);
		}
		return arr;
	}
	
	
	public void displayData(ArrayList<Worker> ale)
	{
		for(int i = 0; i < ale.size(); i++)
		{
			System.out.print("The benefit is " + ale.get(i).benefitsCalculation(ale.get(i).getJob()) + " " + ale.get(i).toString()+"\n");
		}
		
	}
	
	public double totalBenefits()
	{
		ArrayList<Worker> arr1 = listOfWorkers();
		double x = 0;
		for(int i = 0; i < arr1.size(); i++)
		{
			x += arr1.get(i).benefitsCalculation(arr1.get(i).getJob());
		}
		return x;
		
	}

}





