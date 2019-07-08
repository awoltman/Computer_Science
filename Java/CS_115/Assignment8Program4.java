import java.util.*;
import java.io.*;
public class Assignment8Program4
{
	public static void main(String[]args) throws IOException
	{
		File file = new File("input.txt");
		Scanner scan = new Scanner(file);
		int NOL = 0;
		while(scan.hasNextLine())
		{
			String line = scan.nextLine();
			NOL++;
		}
		System.out.print("Number of lines: "+NOL);
	}
}