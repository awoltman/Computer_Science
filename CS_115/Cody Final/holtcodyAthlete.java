public class holtcodyAthlete
{
	private String Country;
	private String LastName;
	private String FirstName;
	private int AGE;
	private double Revenue;
	private String Surface;
	private String Sport;
	private int IDNum = -1;
	private static int nextIDNum = 1;
	
public holtcodyAthlete()
	{
		Country = "not set";
		LastName = "not set";
		FirstName = "not set";
		AGE = 0;
		Revenue = 0.0;
		Surface = "not set";
		Sport = "not set";
	}
public holtcodyAthlete(String firstCountry,String firstLastName,String firstFirstName,int firstAge,double firstRev,String firstSurf, String firstSport)
	{
		Country = firstCountry;
		LastName = firstLastName;
		FirstName = firstFirstName;
		AGE = firstAge;
		Revenue = firstRev;
		Surface = firstSurf;
		Sport = firstSport;
	}

public String getCountry()
	{
		return Country;
	}
public String getLastName()
	{
		return LastName;
	}
public String getFirstName()
	{
		return FirstName;
	}
public int getAGE()
	{
		return AGE;
	}
public double getRevenue()
	{
		return Revenue;
	}
public String getSurface()
	{
		return Surface;
	}
public String getSport()
	{
		return Sport;
	}

public void setLastName(String newLastName)
	{
		LastName = newLastName;
	}
public void setFirstName(String newFirstName)
	{
		FirstName = newFirstName;
	}
public void setAGE(int newAGE)
	{
		AGE = newAGE;
	}
public void setRevenue(double newRevenue)
	{
		if(newRevenue > 0)
		Revenue = newRevenue;
	}
public void setSurface(String newSurface)
	{
		if(newSurface == "i" || newSurface == "s")
		{
			Surface = newSurface;
		}
		else
		{
			System.out.println("This is not a valid Surface!!");
		}
	}
public void setSport(String newSport)
	{
		Sport = newSport;
	}
public String toString()
	{
		
		return "Country:" + Country + "Last Name: " + LastName + " First Name: " + FirstName + " Age:" + AGE + " Revenue: " + Revenue + " Ice or Snow: " + Surface + " Sport:" + Sport;
	}
public String Display()
	{
		return toString();
	}
public boolean equals(holtcodyAthlete compare)
	{
		if(IDNum == compare.IDNum){
			return true;
		}
		else{
			return false;
		}
	}
}