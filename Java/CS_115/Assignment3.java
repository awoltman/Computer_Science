/* 
	Number 1
		[] a< b; true
		[] a!= b; true
		[] a == 4; false
		[] (b-a)<= 1; false
		[] Math.abs(a-b) >= 2; true
		[] (b % 2 == 1); false
		[] b <= 5; true
	
	Number 2
		[] !a is false
		[] a && b is true
		[] a && c is false
		[] a || c is true or false
		[] !(a || b) is false
		[] !a || b is true or false
		[] !(!(a && c)) is false
		[] a && !(b || c) is false
		
	Number 7
		[] a < b || b < 10; yes
		[] a != b && b < 10; no
		[] a == 4 || b < 10; no
		[] a > b && b < 10; no
		
	Number 15
		>C 
		>Done
		
	Number 16
		>Hello 4
		>Done
	
	Number 39
		>when you write an if statement and then you add an
		else statement you are required to write it as 
		else if, otherwise the syntax will be off
	
	Number 40
		>if you initialize a to equal 32 then a will equal 
		32 in the entire program, so when he put that a=31
		it creates a syntax error in the coding
	
	Number 41
		>when you write an if statement and then you add an
		else statement you are required to write it as 
		else if, otherwise the syntax will be off
*/

import java.util.Scanner;

public class Assignment3
{
public static void main(String[]args)

	{
		Scanner temp = new Scanner(System.in);
		String Season;
		
		System.out.println("Enter the temperature");
		double temperature= temp.nextDouble();
		
			if (temperature <= 110 && temperature >= 90)
				System.out.println( "SUMMER" );
			
			else if (temperature >= 70 && temperature < 90 )
				System.out.println( "SPRING" );
				
			else if (temperature >= 50 && temperature < 70)
				System.out.println( "FALL" );
			
			else if (temperature >= -5 && temperature < 50)
				System.out.println( "WINTER" );
			
			else if ( temperature < -5 || temperature > 110)
				System.out.println ( "Temperature entered is outside the valid range");
	}		
			
}


	