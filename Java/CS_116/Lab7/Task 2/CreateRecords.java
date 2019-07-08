package Compiled;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import Compiled.BankAccount;

public class CreateRecords
{
	public static void main(String[] args)
	{
		ArrayList<BankAccount> allAccounts = new ArrayList<BankAccount>();
		allAccounts.add(new BankAccount(1324, 'A', 'M',1000.3, true, "Mypassword"));
		allAccounts.add(new BankAccount(3456, 'G', 'L', 300.34, false, "helenB"));
		allAccounts.add(new BankAccount(7890, 'H', 'J',1290.0, true, "jwer"));
		allAccounts.add(new BankAccount(6781, 'F', 'D', 260.6, true, "hgfw"));
		
		FileOutputStream file_output;
		OutputStreamWriter filestream;
		
		try
		{
			file_output = new FileOutputStream("output.txt", true);
			filestream = new OutputStreamWriter(new BufferedOutputStream(file_output));
			for(int i = 0; i < allAccounts.size(); i++)
			{
				filestream.write(allAccounts.get(i).toString() + "\n");
			}
			filestream.flush();
			file_output.close();
			
		}
		catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
		
		Scanner in = new Scanner(System.in);
		System.out.println("please indicate if you want the file output.txt read by typing yes");
		String str = in.next();
		if(str.equals("yes"))
		{
			
			try
			{
				FileInputStream phi = new FileInputStream("output.txt");
				BufferedReader phiReader = new BufferedReader(new InputStreamReader(phi));
				String reading = "";
				while((reading = phiReader.readLine()) != null)
				{
					System.out.println(reading);
				}
				phi.close();
				phiReader.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("File not found");
			}
			catch(IOException ihj)
			{
				System.out.println(ihj.toString());
			}
		}		
	}
}






