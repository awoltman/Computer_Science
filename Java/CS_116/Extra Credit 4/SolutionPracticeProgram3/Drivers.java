//George Koutsogiannakis
package Driverclass1.Driverclass2;
public class Drivers
{
	
	String name=" ";
	int age=0;
	int license=0;
	double years=0.0;
	DriverType dt=null;
	static int id=0;
	int presentID=0;

	public Drivers()
	{
		id++;
		presentID=id;
		name="No name";
		age=16;
		license=11111;
		years=0.5;
		dt=DriverType.None;
	}

	public Drivers(String n, int a, int l, double y, DriverType drty)
	{
		id++;
		presentID=id;
		name=n;
		age=a;
		license=l;
		years=y;
		dt=drty;
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}
	public int getLicenses()
	{
		return license;
	}

	public double getYears()
	{
		return years;
	}

	public DriverType getDriverType()
	{
		return dt;
	}

	public int getPresentID()
	{
		return presentID;
	}

	

	public void setName(String na)
	{
		name=na;
	}

	public void setAge(int ag)
	{
		age=ag;
	}
	public void setLicenses(int li)
	{
		license=li;
	}

	public void setYears(double ye)
	{
		years=ye;
	}

	public void setDriverType(DriverType dty)
	{
		dt=dty;
	}

	public String toString()
	{
		String out="The name of the driver is:"+" "+name+" "+"The age is:"+" "+age+" "+"The license number is:"+" "+license+" "+
		"The years of driving is:"+" "+years+" "+"The driver type is:"+" "+dt+" "+"The object id is:"+" "+presentID;
		return out;
	}

	public boolean equals(Drivers dr)
	{
		if((this.getName().equals(dr.getName()))&&(this.getLicenses()==dr.getLicenses())&&(this.getDriverType().equals(dr.getDriverType())))
			return true;
		else
			return false;
	}

	


}
