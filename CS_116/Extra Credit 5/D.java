public class D extends C
{
    String str;
       public D()
	   {
			super();
			str = " ";
           System.out.println("default constructor of D is executing now");
	   }

	   public D(int x4, double y4, double s1,String t)
	   {
		    super(x4,y4,s1);
			str = t;
	   }

	   public String getSTR()
	   { 
		   return str;
	   }

	   

	   public  void setSTR(String s2)
	   {
			str=s2;
	   }

	 

	   public String toString()
	   {
		   String out;
		   out=super.toString()+"The value of STR = "+str;
		   return out;
	   }
       public void m3()
       {
           super.m3();
           System.out.println("I am executing m3 as implemented in  class D");
       }
       public int m2(char c)
       {
           if (c=='e')
           {
               System.out.println("The m2(char c) version of D is executing now with returned value:"+super.m2('e'));
               return super.m2('e');
           }
           else
           {
                System.out.println("The m2(int x1) version of D is executing now with returned value:"+super.m2(100));
                return super.m2(100);
           }
           
           
       }


}