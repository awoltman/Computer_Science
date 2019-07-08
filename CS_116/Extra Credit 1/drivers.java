public class drivers
{
	private String driver;
	private int age;
	private int licenseNum;
	private double yearsOfService;
	
	public drivers()
	{
		driver = "Not Name";
		age = 16;
		licenseNum = 1111;
		yearsOfService = 0.5;
	}
	public drivers(String newDriver, int newAge, int newLicenseNum, double newYearsOfService)
	{
		driver = newDriver;
		age = newAge;
		if(newLicenseNum < 10000 && newLicenseNum > 999)
		{
			licenseNum = newLicenseNum;
		}
		yearsOfService = newYearsOfService;
	}
	public String getDriver()
	{
		return driver;
	}
	public int getAge()
	{
		return age;
	}
	public int getLicenseNum()
	{
		return licenseNum;
	}
	public double getYearsOfService()
	{
		return yearsOfService;
	}
	public void setDriver(String revisedDriver)
	{
		driver = revisedDriver;
	}
	public void setAge(int revisedAge)
	{
		age = revisedAge;
	}
	public void setLicenseNum(int revisedLicenseNum)
	{
		if(revisedLicenseNum < 10000 && revisedLicenseNum > 999)
		{
			licenseNum = revisedLicenseNum;
		}
	}
	public void setYearsOfService(double revisedYearsOfeService)
	{
		yearsOfService = revisedYearsOfeService;
	}
	
	public String toString()
	{
		return "The name of the driver is:" + driver + "The age is:" + age + "The license number is:" + licenseNum + "The years of service is:" + yearsOfService;
	}
	public boolean equals(drivers d2)
	{
		boolean TrueOrFalse = false;
		if(this.getDriver().equals(d2.getDriver()) && this.getLicenseNum()==(d2.getLicenseNum()))
		{
			TrueOrFalse = true; 
		}
		return TrueOrFalse;
	}
}
















































