public class C extends A
{
    public double c=0.0;

		public C()
	   {
			super();
			c=0;
            System.out.println("default constructor of C is executing now");
	   }

	   public C(int x4, double y4, double s1)
	   {
		    super(x4,y4);
			c=s1;
	   }

	   public double getS()
	   { 
		   return c;
	   }

	   

	   public  void setS(double s2)
	   {
			c=s2;
	   }

	 

	   public String toString()
	   {
		   String out;
		   out=super.toString()+"The value of C = "+c;
		   return out;
	   }

	   public int m1()
	   {
		   int  i2= a+(int)(c/2);
           System.out.println("m1 implementation of C is executing now");
           return i2;

	   }
}