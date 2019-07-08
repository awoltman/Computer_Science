/* 
	Number 15
		[] ABCDEFGHIK
		
	Number 16
		[] hello
		
	Number 25
		[]int length = s.length();
	
	Number 26
		[] 
		Sring string;
		System.out.print("Enter a string");
			Scanner scan = new Scanner(System.in);
			string = scan.next()
			string.length()
			
	Number 39
		[] hj
		
*/

import java.util.Scanner
public class Assignment7Program1
{
	public static void main()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your username: ");
		String username = scan.next();
		System.out.print("Enter your password: ");
		String password = scan.next();
		if(username.length() > password.length())
			Sytem.out.print(+ password.length());
		else
			Sytem.out.print(+ username.length());
	}
}