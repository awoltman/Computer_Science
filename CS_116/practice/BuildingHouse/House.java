public class House extends Building
{
	int numBedRooms=0;
	String type=" ";
    private int lotsize;
	public House()
	{
		super();
		numBedRooms=1;
		type="Ranch";
	}
	public House(int nb, String ty)
	{
		super(150000.0, 1500);
		setNumBedRooms(nb);
		setType(ty);
	}
	public int getNumBedRooms()
	{
		return numBedRooms;
	}
	public void setNumBedRooms(int br)
	{
		numBedRooms=br;
	}
	public String getType()
	{
	    return type;
	}
	public void setType(String t)
	{
	    type=t;
	}

	//override the setLotSize mutator method of Building
	public void setLotSize(int lz)
	{
		super.setLotSize(lz+1000);
	}

	//method overloading. Overload teh method setNumBedRooms

	public void setNumBedRooms()
	{
		numBedRooms = 10;
	}

	public String toString()
	{
		String output=super.toString()+" "+"num bedrooms:"+" "+numBedRooms+" "+"type:"+" "+type;
		return output;
	}
}
