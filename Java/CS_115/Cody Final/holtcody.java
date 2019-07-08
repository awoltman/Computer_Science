/* add your shit here */

import java.util.*;
import java.io.*;
public class holtcody
{
public static void main( String [] args)throws IOException
	
    {
		int loop1;
		int i=0;
		int M;
		char selection;
		boolean test = true;
		boolean title = true;
		int sizeOfSelections =100;
		int [] selections = new int[sizeOfSelections];
			for(int l = 0; l < sizeOfSelections; l++){
				selections[l] = 0;
			}
			File ifile = new File("olycs115.txt");
			Scanner scan = new Scanner(ifile);
			String country = "";
			int [] NumberOfAthletes = new int [100];
			holtcodyAthlete [] athletes = new holtcodyAthlete [150];
            int subAthletes =0;
            int totalAthletes =0;	
            int a=0;
            
while(!(country.equals("END_OF_FILE")))//reads the file the division is not END_OF_FILE
		{            
        
            country = scan.next();
            //System.out.println(country);
			String [] Countries = new String [20];//since there is a max of 20 countries to be listed
			Countries[i] = country;
           
            if(scan.hasNext())
            {
                loop1 = scan.nextInt();
                
                //System.out.println(loop1);
                NumberOfAthletes [i] = loop1;
                //System.out.println(NumberOfAthletes[i]);
                for(int j = 0;j<NumberOfAthletes[i];j++)//puts the First Countries Athletes into an array
                {
                    String countryorg = country;

                    String ln = scan.next();
                    //System.out.println(ln);
                    String fn = scan.next();
                    //System.out.println(fn);
                    int age = scan.nextInt();
                    //System.out.println(age);
                    double rev = scan.nextDouble();
                    //System.out.println(rev);
                    String surf = scan.next();
                    //System.out.println(surf);
                    String sport = scan.nextLine();
                    //System.out.println(sport);
                    holtcodyAthlete athleteList = new holtcodyAthlete(country,ln,fn,age,rev,surf,sport);
                    athletes [a] =athleteList;
                    //System.out.println(athletes[j]);
                    a++;
                
			    }
            }
			i++;
            

	}
for(int s = 0; s < athletes.length; s++)
{
    //System.out.println(athletes[s]);
}
for(int t = 0; t < NumberOfAthletes.length;t++) //this loop is used to calculate the total number of Athletes and the total is stored in index 0 of array
{
    subAthletes = NumberOfAthletes[t];
    
    totalAthletes += subAthletes;
    NumberOfAthletes [0] = totalAthletes;
}


//System.out.println(athletes.length);

while(test)//this is the main menu that runs until final stats is called
		{	
			System.out.print("Enter m or M for Menu " + " or " + " Enter q or Q for Final Stats: ");
			Scanner MenuOrFinalStats = new Scanner(System.in);
			String prompt = MenuOrFinalStats.next();
			selection = prompt.charAt(0);
			switch(selection)
			{
				case 'm':
				case 'M':
					menu(selections,athletes,NumberOfAthletes);
					break;
				case 'Q':
				case 'q':
					test = false;
					finalStats(selections);
					break;
				default:
					System.out.println("not an option!!!");
					break;
			}		
		}
}
public static void menu(int [] menuOptions,holtcodyAthlete [] emppass, int [] NumberOfAthletes)
	{
			boolean menu = true;
			char function;		
			System.out.println(" Enter l or L for listall ");
			System.out.println(" Enter e or E for employeeReport: ");
			System.out.println(" Enter d or D for divisionReport: ");
			System.out.println(" Enter s or S for salaryReport: ");
			System.out.println(" Enter r or R for retirementReport: ");
			System.out.print(" Enter q or Q for Main Menu: ");
			
			while(menu){
				Scanner otherOptions = new Scanner(System.in);
			String simple = otherOptions.next();
			function = simple.charAt(0);
			switch(function)
			{
				case 'L':
				case 'l':
					listall(emppass,NumberOfAthletes);
					menuOptions[0] += 1;
					menu = false;
					break;
				case 'e':
				case 'E':
					//employeeReport(emppass,NumberOfAthletes);
					menuOptions[1] += 1;
					menu = false;
					break;
				case 'D':
				case 'd':
					//divisionReport(emppass,NumberOfAthletes);
					menuOptions[2] += 1;
					menu = false;
					break;
				case 'S':
				case 's':
					//salaryReport(emppass,NumberOfAthletes);
					menuOptions[3] += 1;
					menu = false;
					break;
				case 'r':
				case 'R':
					//retirementReport(emppass,NumberOfAthletes);
					menuOptions[4] += 1;
					menu = false;
					break;
				case 'Q':
				case 'q':
					menuOptions[5] += 1;
					menu = false;
					break;
				case 'O':
				case 'o':
					//sortList(emppass);
					menuOptions[6] +=1;
					menu = false;
					break;
				default:
					menuOptions[6] += 1;
					System.out.println("not an option!!!");
					menu = true;
					break;
			}}
		return;
		}
public static void finalStats(int [] selections)
	{
		final int numberOfChoices= 6;
		for(int i = 0; i < numberOfChoices; i++ ){
			System.out.println(selections[i]);
		}
		return;
		
	}
public static void listall(holtcodyAthlete [] emppass,int [] NumberOfAthletes)//displays all employee objects
	{
		for(int display = 0;display<NumberOfAthletes[0];display++)
		System.out.println(emppass[display]);
		return;
	}	

}