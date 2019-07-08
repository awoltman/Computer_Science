/*Andrew Woltman
Lab Section 6
A20350925

This project was created to read a file of  employees and their attributes. We had to use what we  know about the format of the file to create
methods that use the data read in from the file allows the user to search things like, who is active, who is retired and print their names out
as well as there pension, search for specific employees and print there details, the average salary of a certain division. The most important
thing that this taught was to create a user interface. 
*/

import java.util.*;
import java.io.*;
public class woltmanandrew
{
public static void main( String [] args)throws IOException
	{
		int loops1;
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
			String line = scan.nextLine();
			int [] numberOfAthletes = new int [100];
			codyHoltAthlete [] employees = new codyHoltAthlete [150];	
		while(!(line.equals("END_OF_FILE")))//reads the file the division is not END_OF_FILE
		{
			String titleName = line;
			String [] Divitiontitles = new String [50];
			Divitiontitles[i] = titleName;
			loops1 = scan.nextInt();
			NumberOfEmployees [i] =loops1;
			//System.out.println(NumberOfEmployees[i]);
			for(int j = 0;j<NumberOfEmployees[i];j++)//puts the Occupational employees into an array of objects
			{
				String division = titleName;
				String fn = scan.next();
				String ln = scan.next();
				int yos = scan.nextInt();
				double Sal = scan.nextDouble();
				String stat = scan.next();
				String section = scan.nextLine();
				double pen;
				if(stat.equals("r")){
				pen = (Sal*yos*.02);
				}
				else{
				pen = 0.0;
				}
				woltmanandrewEmployee employeeList = new woltmanandrewEmployee(division,fn,ln,yos,Sal,stat,section,pen);
				employees [j] =employeeList;
			}
			i++;
			titleName = scan.nextLine();
			int loops2 = scan.nextInt();
			int loopTotal1 = loops1+loops2;
			NumberOfEmployees[i] = loopTotal1;
			//System.out.println(NumberOfEmployees[i]);
			for(int j = NumberOfEmployees[0];j<NumberOfEmployees[1];j++)//adds the Management employees to the end of the array
			{
				String division = titleName;
				String fn = scan.next();
				String ln = scan.next();
				int yos = scan.nextInt();
				double Sal = scan.nextDouble();
				String stat = scan.next();
				String section = scan.nextLine();
				double pen;
				if(stat.equals("r")){
				pen = (Sal*yos*.02);
				}
				else{
				pen = 0.0;
				}
				woltmanandrewEmployee employeeList = new woltmanandrewEmployee(division,fn,ln,yos,Sal,stat,section,pen);
				employees [j] =employeeList;
			}
			i++;
			titleName = scan.nextLine();
			int loops3 = scan.nextInt();
			NumberOfEmployees [i] = loopTotal1;
			i++;
			loopTotal1 += loops3;
			NumberOfEmployees[i] = loopTotal1;
			for(int j =NumberOfEmployees[2];j<(NumberOfEmployees[3]);j++)//adds Temporary employees to the end of the array
			{
				String division = titleName;
				String fn = scan.next();
				String ln = scan.next();
				int yos = scan.nextInt();
				double Sal = scan.nextDouble();
				String stat = scan.next();
				String section = scan.nextLine();
				double pen;
				if(stat.equals("r")){//if the employees status is r then gives them a pension value if not its set to 0
				pen = (Sal*yos*.02);
				}
				else{
				pen = 0.0;
				}
				woltmanandrewEmployee employeeList = new woltmanandrewEmployee(division,fn,ln,yos,Sal,stat,section,pen);
				employees [j] =employeeList;
				//System.out.println(employees[j]);
			}
			line = scan.nextLine();
		}		
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
					menu(selections,employees,NumberOfEmployees);
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
	public static void menu(int [] menuOptions,woltmanandrewEmployee [] emppass, int [] NumberOfEmployees)
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
					listall(emppass,NumberOfEmployees);
					menuOptions[0] += 1;
					menu = false;
					break;
				case 'e':
				case 'E':
					employeeReport(emppass,NumberOfEmployees);
					menuOptions[1] += 1;
					menu = false;
					break;
				case 'D':
				case 'd':
					divisionReport(emppass,NumberOfEmployees);
					menuOptions[2] += 1;
					menu = false;
					break;
				case 'S':
				case 's':
					salaryReport(emppass,NumberOfEmployees);
					menuOptions[3] += 1;
					menu = false;
					break;
				case 'r':
				case 'R':
					retirementReport(emppass,NumberOfEmployees);
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
					sortList(emppass);
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
	public static void salaryReport(woltmanandrewEmployee [] emppass,int [] NumberOfEmployees)
	{
		boolean salary = true;
		final int TotalEmployees =26;
		while(salary){
			System.out.print("Enter an employee you would like to search for:");
			Scanner scan = new Scanner(System.in);
			String LastName = scan.next();
		if(LastName.equals("all")){//if the person types in all then it displays their first and last name, and their salary
			for(int i = 0;i<NumberOfEmployees[3];i++){
				System.out.println("First Name: "+emppass[i].getFirstName()+"\t");
				System.out.println("Lirst Name: "+emppass[i].getLastName()+"\t");
				System.out.println("Salary: "+emppass[i].getSalary()+"\t");
			}
			salary = false;
		}
		else if(emppass[i].getLastName().equals(LastName)){
		for(int i = 0;i < NumberOfEmployees[3];i++){
			//if what they type in matches a persons last name then if displays their name and salary
			System.out.println("Last Name:"+emppass[i].getLastName());
			System.out.println("Salary: "+emppass[i].getSalary());
		salary = false;
			}
			
		
		}
		else {
		for(int l = 0;l < 1;l++){//if what they type matches nothing, it gives them an error message and askes them to 
		
			System.out.println("No employee found");
			salary = true;
			
			}
			}
		}
	return;
}
	public static void retirementReport(woltmanandrewEmployee [] emppass,int [] NumberOfEmployees)
	{
		boolean retirement = true;
		int numberOfEmployees = 26;
		while(retirement){
			System.out.println("If you want active employees type a");
			System.out.println("If you want retired employees type r:");
			System.out.println("If you want all employees type all");
			Scanner scan = new Scanner(System.in);
			String aORr = scan.next();
		if(aORr.equals("all")){//if the person types in all then it displays the first and last name of all employees
		for(int i = 0; i < NumberOfEmployees[3]; i++){
			if(emppass[i].getStatus().equals("a")){
				System.out.println("Last Name: " + emppass[i].getLastName());
				System.out.println("First Name: " + emppass[i].getFirstName());
				}
			}
			for(int j = 0; j < NumberOfEmployees[3]; j++){
				if(emppass[j].getStatus().equals("r")){
				System.out.println("Last Name: " + emppass[j].getLastName());
				System.out.println("First Name: " + emppass[j].getFirstName());
				System.out.println("Their pension is: " + emppass[j].getPension());
				}
			}
			retirement = false;
		}
		else if(aORr.equals("a")){//if the person types in a then it displays the first and last name for all active players
			for(int i = 0; i < NumberOfEmployees[3]; i++){
			if(emppass[i].getStatus().equals("a")){
				System.out.println("Last Name: " + emppass[i].getLastName());
				System.out.println("First Name: " + emppass[i].getFirstName());
				}
			}
			retirement = false;
		}
		else if(aORr.equals("r")){//if the person types in r then it displays the first and last name, and the pension of all retired employees
			for(int l = 0; l < NumberOfEmployees[3]; l++){
				if(emppass[l].getStatus().equals("r")){
				System.out.println("Last Name: " + emppass[l].getLastName());
				System.out.println("First Name: " + emppass[l].getFirstName());
				System.out.println("Their pension is: " + emppass[l].getPension());
				}
			}
		}
		else{
			System.out.println("No Division Found");
			retirement = true;
		}
	}
	return;
}
	public static void divisionReport(woltmanandrewEmployee [] emppass,int [] NumberOfEmployees)
	{
		boolean division = false;
		double AverageOfOccupational = 0.0;
		double AverageOfManagement = 0.0;
		double AverageOfTemporary = 0.0;
		double TotalSalaryOfOccupational = 0.0;
		double TotalSalaryOfManagement = 0.0;
		double TotalSalaryOfTemporary = 0.0;
		int j =(NumberOfEmployees[0]+NumberOfEmployees[1]);
		System.out.println(j);
		System.out.println(NumberOfEmployees[1]);
		while(!division){
		System.out.print("Enter the division of interest: ");
		Scanner scan = new Scanner(System.in);
		String Division = scan.next();
		if(Division.equals("all")){//checks if they entered all, meaning they want all employees
			for(int i = 0;i<NumberOfEmployees[3];i++){
				System.out.println("First Name: "+emppass[i].getFirstName()+"\t");
				System.out.println("Lirst Name: "+emppass[i].getLastName()+"\t");
				System.out.println("Salary: "+emppass[i].getSalary()+"\t");
			}
			division =true;
		}
		else if(Division.equals("Occupational")){//checks if they entered Occupational, meaning they want all active employees in the Occupational division and their average salary
			for(int i = 0;i<NumberOfEmployees[0];i++){
				if(emppass[i].getDivision().equals("Occupational") && emppass[i].getStatus().equals("a")){
				System.out.println("First Name: "+emppass[i].getFirstName()+"\t");
				System.out.println("Lirst Name: "+emppass[i].getLastName()+"\t");
				System.out.println("Salary: "+emppass[i].getSalary()+"\t");
				System.out.println("Status: "+ emppass[i].getStatus()+"\t");

			}}	
			for(int i = 0;i<NumberOfEmployees[0];i++){//computes the average of active occupational employees
		if(emppass[i].getDivision().equals("Occupational") && emppass[i].getStatus().equals("a")){
				TotalSalaryOfOccupational += emppass[i].getSalary();
				AverageOfOccupational = TotalSalaryOfOccupational/8;
		}			
			}
		System.out.println("Average Salary: "+AverageOfOccupational);
		division = true;
	}
		else if(Division.equals("Management")){//same as prior, just for management
			for(int i = NumberOfEmployees[0];i<NumberOfEmployees[1]+1;i++){
				if(emppass[i].getDivision().equals("Management") && emppass[i].getStatus().equals("a")){
				System.out.println("First Name: "+emppass[i].getFirstName()+"\t");
				System.out.println("Lirst Name: "+emppass[i].getLastName()+"\t");
				System.out.println("Salary: "+emppass[i].getSalary()+"\t");
				System.out.println("Status: "+ emppass[i].getStatus()+"\t");

				}
			}	
			for(int i = NumberOfEmployees[0];i<NumberOfEmployees[1]+1;i++){//gets a total of all the employees that are in temporary
		if(emppass[i].getDivision().equals("Management") && emppass[i].getStatus().equals("a")){
				TotalSalaryOfManagement += emppass[i].getSalary();
				AverageOfManagement = TotalSalaryOfManagement/8;
			}			
		}
		System.out.println("Average Salary: "+AverageOfManagement);
		division = true;
	}
	else if(Division.equals("Temporary")){//same as the 2 prior, just for Temporary
			for(int i = NumberOfEmployees[2];i<NumberOfEmployees[3];i++){
				if(emppass[i].getDivision().equals("Temporary") && emppass[i].getStatus().equals("a")){
				System.out.println("First Name: "+emppass[i].getFirstName()+"\t");
				System.out.println("Lirst Name: "+emppass[i].getLastName()+"\t");
				System.out.println("Salary: "+emppass[i].getSalary()+"\t");
				System.out.println("Status: "+ emppass[i].getStatus()+"\t");
				}
			}	
			for(int i = NumberOfEmployees[2];i < NumberOfEmployees[3];i++){//gets a total of all the employees that are in temporary
				if(emppass[i].getDivision().equals("Temporary") && emppass[i].getStatus().equals("a")){
						TotalSalaryOfTemporary += emppass[i].getSalary();
						AverageOfTemporary = TotalSalaryOfTemporary/3;			
			}
		}
		System.out.println("Average Salary: "+AverageOfTemporary);
		division =true;
	}
	else{
		System.out.println("No division found");
		division = false;
	}
		}
		return;
}
	public static void employeeReport(woltmanandrewEmployee [] emppass,int [] NumberOfEmployees)
	{
		final int TotalEmployees =26;
		boolean test =true;
		while(test){
			System.out.print("Enter an employee you would like to search for:");
			Scanner scan = new Scanner(System.in);
			String LastName = scan.next();
			for(int i = 0;i < TotalEmployees;i++){
			if(emppass[i].getLastName().equals(LastName)){//searches all employees to check if what they typed is equal to an employee object
				System.out.println("Divition: "+ emppass[i].getDivision());
				System.out.println("Last Name:"+ emppass[i].getLastName());
				System.out.println("Salary: "+ emppass[i].getSalary());
				System.out.println("Section: "+ emppass[i].getSection());
				test = true;
			}
			else{//if no, displays an error messages and asks them to enter another person
				System.out.println("Not in the system");
				test = false;
			}
		return;
			}
		}
	}
	public static void listall(woltmanandrewEmployee [] emppass,int [] NumberOfEmployees)//displays all employee objects
	{
		for(int display = 0;display<NumberOfEmployees[3];display++)
		System.out.println(emppass[display]);
		return;
	}
public static void sortList(woltmanandrewEmployee [] emppass){
	System.out.print(emppass[1].getLastName().compareTo(emppass[2].getLastName()));
}
}
/*
I enjoyed this project, it really challenged me to think about what I was doing. I originally had a lot of trouble reading int
the data from the file becaue I tried to read it all in at once but this was not easy to do. I also had dificuly passing arrays
from method to method in the begining, but I fixed that in the end. This project was really a joy because I spent so much time 
on it, but I would get an error and then I would fix it leading to many many more erros. When I was finally able to completely
debug the program I was so happy that I got it to work all by myself! I came to the realization that this project was not one
of big gains, but one that lead full gradification that it was all done and works as it is supposed to!*/