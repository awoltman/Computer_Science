#include <stdio.h>
#include <stdlib.h>

int main()
{
    int number =6;
    int count = 1;
    int tempnum;
    int total =0;

    while(count<=33)
    {
        tempnum = count * number;
        total = total + tempnum;
        count++;
    }
    printf("The total is: %d\n",total);
    return 0;
}