public class Client
{
    public static void main(String[]args)
    {
        A a;
        B bob = new B();        
        a = bob;
        System.out.println(a.m1());
        C bob1 = new C();
        a = bob1;
        System.out.println(a.m1());
        D bob3 = new D();
        a.m3();
        System.out.println(" ");
        bob3.m2('e');
        System.out.println(" ");
        bob3.m2('s');
    }
}