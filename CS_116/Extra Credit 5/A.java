public abstract class A
{
    public int a;
    public double aa;
    public A()
    {
        a = 3;
        aa = 4.0;
       System.out.println("default constructor of A is executing now");
    }
	   public A(int x1, double y1)
	   {
		    a=x1;
			aa=y1;
	   }

	   public int getA()
	   { 
		   return a;
	   }

	   public double getAA()
	   {
			return aa;
	   }

	   public  void setA(int x2)
	   {
			a=x2;
	   }

	   public void setAA(double y2)
	   {
			aa=y2;
	   }

	   public String toString()
	   {
		   String out;
		   out="The value of A = "+a+" "+"The value of AA = "+aa;
		   return out;
	   }
       public  int  m2(char a)
       {
           int  x=(int)a;
           System.out.println("m2 of A is executing now");
           return x;
       }
       public int m2(int  x1)
       {
           int y=10+x1;
           System.out.println("second version of m2 in A is executing now:"+y);
           return y;
       } 
       public void m3()
       {
           System.out.println("m3 of A is executing now");
       }
       public abstract int m1();



}