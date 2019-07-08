package Client.Services;
import Client.Services.Enums.Jobs;

public abstract class Worker
{
	public String name;
	public int socialSecurity;
	private int yearsExperience;
	public Jobs et;
	public static int id;
	public int currentID;
	
	public Worker()
	{
		name = "AnyName";
		socialSecurity = 12345;
		yearsExperience = 0;
		et = Jobs.NONE;
		id++;
		currentID = id;
	}
	
	public Worker(String name1, int socialSec, int yearsExp, Jobs enumJobs)
	{
		name = name1;
		socialSecurity = socialSec;
		yearsExperience = yearsExp;
		et = enumJobs;
		id++;
		currentID = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getSocialSecurity()
	{
		return socialSecurity;
	}
	
	public int getYearsExperience()
	{
		return yearsExperience;
	}
	
	public Jobs getJob()
	{
		return et;
	}
	
	public void setName(String name2)
	{
		name = name2;
	}
	
	public void setSocialSecurity(int num)
	{
		socialSecurity = num;
	}
	
	public void setYearsExperience(int yrs)
	{
		yearsExperience = yrs;
	}
	
	public void setJob(Jobs J)
	{
		et = J;
	}
	
	public String toString()
	{
		String out = "The name is: "+name+" The Job type type is "+et+" The id is "+currentID;
		return out;
	}
	
	public abstract double benefitsCalculation(Jobs theJob);	
}

















