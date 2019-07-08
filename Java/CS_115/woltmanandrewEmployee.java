public class woltmanandrewEmployee
{
	private String DivisionTitle;
	private int NumberOfEmployees;
	private String LastName;
	private String FirstName;
	private int YOS;
	private double Salary;
	private char Status;
	private double minSalary = 0;
	private String Section;
	private int IDNum = -1;
	private static int nextIDNum = 1;
	
public woltmanandrewEmployee()
	{
		IDNum = nextIDNum;
		nextIDNum++;
		DivisionTitle = "not set";
		NumberOfEmployees = 0;
		LastName = "not set";
		FirstName = "not set";
		YOS = 0;
		Salary = 0.0;
		Status = 'n';
		Section = "not set";
	}
public woltmanandrewEmployee(String firstLastName,String firstFirstName,int firstYOS,double firstSalary,char firstStatus, String firstSection)
	{
		
		LastName = firstLastName;
		FirstName = firstFirstName;
		YOS = firstYOS;
		Salary = firstSalary;
		Status = firstStatus;
		Section = firstSection;
	}
public String getLastName()
	{
		return LastName;
	}
public String getFirstName()
	{
		return FirstName;
	}
public int getYOS()
	{
		return YOS;
	}
public double getSalary()
	{
		return Salary;
	}
public char getStatus()
	{
		return Status;
	}
public String getSection()
	{
		return Section;
	}
public void setLastName(String newLastName)
	{
		LastName = newLastName;
	}
public void setFirstName(String newFirstName)
	{
		FirstName = newFirstName;
	}
public void setYOS(int newYOS)
	{
		YOS = newYOS;
	}
public void setSalary(double newSalary)
	{
		if(newSalary > minSalary)
		Salary = newSalary;
	}
public void setStatus(char newStatus)
	{
		Status = newStatus;
	}
public void setSection(String newSection)
	{
		Section = newSection;
	}
public String toString()
	{
		return "Last Name: " + LastName + "First Name: " + FirstName + "Years of service:" + YOS + "Salary: " + Salary + "Active/Retired: " + Status + "Section:" + Section;
	}
public String Display()
	{
		return toString();
	}
public boolean equals(woltmanandrewEmployee compare)
	{
		if(IDNum == compare.IDNum){
			return true;
		}
		else{
			return false;
		}
	}
}