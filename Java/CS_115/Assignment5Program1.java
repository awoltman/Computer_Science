
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Assignment5Program1
{
	public static void main(String[]args) throws IOException
	{
		double number;
		int numberofnumbers = 0;
		double total = 0;
		File inputFile = new File("input.txt");
		Scanner file = new Scanner(inputFile);

		while(file.hasNext())
		{
			number = file.nextDouble();
			System.out.println(number);
			total += number;
			if (number != 0)
			{
				numberofnumbers++;
			}
		}
		
		double average = total/numberofnumbers;
		System.out.print("The Average is:"+ average);
	}
}