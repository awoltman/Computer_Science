package Client.Services;
import Client.Services.Enums.Jobs;

public class Engineer extends Worker
{
	private double weeklyBenefits;
	
	public Engineer(String nameEng, int socSecEng, int yearsExpEng, Jobs enumJobEng, double benEng)
	{
		super(nameEng, socSecEng, yearsExpEng, enumJobEng);
		weeklyBenefits = benEng;
	}
	
	public Engineer()
	{
		super();
		weeklyBenefits = 400.00;
	}
	
	public double benefitsCalculation(Jobs daJob)
	{
		double benefits = 0;
		if(daJob.equals(Jobs.ELECTRICAL_ENGINEER))
			benefits = weeklyBenefits + this.getYearsExperience() *80.00;
		else if(daJob.equals(Jobs.MECHANICAL_ENGINEER))
			benefits = weeklyBenefits/2 + this.getYearsExperience() * 120.00;
		else
			benefits = 0;
		return benefits;
	}
	
	public double getWeeklyBenefits()
	{
		return weeklyBenefits;
	}
	
	public void setWeeklyBenefits(double x)
	{
		weeklyBenefits = x;
	}
	
	public String toString()
	{
		String out = super.toString()+ " The weekly benefits is " + weeklyBenefits;
		return out;
	}
	
}



