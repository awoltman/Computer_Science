package Client.Services.Enums.Help;
import Client.WorkerBenefits;

public class AllExpenses extends WorkerBenefits implements ExpenseInterface
{
	
	ExpenseImpl ayeaye = new ExpenseImpl();
	
	public double getRecurringExpenses()
	{
		return ayeaye.getRecurringExpenses();
	}
	
	public double getTotalExpenses()
	{
		return totalBenefits() + getRecurringExpenses();
	}
	
	public void createExpenses()
	{
		ayeaye.createExpenses();
	}
	
}







