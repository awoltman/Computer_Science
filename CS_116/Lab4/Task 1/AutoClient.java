package main;
import java.util.*;
import java.io.*;
import java.util.*;
import java.text.*;
import main.*;
import main.service.*;
import main.service.enums.*;

//enter import statements for other needed classes

public class AutoClient
{
	public static void main(String[] args) 
	{
		//Add code as you decide that itis required
        AutoClient bob = new AutoClient();
        Auto[] niceCars = bob.carData();
        ArrayList<Auto> namesOfCars = new ArrayList<Auto>();
        for(int i = 0; i < niceCars.length;i++)
        {
            namesOfCars.add(niceCars[i]);
        }
        AutoStore[] storeArray = bob.storeData();
        for(int i =0; i < storeArray.length;i++)
        {
            Auto bob1 =(Auto)namesOfCars.get(i);
            bob1.setAutoStore(storeArray[i]);
        }
        
		
		System.out.println("-------------FIRST OUTPUT ----------------");
		DecimalFormat dF = new DecimalFormat("0.0");
        for(int i =0; i < namesOfCars.size();i++)
        {
            System.out.println("The price of the car with id = " + namesOfCars.get(i).getCurrentID() + " is : " + dF.format(namesOfCars.get(i).getAutoStore().getSale()) 
								+ " The sale status is: " + namesOfCars.get(i).getSoldORnot());
        }
        System.out.println(" ");
		// ADD CODE
		// transfer objects from array to array list
		//Get the Store information so that the AutoStore instance variable reference of Auto can be set to a specific AutoStore object 

		//Display contents of array list using the new for loop. Display the id of each Auto object, the sale price a sdefined in the AutoStore class and teh status (is it sold?-right now none is sold)
		
		System.out.println("-------------SECOND OUTPUT----------------");
	    
        
        double [][][] trD = bob.storeSales(namesOfCars);
		// ADD CODE
		//invoke the method for the triple array an dformat the display to look as table provided in eth document/
		System.out.print("\tMON\t\tTUE\t\tWED\t\tTHU\t\tFRI\t\tSAT\n\n");
        
        for(int i = 0; i < trD.length; i++)
		{
			System.out.print("ID" + (i+1) + "\n\n");
			for(int j = 0; j < trD[i].length; j++)
			{
				if(j == 0)
					System.out.print("Week 1:\t");
				else
					System.out.print("Week 2:\t");
				for(int k = 0; k < trD[i][j].length; k++)
				{
					if(k < trD[i][j].length - 1)
						System.out.print(dF.format(trD[i][j][k]) + "\t\t");
					else
						System.out.print(dF.format(trD[i][j][k]) + "\n\n");
				}
			}
		}
        
        System.out.println(" ");
		System.out.println("-------------THIRD OUTPUT----------------");
	     // ADD CODE
		 //Repeat the  for loop through the array list but this time the status for each auto should had been changed to slod.
		 //AND THE ARRAY LIST IS SORTED BY ACCELERATION.
         ArrayList<Auto> newAutoArrayList = bob.sortAutoList(namesOfCars);
		for(int i = 0; i < newAutoArrayList.size(); i++)
		{
			newAutoArrayList.get(i).setSoldORnot(true);
			System.out.println(newAutoArrayList.get(i).toString());
		}
	}
	

	///////////////END OF MAIN METHOD //////////////////////////////////////////

	public Auto[] carData()
	{
		
		Auto [] veharray=null;
		//double[] varray=null;
		//double[] darray=null;
		//double[] farray=null;
		int count=0;
		try
		{
			File file =new File("data.txt");
			Scanner scan=new Scanner(file);
			CarType vehe=null;
			while(scan.hasNextLine())
			{
				scan.nextLine();
				count++;
			}

			veharray=new Auto[count];
			//varray=new double[count];
			//darray=new double[count];
			//farray=new double[count];
			Scanner scan1=new Scanner(file);
			int index=0;
			while(scan1.hasNextLine())
			{
				String line=scan1.nextLine();
				StringTokenizer strtok=new StringTokenizer(line,"#");
				String tok1=strtok.nextToken();
				
				double a=Double.parseDouble(tok1);
				String tok2=strtok.nextToken();

				int t=Integer.parseInt(tok2);
				String tok3=strtok.nextToken();

				String tok4=strtok.nextToken();

				if(tok4.equals("Type1"))
				{
					
					vehe=CarType.Type1;
				}
				else if(tok4.equals("Type2"))
				{
					
					vehe=CarType.Type2;
				}
				else if(tok4.equals("Type3"))
				{
				    vehe=CarType.Type3;
				}
				else if(tok4.equals("Type4"))
				{
					vehe = CarType.Type4;
				}

				//advance the tokenizer two more times but disregard teh data because they are not used in Auto class
                String getRid = strtok.nextToken();
                String getRid1 = strtok.nextToken();
				Auto v=new Auto(a,t,tok3,vehe);
				veharray[index]=v;
				
				index++;
			}
		}//end of try
		catch(IOException ioe)
		{
		   System.out.println("Something is wrong");
		}
		return veharray;
	}

