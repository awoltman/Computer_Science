
import java.util.Scanner;

public class Assignment5Program3
{
public static void main(String[]args)
{
	
	Scanner scan = new Scanner(System.in);
	int number;
	System.out.print("Enter an integer: ");
	int minNumber = scan.nextInt();
	for (int i =0; i <9;i++ )
	{System.out.print("Enter an integer: ");
		number= scan.nextInt();
		if (number < minNumber)
			minNumber = number;
	}	
	
	System.out.print("The minimum value is: "+ minNumber);
}
}