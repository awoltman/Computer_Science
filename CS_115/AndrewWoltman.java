import java.util.Scanner;

public class AndrewWoltman
{
	public static void main (String[]args)
	
	{
		char LetterEntered;
		
		
	
	{
		do
		{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a Letter: ");
		String Letter = scan.next();
		LetterEntered = Letter.charAt(0);
		}
		while(LetterEntered != 'Z');
	}		
	}
}