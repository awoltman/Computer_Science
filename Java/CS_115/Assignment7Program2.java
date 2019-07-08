
import java.util.Scanner;

public class Assignment7Program2
{
	public static void main(String[]args)
	{
	
	Scanner scan = new Scanner(System.in);
	System.out.print("enter website without www. and .com:");
	String website = scan.next();
	System.out.print("www."+website+".com");
	}
}