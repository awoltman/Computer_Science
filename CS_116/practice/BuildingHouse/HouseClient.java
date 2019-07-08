public class HouseClient  
{
	public static void main(String[] args) 
	{
		House h1=new House();
		System.out.println("h1 attributes are:"+h1.toString());
		h1.lotSize=2000;
		//Notice that for cost we have to invoke the mutator method because it is a private attribute
		//of Building
		//Set cost to 200000.0
		h1.setCost(200000.0);
		
		System.out.println("h1 attributes are now:"+h1.toString());
		//now let us reset the size of the building by invoking the overriden method setLotSize
		h1.setLotSize(h1.getLotSize());
		
		System.out.println("h1 attributes are now:"+h1.toString());
		House h2=new House(3,"BiLevel");
		System.out.println("h2 attributes are:"+" "+h2.toString());
		//Check number of bedrooms after invoking overloded method
	    h2.setNumBedRooms();
		
		System.out.println("Number of bedroom snow="+" "+h2.getNumBedRooms());
	}
}
/*OUTPUT
---------- Java Interpreter ----------
---------- Java Interpreter ----------
h1 attributes are:The cost is: 100000.0 and the lot size is: 1000 num bedrooms: 1 type: Ranch
h1 attributes are now:The cost is: 200000.0 and the lot size is: 2000 num bedrooms: 1 type: Ranch
h1 attributes are now:The cost is: 200000.0 and the lot size is: 3000 num bedrooms: 1 type: Ranch
h2 attributes are: The cost is: 150000.0 and the lot size is: 2500 num bedrooms: 3 type: BiLevel
Number of bedroom snow= 10

Output completed (0 sec consumed) - Normal Termination
*/