import java.io.*;
import java.util.*;

public class Assignment8Program1
{
	public static void main(String[]args) throws IOException
	{
		File inputFile = new File("input.txt");
		double total= 0;
		int NON =0;
		 Scanner file = new Scanner(inputFile);
		 while(file.hasNext())
		 {
			 double number = file.nextDouble();
			 total += number;
			 NON++;
		 }
		double average = total/NON;
		System.out.print("The average is:"+ average);
	}
}