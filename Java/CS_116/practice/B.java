public class B extends A
{
    public double g;
    private int r;
    public B()
    {
        System.out.println("The default custructor of B was executed");
    }
    public B(int s, String t, double r)
    {
        super(s,t);
        System.out.println("The non default constructor of B was executed");
        g = r;
    }
    public int method2(int h)
    {
        System.out.println("method 2 of B was executed");
        method1();
        return h*2;
    }
    public String toString()
    {
        String new1 = super.toString();
        String new2 = new1 + " " + g;
        return new2;
    }
}