package Client.Services.Classes;
import Client.MyBillsClient;
import Client.Services.BillsType;
public class MyBills
{
	private String month;
	private BillsType type;
	private double [] expences;
	private int numOfDays;
	static int id;
	int currentid;
	
	
	public MyBills()
	{
		month = "any month";
		type = BillsType.School;
		expences = null;
		numOfDays = 0;
		id++;
		currentid = id;
	}
	
	public MyBills(String newMonth, BillsType BT, double [] newExpences, int newNumOfDays)
	{
		month = newMonth;
		type = BT;
		expences = newExpences;
		numOfDays = newNumOfDays;
	}
	public int getCurrentID()
	{
		return currentid;
	}
	public void setMonth(String revisedMonth)
	{
		month = revisedMonth;
	}
	public void setBillsType(BillsType revisedType)
	{
		this.type = revisedType;
	}
	public void setExpences(double [] revisedExpences)
	{
		expences = revisedExpences;
	}
	public void setNumOfDays(int revisedNumOfDays)
	{
		numOfDays = revisedNumOfDays;
	}
	public String getMonth()
	{
		return month;
	}
	public BillsType getBillsType()
	{
		return type;
	}
	public double[] getExpences()
	{
		return expences;
	}
	public int getNumOfDays()
	{
		return numOfDays;
	}
	public boolean equals(MyBills expensive)
	{
		if(this.getBillsType().equals(expensive.getBillsType())&& (this.getNumOfDays()==expensive.getNumOfDays()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String toString()
	{
		return "The month is:"+" "+month+" "+"The bill type is:"+" "+type+" "+"The expences are:"+" "+expences+" "+"The Number of days are:"+" "+numOfDays+" "+"The expense object ID is:"+" "+currentid;
	}
	
	
}