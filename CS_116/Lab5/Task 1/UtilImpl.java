package Client.Services.Enums.Help;

public class UtilImpl extends UtilityCosts implements UtilityCostsInterface
{
	public double getUtilityExpenses()
	{
		return getUtilCosts();
	}
}