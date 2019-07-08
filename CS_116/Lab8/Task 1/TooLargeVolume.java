
public class TooLargeVolume extends Exception
{
	public TooLargeVolume()
	{
		super();
	}
	
	public String toString()
	{
		return "TooLargeVolume exception has occurred. ";
	}
	
	public String getMessage()
	{
		return "The volume calculated exceeds the limits. ";
	}
	
}