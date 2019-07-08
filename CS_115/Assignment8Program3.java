import java.io.*;
import java.util.*;
public class Assignment8Program3
{
	public static void main(String[]args) throws IOException
	{
	File file = new File("input.txt");
	Scanner scan = new Scanner(file);
	int i = 0;
	while(scan.hasNextLine())
	{
		String line = scan.nextLine();
		char a = line.charAt(i);
		i++;
		System.out.println(a);
	}
	}
}