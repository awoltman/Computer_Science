public class Client
{
    public static void main(String[]args)
    {
        B new1 = new B();
        new1.method1();
        B new2 = new B(1,"Hello",12.5);
        System.out.println(new2.method2(10));
        System.out.println(new2.toString());
    }
}