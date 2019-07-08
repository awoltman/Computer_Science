import java.util.*;
import java.io.*;
public class woltmanandrew1
{
public static void main( String [] args)throws IOException
	{
		int loops;
		int i;
		char selection;
		boolean test = true;
		boolean title = true;
		final int titleNumber= 2;
		final int loopNumber= 2;
		 	File ifile = new File("empcs115.txt");
			Scanner scan = new Scanner(ifile);
			String titleName = scan.nextLine();
			String [] titles = new String [50];
			titles[0] = titleName;
			System.out.println(titles[0]);
			loops = scan.nextInt();
			int [] loop = new int [loops];
			loop[0] = loops;
			int [] people = new int [loops];
			people[0]=loops;
			System.out.println(loop[0]);
			System.out.println(people[0]);
			//woltmanandrewEmployee [] employees = new woltmanandrewEmployee [loops];
			
				String spliter = "/n";
				String employee = scan.nextLine();
				StringTokenizer emp = new StringTokenizer(employee,spliter);
					String ln = emp.nextToken();
					String fn = emp.nextToken();
					System.out.println(ln);
					System.out.println(fn);
	}
}