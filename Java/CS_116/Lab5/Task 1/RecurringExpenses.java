package Client.Services.Enums.Help;

public class RecurringExpenses extends Rent implements UtilityCostsInterface, MaterialCostsInterface
{
	public double getMaterialExpenses()
	{
		MaterialImpl mImpl = new MaterialImpl();
		return mImpl.getMaterialExpenses();
	}
	
	public double getUtilityExpenses()
	{
		UtilImpl uImpl = new UtilImpl();
		return uImpl.getUtilityExpenses();
	}
	
	public double totalRecurringExpenses()
	{
		double totExp = getRentCost() + getUtilityExpenses() + getMaterialExpenses();
		System.out.println("The total cost for everything up to this point is "+ totExp);
		return totExp;
	}
	
	public void createExpenses()
	{
		UtilityCosts u = new UtilityCosts(100.00, 100.00, 100.00);
		UtilityCosts uObj = new UtilityCosts(150.00, 150.00, 150.00);
		Rent r = new Rent("2", 3, 4);
		Rent rObj = new Rent("4", 1, 1);
		MaterialCosts m = new MaterialCosts("Paper", 3.0, 1000);
		MaterialCosts mObj = new MaterialCosts("Ink", 2.0, 200);
		
		System.out.println(u.totalUtilCosts());
		System.out.println(uObj.totalUtilCosts());
		System.out.println(r.rent());
		System.out.println(rObj.rent());
		System.out.println(m.materialPrice());
		System.out.println(mObj.materialPrice());
	}
	
	
}








