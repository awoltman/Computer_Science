/*Number 1
	[] int [] a
	[] int a []
  Number 2
	[] 0
  Number 3
	[] 29
  Number 4
	[] 0
  Number 5
	[] a[6]
  Number 7
	[] a.length
  Number 13
	[] 12.5
  Number 14
	[] 0
  Number 15
	[] 3
  Number 16
	[]  12
		48
		65
  Number 17
	a[ 1 ] = 12
	a[ 2 ] = 48
	a[ 3 ] = 65
  Number 22
	[]
  Number 23
	[] adds one to temp if the value of index i equals 5, and goes until the end of the index
  Number 24
	[] if an array element is negative then the method will return false
	Otherwise it will return true.
  Number 25
	[]returns the array temp which is the lowercase version of the array
	passed through the parameters
*/
public class Assignment11
{
//Number 50
public int Assignment50()
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
public void Assignment52()
{
	final int ARRAY_SIZE2 = 1000;
	float[] numArray2 = new float[ARRAY_SIZE2];
	for(int j=0;j<ARRAY_SIZE2;j++)
	{
		numArray2[j]= 2*j;
	}}
//Number 54
public double Assignment54()
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
public int Assignment55()
{
	final int ARRAY_SIZE4 = 1000;
	int total = 0;
	int[] numArray4 = new int [ARRAY_SIZE4];
	for(int m =1; m < ARRAY_SIZE4;m += 2)
	{
		int number2 = numArray4[m];
		total += number2;
	}
	return total;
}
}