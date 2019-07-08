package exception;
public class PopulationsGreaterThanGroup extends Exception
{
	public PopulationsGreaterThanGroup()
	{
		super();
	}

	public String getMessage()
	{
		return "The population cant be bigger than group";
	}

	public String toString()
	{
		return "Inaccurate Population occurred";
	}
}