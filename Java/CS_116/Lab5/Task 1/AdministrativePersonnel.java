package Client.Services;
import Client.Services.Enums.Jobs;

public class AdministrativePersonnel extends Worker
{
	private double rate;
	private double hours;
	
	public AdministrativePersonnel()
	{
		super();
		rate = 10.0;
		hours = 10.0;
	}
	
	public AdministrativePersonnel(String nameAdm, int socSecAdm, int yearsExpAdm, Jobs enumJobAdm, double rateAdm, double hourAdm)
	{
		super(nameAdm,socSecAdm,yearsExpAdm, enumJobAdm);
		rate = rateAdm;
		hours = hourAdm;
	}
	
	public double benefitsCalculation(Jobs daJob)
	{
		double benefits = 0;
		if(daJob.equals(Jobs.ADMINISTRATIVE_SECRETARY))
			benefits = rate* hours + super.getYearsExperience() * 15.00;
		else if(daJob.equals(Jobs.ADMINISTRATIVE_ASSISTANT))
			benefits = rate * hours + super.getYearsExperience() * 25.00;
		else
			benefits = 0;
		return benefits;
	}
	
	public double getRate()
	{
		return rate;
	}
	
	public double getHours()
	{
		return hours;
	}
	
	public void setRate(double r)
	{
		rate = r;
	}
	
	public void setHours(double x)
	{
		hours = x;
	}
	
	public String toString()
	{
		String out = super.toString() + " The rate is "+rate+" The hours is " + hours;
		return out;
	}
}










