package Client.Services;
import Client.Services.Enums.Jobs;

public class Management extends Worker
{
	private double weeklyBenefits;
	private double bonus;
	
	public Management()
	{
		super();
		weeklyBenefits = 10.0;
		bonus = 10.0;
	}
	
	public Management(String nameAdm, int socSecAdm, int yearsExpAdm, Jobs enumJobAdm, double rateAdm, double hourAdm)
	{
		super(nameAdm,socSecAdm,yearsExpAdm, enumJobAdm);
		weeklyBenefits = rateAdm;
		bonus = hourAdm;
	}
	
	public double getWeeklyBenefits()
	{
		return weeklyBenefits;
	}
	
	public double getBonus()
	{
		return bonus;
	}
	
	public void setWeeklyBenefits(double j)
	{
		weeklyBenefits = j;
	}
	
	public void setBonus(double b)
	{
		bonus = b;
	}
	
	public String toString()
	{
		String out = super.toString() + " The weekly benefit is " + weeklyBenefits + " The bonus is " + bonus;
		return out;
	}
	
	public double benefitsCalculation(Jobs daJob)
	{
		double benefits = 0;
		if(daJob.equals(Jobs.ENGINEERING_MANAGER))
			benefits = weeklyBenefits+bonus;
		else if(daJob.equals(Jobs.ADMINISTRATIVE_ASSISTANT))
			benefits = weeklyBenefits+0.5*bonus;
		else
			benefits = 0;
		return benefits;
	}
	
}