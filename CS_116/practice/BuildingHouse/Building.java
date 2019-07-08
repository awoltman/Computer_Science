public class Building
{
	private double cost=0.0;
	int lotSize=0;
	public Building()
	{
		cost=100000.0;
		lotSize=1000;
	}

	public Building(double c, int ls)
	{
		setCost(c);
		setLotSize(ls);
	}

	public double getCost()
	{
		return cost;
	}
	public void setCost(double co)
	{
		cost=co;
	}
	public int getLotSize()
	{
		return lotSize;
	}
	public void setLotSize(int lots)
	{
		lotSize=lots;
	}
    
	public String toString()
	{
		String output="The cost is:"+" "+cost+" "+"and the lot size is:"+" "+lotSize;
		return output;
	}
}
