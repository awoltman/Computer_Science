package Compiled;
public class HighPriceException extends Exception
{
	public HighPriceException()
	{
		super();
	}

	public String getMessage()
	{
		return "Price is too high and it should be adjusted";
	}
	//optional
	public String toString()
	{
		return "HighPriceException exception was thrown";
	}
}
