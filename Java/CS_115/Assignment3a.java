import java.util.Scanner;

public class Assignment3a
{
public static void main(String[]args)

		{
			Scanner scan = new Scanner(System.in);
		
		
			System.out.println("Enter Username");
			
			String username = scan.next();
			
			System.out.println("Enter Password");
			
			String password = scan.next();
			
			if (username.equals("admin") && password.equals("open"))
				System.out.println("Welcome");
			
			else if (username.equals("admin") && !password.equals("open"))
				System.out.println("Wrong password");
			
			else if (password.equals("open") && !username.equals("admin"))
				System.out.println("Wrong user ID");
			
			else if (!password.equals("admin") && !username.equals("open"))
				System.out.println("Sorry, wrong ID and password");
		}
}