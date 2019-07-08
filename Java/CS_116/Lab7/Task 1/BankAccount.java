package Compiled;

public class BankAccount
{
	private int Bank_Account_Num;
	private char First_Name;
	private char Last_Name;
	private double balance;
	private boolean Fees_Apply;
	private String password;
	
	public BankAccount(int accountNum, char fName, char lName, double amountMoney, boolean fees, String pass)
	{
		Bank_Account_Num = accountNum;
		First_Name = fName;
		Last_Name = lName;
		balance = amountMoney;
		Fees_Apply = fees;
		password = pass;
	}
	
	
	public String toString()
	{
		String out = Bank_Account_Num + " " + First_Name+" "+Last_Name+" "+balance+" "+Fees_Apply+" "+password+"\n";
		return out;
	}
}