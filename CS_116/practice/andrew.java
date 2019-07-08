public class andrew
{
    public static void main(String []args)
    {
        printNtimes(12);
        int re = factorial(10);
        System.out.println(re);
        int counter = 0;
		while (counter <= 20)
		{
			System.out.println("The Fibonacci of " + counter + " is: " +  fibonacci(counter));
			counter++;
		}
    }
    public static void printNtimes(int n)
    {
        if(n>0)
        {
            System.out.println("hello world");
            printNtimes(n-1);
        }
        else
        {
            
        }
    }
    public static int factorial(int n)
    {
        int total = 1;
        if(n<=0)
        {
            return 1;
        }
        else
        {
            total = n*factorial(n-1);
            return total;
        }
    }
    public static int fibonacci(int num)
	{
		if (num == 0)
			return 0;
		if (num == 1 || num == 2 )
			return 1;
		else
			return (fibonacci(num -1) + fibonacci(num - 2));
	}
}