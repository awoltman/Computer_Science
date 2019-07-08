package Client;
import Client.*;
import Client.Services.*;
import Client.Services.Enums.*;
import Client.Services.Enums.Help.*;
import java.util.ArrayList;

public class MainClass
{
	public static void main(String[] args)
	{
		WorkerBenefits work = new WorkerBenefits();
		ArrayList<Worker> lol = work.listOfWorkers();
		AllExpenses h = new AllExpenses();
		h.displayData(lol);
		h.createExpenses();
		
		double totBenefits = h.totalBenefits();
		System.out.println("The sum of all the salaries paid was: " + totBenefits);
		
		System.out.println("The total operating expenses were: "+h.getRecurringExpenses());
		
		System.out.println("The total of all expenses were: "+h.getTotalExpenses());
	}
}






