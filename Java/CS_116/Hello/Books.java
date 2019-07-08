//George Koutsogiannakis
package ClientClass.ServiceClasses;
public class Books
{
	double cost=0.0;
	String cover_type=" ";
	private BookType bt;
	 public Books()
	{
		 cost=10.0;
		 cover_type="Hard Cover";
		 bt=BookType.NONE;
	}

	public Books(double c,String ct,BookType boty)
	{
		cost=c;
		cover_type=ct;
		bt=boty;
	}

	public double getCost()
	{
		return cost;
	}

	public String getCoverType()
	{

		return cover_type;
	}

	public BookType  getBookType()
	{
		return bt;
	}

	public void setCost(double co)
	{
		cost=co;
	}

	public void setCoverType(String str)
	{
		 cover_type=str;
	}

	public void setBookType(BookType bty)
	{
		bt=bty;
	}

	public boolean equals(Books b)
	{
		if((this.getCost()==b.getCost())&&(this.getBookType().equals(b.getBookType())))
			return true;
		else
			return false;
	}
	public String toString()
	{
		String out="The cost of the book is:"+" "+cost+" "+"The cover type is:"+" "+cover_type+" "+"The book type is:"+" "+bt;
		return out;
	}
}