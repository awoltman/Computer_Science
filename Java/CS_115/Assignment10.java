/*
	Number 1
		[] It must start with an uppercase letter
	Number 2
		[] They must be the sam name as the class name
	Number 3
		[] a constructor does not have a return type
	Number 4
		[] True
	Number 5
		[] It can be accessed directly only from inside its class
	Number 6
		[] Instance variables are private and methods are public
	Number 7
		[] 
	Number 8
		[] used to access and modift field variables of a class from outside the class
	Number 9
		[] no parameter
	Number 10
		[] one parameter, of the same type as the corresponding field
	Number 11
		[] return the same type as the corresponding field
	Number 38
		[] the code should read:
			public void Gift()
			{
				return price;
			}
	Number 39
		[] the code should read:
			public void Gift()
			{
				setOccasion(occasion)
			}
	Number 42
		[] the code should read:
			public void Gift()
			{
				setTaxRate(double newTaxRate)
			}
	Number 43
		[] the code should read:
			public void Gift()
			{
				
				return 
			}
	Number 44
		[] the error is that wherever it says Gift it should say GiftClient in the first line
		[] in the second line it should be g.setPrice(99.99)
	Number 45
		[]
*/
// Number 56

public class Television
{
	private String brand;
	private double price;

public Television()
	{
		brand = "not a tv";
		price = 0.0;
	}
public Television(String startBrand, double startPrice)
	{
		brand= startBrand;
		setPrice(startPrice);
	}
public String getBrand()
	{
		return brand;
	}
public double getPrice()
	{
		return price;
	}
public void setBrand(newBrand)
	{
		brand = newBrand;
	}
public void setPrice(newPrice)
	{
		price = newPrice;
	}
public String toString()
	{
		return "The brand is" +brand + "and the price is" +price;
		
	}
public boolean equal(Television a)
	{
		if(a.brand.equals(brand)&& a.price==price)
			return true;
		else()
			return false;
	}
}


















