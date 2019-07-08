package driversclass1;
import driversclass1.driversclass2.Drivers;
import java.util.*;
import java.io.*;
public class DriversClient  
{
	public static void main(String[] args) 
	{
		
		Drivers [] drivers = null;
		int counter0 = 0;
		try{
		String na=args[0];
		String agstr=args[1];
		int ag=Integer.parseInt(agstr);
		String licstr=args[2];
		int lic=Integer.parseInt(licstr);
		String yeastr=args[3];
		double yea=Double.parseDouble(yeastr);
		
		Drivers dr1=new Drivers(na,ag,lic,yea);
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter the name of the driver");
        String nam=scan.next();
		System.out.println("Please enter the age of teh driver");
		int age2=scan.nextInt();
		System.out.println("please enter the license number");
		int licenses2=scan.nextInt();
		System.out.println("Please enter the years of driving");
		double years2=scan.nextDouble();


		
		Drivers dr2=new Drivers(nam,age2,licenses2,years2);
		
		
		DriversClient drcl=new DriversClient();
		
		System.out.println(dr1.toString());

		int f1=drcl.licenseFee(dr1);
		System.out.println("The fee for the first object is"+" "+f1);
		
		System.out.println(dr2.toString());
		
		int f2=drcl.licenseFee(dr2);
		System.out.println("The fee for the second object is"+" "+f2);
		if(dr1.equals(dr2))
			System.out.println("The command line object is equal to the keyboard object");
		else
			System.out.println("The command line object is not equal to the keyboard obkect");
		File myfile = new File("Data.txt");
		Scanner scan1 = new Scanner(myfile);
		
		int counter = 0;
		while(scan1.hasNextLine())
		{
			scan1.nextLine();
			counter0++;
		}
		System.out.println(counter0);
		Scanner scan2 = new Scanner(myfile);
		drivers = new Drivers[counter0];
		while(scan2.hasNextLine())
			{
				String line=scan2.nextLine();
				System.out.println("The line read is:"+" "+line);
				StringTokenizer strtok=new StringTokenizer(line, "!");
				String  firsttoken=strtok.nextToken();
				String secondtoken=strtok.nextToken();
				int sectokint=Integer.parseInt(secondtoken);
				String thirdtoken=strtok.nextToken();
				int thirdtokint=Integer.parseInt(thirdtoken);
				String forthtoken=strtok.nextToken();
				double forthtokdouble=Double.parseDouble(forthtoken);
				Drivers drive = new Drivers(firsttoken, sectokint, thirdtokint, forthtokdouble);
				drivers [counter] = drive;
				counter++;
		}
		}
		catch(IOException ioe)
		{
			System.out.print("Something went wrong!!!");
		}
		for(int i =0; i < counter0; i++)
		{
			System.out.println(drivers[i]);
		}

		Drivers highLic = drivers[0];
		
		for(int j =0; j < counter0; j++)
		{
			if(drivers[j].getLicenses() >= highLic.getLicenses())
			{
				
				highLic = new Drivers(drivers[j].getName(),drivers[j].getAge(),drivers[j].getLicenses(),drivers[j].getYears());
			}				
		}
		System.out.println("The driver with the highest License Number is:");
		System.out.print(highLic.toString());
	}
	
	public int licenseFee(Drivers dr)
	{
		double calc=dr.getAge()*dr.getLicenses()/10000+50;

		int fee=(int)Math.min(100.0, calc);
		return fee;
	}


}
/*OUTPUT
---------- Java Interpreter ----------
The name of the driver is: No name The age is: 16 The license number is: 11111 The years of driving is: 0.5
67
The name of the driver is: Smith The age is: 45 The license number is: 12345 The years of driving is: 6.3
100

Output completed (0 sec consumed) - Normal Termination */
