import java.util.*;

public class driversClient
{
	public static void main(String[] args)
	{
		String driver1 = args[0];
		String s2 = args[1];
		String s3 = args[2];
		String s4 = args[3];
		int age1 = Integer.parseInt(s2);
		int licenseNum1 = Integer.parseInt(s3);
		double yearsOfService1 = Double.parseDouble(s4);
		String driverName;
		int age;
		int licenseNumber;
		double yearsOfService;
		int fee = 1;
		Scanner scan = new Scanner(System.in);
		
		
		drivers dr1 = new drivers(driver1,age1,licenseNum1,yearsOfService1);
		
		System.out.print("Please provide driver name: ");
		driverName = scan.nextLine();
		
		System.out.print("Please provide the age of the driver: ");
		age = scan.nextInt();
		
		System.out.print("Please provide the license number: ");
		licenseNumber = scan.nextInt();
		
		System.out.print("Please provide the years of service: ");
		yearsOfService = scan.nextDouble();
	
		drivers dr2 = new drivers(driverName,age,licenseNumber,yearsOfService);
		driversClient drf = new driversClient();
		System.out.println(dr1.toString());
		System.out.println(dr2.toString());
		System.out.println("The License fee for Driver 2 is:" + drf.licenseFee(dr2));
		;
		if(dr1.equals(dr2))
		{
			System.out.println("Command Line object is equal to Keyboard Object");
		}
		else
		{
			System.out.println("Command Line object is NOT equal to Keyboard Object");
		}
	}
	public int licenseFee(drivers dr2)
	{
		int fee;
		fee = (dr2.getAge()*dr2.getLicenseNum())/10000;
		fee += 50;
		System.out.print("the fee is: " + fee);
		return +fee;
	}
}