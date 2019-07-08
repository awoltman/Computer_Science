

import java.util.Scanner;

public class Assignment6Program2
{
	public static void main(String[]args)
	{
		int fact = 1;
		Scanner scan= new Scanner(System.in);
		System.out.print("enter a positive number: ");
		int n = scan.nextInt();
		
		for(int i = 1; i <= n; i++)
		{	
			fact= fact*i;		
		}
		System.out.println("Factorial of "+n+" is = "+ fact);
	}	
}