import java.util.*;
import java.io.*;

public class Assignment8Program2
{
	public static void main(String[]args) throws IOException
	{
		File file = new File("input.txt");
		Scanner scan = new Scanner(file);
		FileOutputStream fos = new FileOutputStream("output.txt", false);
		PrintWriter pw = new PrintWriter(fos);
		int i=1;
		while(scan.hasNextLine())
		{
			
			String line = scan.nextLine();
			pw.println("line "+ i+":"+ line);
			i++;			
		}
		pw.close();
	}
}
