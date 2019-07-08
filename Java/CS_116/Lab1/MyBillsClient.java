package Client;
import java.util.*;
import java.io.*;
import Client.Services.BillsType;
import Client.Services.Classes.MyBills;
import java.text.*;
public class MyBillsClient
{
	
	public static void main(String[] args)
	{
		try{
		int counter = 0;
		File ofile = new File("myexpences.txt");
		Scanner scan1 = new Scanner(ofile);
		int fileLength = 0;
		MyBills [] bills = null;
		int b = 0;
		while(scan1.hasNextLine())
		{
			scan1.nextLine();
			counter++;
		}
		System.out.println(counter);
		bills= new MyBills[counter];
		Scanner scan2 = new Scanner(ofile);
		int index = 0;
		while(scan2.hasNextLine())
		{
			b++;
			String m;
			String line;
			String l;
			String month = null;
			String ye;
			BillsType months =null;
			String a;
			double c;
			
			line=scan2.nextLine();
			double [] expences = new double[150];
			if(index%2 == 0 || index == 0)
			{
				StringTokenizer strtok=new StringTokenizer(line, ":");
				m=strtok.nextToken();
				month=strtok.nextToken();
				
				l=strtok.nextToken();
				ye=strtok.nextToken();
				months = BillsType.valueOf(ye);
				System.out.println(month + "  " + months);
				
			}
			else
			{
				StringTokenizer strtok1=new StringTokenizer(line, ",");
				int d =0;
				while(strtok1.hasMoreTokens())
				{
				System.out.println(d);
				a=strtok1.nextToken();
				c = Double.parseDouble(a);
				System.out.println(c);
				expences[d] = c;
				d++;
				}
			}

			MyBills bigBills=new MyBills(month,months,expences,b);
			bills[index]=bigBills;
			System.out.println(b);
			index++;
			
		}
		for(int f=0 ; f < bills.length;f++)
		{
			System.out.println(bills[f].toString());
		}
		MyBillsClient mbc1 = new MyBillsClient();
		String[] expen = mbc1.totalExpensesPerMonth(bills);
		for(int f=0 ; f < bills.length;f++)
		{
			System.out.println(expen[f].toString());
		}
	}
	catch(IOException ioe)
	{
		System.out.println("you fucked up");
	}
		

	}
	public static String[] totalExpensesPerMonth(MyBills[] exp)
	{	
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		int totals = 0;
		String jan;
		String[] expens = new String[12];
		System.out.println(exp[0].getMonth());
		for(int i=0; i < exp.length;i++)
		{			
		if(exp[i].getMonth().equals("JANUARY"))
		{
			double[] total = exp[i].getExpences();
			for(int k =0; k < total.length; k++)
			{
				totals += total[k];
				
			}	
			
			formatter.format(totals);
			jan = "The total of all expenses for the month of January is:" +totals;
			expens[1]= "fun";
			
		}
		if(exp[i].getMonth().equals("FEBRUARY"))
		{
			double[] total = exp[i].getExpences();
			for(int j =0; j < total.length; j++)
			{
				totals += total[j];
				
			}	
			
			formatter.format(totals);
			String feb = "The total of all expenses for the month of February is:" +totals;
		}
		if(exp[i].getMonth().equals("MARCH"))
		{
			double[] total = exp[i].getExpences();
			for(int l =0; l < total.length; l++)
			{
				totals += total[l];
				
			}	
			
			formatter.format(totals);
			String mar = "The total of all expenses for the month of January is:" +totals;
		}
		if(exp[i].getMonth().equals("APRIL"))
		{
			double[] total = exp[i].getExpences();
			for(int m =0; m < total.length; m++)
			{
				totals += total[m];
				
			}	
			
			formatter.format(totals);
			String ap = "The total of all expenses for the month of April is:" +totals;
		}
		if(exp[i].getMonth().equals("MAY"))
		{
			double[] total = exp[i].getExpences();
			for(int n =0; n < total.length; n++)
			{
				totals += total[n];
				
			}	
			
			formatter.format(totals);
			String ma = "The total of all expenses for the month of May is:" +totals;
		}
		if(exp[i].getMonth().equals("JUNE"))
		{
			double[] total = exp[i].getExpences();
			for(int p =0; p < total.length; p++)
			{
				totals += total[p];
				
			}	
			
			formatter.format(totals);
			String ju = "The total of all expenses for the month of June is:" +totals;
		}
		if(exp[i].getMonth().equals("JULY"))
		{
			double[] total = exp[i].getExpences();
			for(int o =0; o < total.length; o++)
			{
				totals += total[o];
				
			}	
			
			formatter.format(totals);
			String jul = "The total of all expenses for the month of July is:" +totals;
		}
		if(exp[i].getMonth().equals("AUGUST"))
		{
			double[] total = exp[i].getExpences();
			for(int t =0; t < total.length; t++)
			{
				totals += total[t];
				
			}	
			
			formatter.format(totals);
			String au = "The total of all expenses for the month of August is:" +totals;
		}
		if(exp[i].getMonth().equals("SEPTEMBER"))
		{
			double[] total = exp[i].getExpences();
			for(int j =0; j < total.length; j++)
			{
				totals += total[j];
				
			}	
			
			formatter.format(totals);
			String sep = "The total of all expenses for the month of September is:" +totals;
		}
		if(exp[i].getMonth().equals("OCTOBER"))
		{
			double[] total = exp[i].getExpences();
			for(int c =0; c < total.length; c++)
			{
				totals += total[c];
				
			}	
			
			formatter.format(totals);
			String oc = "The total of all expenses for the month of October is:" +totals;
		}
		if(exp[i].getMonth().equals("NOVEMBER"))
		{
			double[] total = exp[i].getExpences();
			for(int d =0; d < total.length; d++)
			{
				totals += total[d];
				
			}	
			
			formatter.format(totals);
			String nov = "The total of all expenses for the month of November is:" +totals;
		}
		if(exp[i].getMonth().equals("DECEMBER"))
		{
			double[] total = exp[i].getExpences();
			for(int e =0; e < total.length; e++)
			{
				totals += total[e];
				
			}	
			
			formatter.format(totals);
			String dec = "The total of all expenses for the month of December is:" +totals;
		}
		}
		return expens;
	}
}

