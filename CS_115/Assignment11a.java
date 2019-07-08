public class Assignment11a
{
//Number 50
public static int Assignment50()
{
final int ARRAY_SIZE = 1000;
int product=1;
int[]numArray=new int[ARRAY_SIZE];
for(int i=0; i < ARRAY_SIZE; i++)
{
	int number = numArray[i];
	product *= number;
}
return product;
}

//Number 52
public static void Assignment52()
{
	final int ARRAY_SIZE2 = 1000;
	float[] numArray2 = new float[ARRAY_SIZE2];
	for(int j=0;j<ARRAY_SIZE2;j++)
	{
		numArray2[j]= 2*j;
	}}
//Number 54
public static double Assignment54()
{
	final int ARRAY_SIZE3 = 1000;
	int maxIndex = 0;
	int minIndex = 0;
	double max = 0;
	double min = 1000000;
	double[] numArray3 = new double [ARRAY_SIZE3];
	for(int k=1;k<ARRAY_SIZE3; k++)
	{
		if(numArray3[k]>numArray3[maxIndex])
		{
			maxIndex = k;
			max = numArray3[k];
		}
	for(int l=1;k<ARRAY_SIZE3; l++)
		if(numArray3[l]>numArray3[minIndex])
		{
			minIndex = l;
			min = numArray3[l];
		}
	}
	double difference = max-min;
	return difference;
}
//Number 55
public static int Assignment55(int [] numArray4)
{
	int total = 0;
	//int[] numArray4 = new int [ARRAY_SIZE4];
	for(int m =1; m < numArray4.length;m += 2)
	{
		int number2 = numArray4[m];
		total += number2;
	}
	return total;
}
public static void main(String[]args)
{
	int [] array = new int[10];
	for(int i =0;i<array.length;i++)
	{
		array[i]=i+1;
	}
	System.out.print("the sum is:" +Assignment55(array));
}
}