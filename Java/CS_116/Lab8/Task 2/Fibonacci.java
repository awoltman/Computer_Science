public class Fibonacci
{
	public static void main (String[] args)
	{
		long counter = 0;
		while (counter <= 50)
		{
			System.out.println("The Fibonacci of " + counter + " is: " +  fibonacci(counter));
			counter++;
		}
	}
	
	public static int fibonacci(long num)
	{
		if (num == 0)
			return 0;
		if (num == 1 || num == 2 )
			return 1;
		else
			return (fibonacci(num -1) + fibonacci(num - 2));
	}
}