	public static AutoStore[] storeData()
	{
		AutoStore[] dealarray=null;
		Stores d=null;
		int count=0;
		try
		{
			File file =new File("data.txt");
			Scanner scan=new Scanner(file);
			CarType vehe=null;
			while(scan.hasNextLine())
			{
				scan.nextLine();
				count++;
			}

			dealarray=new AutoStore[count];
			
			Scanner scan1=new Scanner(file);
			int index=0;
			while(scan1.hasNextLine())
			{
				//add code to capture the required data to create AutoStore objects and save them in an array.
                String line1 = scan1.nextLine();
				StringTokenizer stok = new StringTokenizer(line1, "#");
				stok.nextToken();
				stok.nextToken();
				stok.nextToken();
				stok.nextToken();
				String storeType = stok.nextToken();
				
				
				String cost = stok.nextToken();
				double price = Double.parseDouble(cost);
				AutoStore stor1 = new AutoStore(price);
				if(storeType.equals("ID1"))
				{
					stor1.setStoreType(Stores.ID1);
				}
				else if(storeType.equals("ID2"))
					stor1.setStoreType(Stores.ID2);
				else if(storeType.equals("ID3"))
					stor1.setStoreType(Stores.ID3);
				else if(storeType.equals("ID4"))
					stor1.setStoreType(Stores.ID4);
				else
					stor1.setStoreType(Stores.ID5);
				
				dealarray[index] = stor1;
				
				index++;
			
			}
		}
		catch(IOException ioe)
		{
		   System.out.println("Something is wrong");
		}
		
		
		return dealarray;
	}
	public ArrayList<Auto> sortAutoList(ArrayList<Auto> ald)
	{
        ArrayList<Auto> sortedArrayList = new ArrayList<Auto>();
		for(int i = 0; i < ald.size(); i++)
		{
			sortedArrayList.add(ald.get(i));
		}
		//ADD CODE TO SORT AN ARRAY LIST OF AUTO OBJECTS ACCOPRDING TO THE PRICE AND RETURN THE SORTED ARRAY LIST OBJECT
		int index = 0;
		int count = 0;
		Auto temp;
		int max;
		int subArrayLength = 0;
		for(int j = 0; j < sortedArrayList.size(); j++)
		{
			subArrayLength = sortedArrayList.size() - j;
			index = 0;
			for(int k = 1; k < subArrayLength; k++)
			{
				//Find smallest
				if(sortedArrayList.get(k).getAutoStore().getSale() > sortedArrayList.get(index).getAutoStore().getSale())
				{
					index = k;
				}
			}
			//Now swap elements
			temp = sortedArrayList.get(index);
			sortedArrayList.set(index, sortedArrayList.get(sortedArrayList.size()-j-1));
			sortedArrayList.set(sortedArrayList.size()-j-1, temp);
		}
		return sortedArrayList;
		//ADD CODE TO SORT AN ARRAY LIST OF AUTO OBJECTS ACCOPRDING TO THE ACCELERATION AND RETURN THE SORTED ARRAY LIST OBJECT
		// MAKE SURE THAT THE ARGUMENT ARRAY LIST HAS FIRST BEEN TRANSFERRED TO A NEW ARRAY LIST OBJECT.
	}

	

	public double[][][] storeSales(ArrayList<Auto> al)
	{
        double sales[][][] = new double[5][2][6];
		int countw1 = 0;
		int countw2 = 0;
		for(int i = 0; i < sales.length; i++)
		{
			for(int j = 0; j < sales[i].length; j++)
			{
				for(int z = 0; z < sales[i][j].length; z++)
				{
					if(((i%2) == 0) && (z == 0 || z == 2 || z ==4))
					{
						if(j==0)
						{
							sales[i][j][z] = sales[i][j][z] + al.get(countw1).getAutoStore().getSale();
							al.get(countw1).setSoldORnot(true);
							countw1++;
							countw2 = countw1;
						}
						else
						{
							sales[i][j][z]= sales[i][j][z] + al.get(countw2 + 12).getAutoStore().getSale();
							al.get(countw2 + 12).setSoldORnot(true);
							countw2++;
						}
						
					}
					else if(((i%2) == 1)&&(z==1||z==3||z==5))
					{
						if(j==0)
						{
							sales[i][j][z] += al.get(countw1).getAutoStore().getSale();
							al.get(countw1).setSoldORnot(true);
							countw1++;
							countw2 = countw1;
						}
						else
						{
							sales[i][j][z] += al.get(countw2+12).getAutoStore().getSale();
							al.get(countw2+12).setSoldORnot(true);
							countw2++;
						}
					}
					
				}
			}
		}
		return sales;
    }

		// ADD CODE
	}
