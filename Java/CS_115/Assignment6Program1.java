/*
	Number 1
		[]The code runs forever
		
	Number 2
		[]do-while
		
	Number 3
		[] It is a count-controlled loop
		
	Number 4
		[] True
		
	Number 9
		[] i = 8
		[] product = 336
		
	Number 10
		[] i = 7
		[] product = 42
	Number 11
		[] Hello
		[] Hello
		[] Hello
		[] Done
	Number 12
		[] Hello
		[] Hello
		[] Hello
		[] Done
	Number 13
		[] i = 3
	Number 14
		[] i = 2034
	Number 15
		[] i = 5
		[] sum = 10 
	Number 16
		[] i = 40
		[] sum = 60
	Number 17
		[]  sum = 20
	Number 18
		[]  sum = 121
	Number 36
		[] you need a semicolan  after the while statment in a do while loop
	Number 37
		[] the statment will always be true because you start at 0 and you decrease by 1 every time
		therfore the number will always be less than 3 and the condition will never be false
	Number 38
		[] he flipped the condition and whe statment it should be for(int i = 0; i < 3; i++)
	Number 39
		[] you are off by one, you have to change the initial condition of i, change it to i = 0
	Number 40
		[] you used commas instead of semicolans, it should read for(int i = 1; i < 5; i++)
	Number 41
		[] you only initialized the variable i inside the  for loop, and there for you can not use it outside of the 
	Number 42
		[] you initialized i twice
*/

public class Assignment6Program1
{

public static void main(String[]args)
	{
		int sum = 0;
			for (int i = 10; i < 21; i++)
			sum += i;
	
		System.out.print("The sum is: "+ sum);
	}
}
	