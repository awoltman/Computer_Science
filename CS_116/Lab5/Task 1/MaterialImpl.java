package Client.Services.Enums.Help;

public class MaterialImpl extends MaterialCosts implements MaterialCostsInterface
{
	public double getMaterialExpenses()
	{
		return getMaterialCost();
	}
}