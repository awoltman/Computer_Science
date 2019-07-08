public class B extends A
{
    public String s;
    public B()
    {
        super();
        s= "none";
        System.out.println("default constructor of B is executing now");
    }
    public B(int j, double i, String f)
    {
        super(j,i);
        s = f;
    }
    public String getS()
    {
        return s;
    }
    public void setS(String t)
    {
        s = t;
    }
    public String toString()
    {
        String out = super.toString()+ "The value of s is:"+s;
        return out;
    }
    public int m1()
    {
        int  i1= 5*a+(int)aa;
        System.out.println("m1 implementation of B is executing now");
        return i1;
    }
    

}