public class woltmanandrewEmployee
{
	private String Division;
	private String LastName;
	private String FirstName;
	private int YOS;
	private double Salary;
	private String Status;
	private double minSalary = 0;
	private String Section;
	private double Pension;
	private int IDNum = -1;
	private static int nextIDNum = 1;
	
public woltmanandrewEmployee()
	{
		Division = "not set";
		LastName = "not set";
		FirstName = "not set";
		YOS = 0;
		Salary = 0.0;
		Status = "not set";
		Section = "not set";
		Pension = 0.0;
	}
public woltmanandrewEmployee(String firstDivision,String firstLastName,String firstFirstName,int firstYOS,double firstSalary,String firstStatus, String firstSection, double firstPension)
	{
		Division = firstDivision;
		LastName = firstLastName;
		FirstName = firstFirstName;
		YOS = firstYOS;
		Salary = firstSalary;
		Status = firstStatus;
		Section = firstSection;
		Pension = firstPension;
	}
public double getPension()
	{
		return Pension;
	}
public String getDivision()
	{
		return Division;
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
public String getStatus()
	{
		return Status;
	}
public String getSection()
	{
		return Section;
	}
public void setPension(double newPension)
	{
		Pension = newPension;
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
public void setStatus(String newStatus)
	{
		Status = newStatus;
	}
public void setSection(String newSection)
	{
		Section = newSection;
	}
public String toString()
	{
		
		return "Division:" + Division + "Last Name: " + LastName + " First Name: " + FirstName + " Years of service:" + YOS + " Salary: " + Salary + " Active/Retired: " + Status + " Section:" + Section + " Pension: " + Pension;
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