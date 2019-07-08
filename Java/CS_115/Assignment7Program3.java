import java.util.Scanner;

public class Assignment7Program3
{
	public static void main(String[]args)
	{
		Scanner scan = new Scanner(System.in);
		double NumberEntered;
		double Number;
		int i = 0;
		do
		{
			System.out.print("Enter a Number > 10: ");
			while( !scan.hasNextDouble())
		{
			String garbage = scan.next();
			
		
			System.out.print("Enter a Number > 10:");
				
		}
			NumberEntered = scan.nextDouble();
			Number= NumberEntered;
		}
		while(NumberEntered <10);
		while(Number > 1.01)
		{
			NumberEntered = Math.sqrt(NumberEntered);
			Number = NumberEntered;
			i++;
		}
		System.out.print("Number of square roots is: "+i);
	}
}