#include <stdio.h>
#include <stdlib.h>

void adding(int one,int two)
{
    int total = one + two;
    printf("The total of l and i is: %d \n",total);
    return;
}

int main()
{
    int l =0;
    for(int i=0; i<=10;i++)
    {
        printf("n is: %d \n",i);
        l = i-1;
        printf("t is: %d \n",l);
        adding(i,l);
        
    }
    return 0;
}