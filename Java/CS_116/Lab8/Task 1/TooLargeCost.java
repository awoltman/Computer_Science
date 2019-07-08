
public class TooLargeCost extends Exception
{
	public TooLargeCost()
	{
		super();
	}
	
	public String toString()
	{
		return "TooLargeCostException occurred. ";
	}
	
	public String getMessage()
	{
		return "The cost calculated exceeds the limits. ";
	}
}