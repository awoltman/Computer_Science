package Compiled;
import Compiled.BankAccount;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.ArrayList;

public class CreateRecords
{
	public static void main(String[] args)
	{
		ArrayList<BankAccount> accountStuff = new ArrayList<BankAccount>();
		File file = new File("records.dat");
		BankAccount a1 = new BankAccount(1234,'A','M',1000.30, true, "Mypassword");
		BankAccount a2 = new BankAccount(3456,'G','L',300.34,false,"helenB");
		BankAccount a3 = new BankAccount(7890,'H','J',1290.0,true,"jwer");
		BankAccount a4 = new BankAccount(6781,'F','D',260.60,true,"hgfdw");
		accountStuff.add(a1);
		accountStuff.add(a2);
		accountStuff.add(a3);
		accountStuff.add(a4);
		
		try
		{
			FileOutputStream file_output = new FileOutputStream(file, true);
			DataOutputStream data_out = new DataOutputStream(file_output);
			for(int i = 0; i < accountStuff.size(); i++)
			{
				String word = accountStuff.get(i).toString();
				data_out.writeChars(word);
			}
			file_output.close();
			data_out.close();
		}
		catch(IOException ioe)
		{
			System.out.println(ioe.getMessage());
		}
		
		System.out.println("please indicate if you want the file records.dat read by typing yes");
		Scanner in = new Scanner(System.in);
		String decision = in.next();
		if(decision.equals("yes"))
		{
			try
			{	
				FileInputStream file_input = new FileInputStream(file);
				DataInputStream data_in = new DataInputStream(file_input);
				for(int i = 0; i < accountStuff.size(); i++)
				{
					try
					{
						System.out.println(data_in.readLine());
					}
					catch(EOFException l)
					{
						break;
					}
				}
				data_in.close();
			}
			catch(IOException l)
			{
				System.out.println("IO Exception =: " + l);
			}
		
		}
		
		
	}
}






