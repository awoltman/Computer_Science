public class A implements bob
{
    public int d;
    private String s;
    public  A()
    {
        System.out.println("This is the default constructor of A");
        d= 0;
        s = " ";
    }
    public A(int r, String t)
    {
        System.out.println("This is the non default constructor of A");
        d=r;
        s = t;
    }
    public void method1()
    {
        System.out.println("method1 of A executed");
    }
    public String toString()
    {
        String str = d +" " + s;
        return str;
    }
    public double calculateA()
    {
        double f = 1000000000;
        return f;
    }
}
