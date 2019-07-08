public drivers
{
	private String driver;
	private int age;
	private int licenseNum;
	private double yearsOfService;
	
	public divers
	{
		driver = "Not Set";
		age = 0;
		licenseNum = 00000;
		yearsOfService = 0.0;
	}
	public divers(String newDriver, int newAge, int newLicenseNum, double newYearsOfService)
	{
		driver = newDriver;
		age = newAge;
		licenseNum = newLicenseNum;
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
		if(revisedLicenseNum.length == 5)
		{
			licenseNum = revisedLicenseNum;
		}
		else
		{
			licenseNum = licenseNum;
		}
	}
	public void setYearsOfService(double revisedYearsOfeService)
	{
		yearsOfService = revisedYearsOfeService;
	}
	
}