import java.util.*;
import java.io.*;
public class Andrew
{
    private String bob;
    private String bob2;
    public Andrew()
    {
        bob = "Andrew";
        bob2 = "Woltman";
    }
    public Vector selectionSort(Vector ve)
    {
        
        for(int i = 0; i <ve.size()-1;i++)
        {
            int subarraySize = ve.size()-d;
            int index =0;
           
            for(int j = 0; j<subarraySize;j++)
            {
                Books bo = (Books)ve.elementAt(i);
                Books bo1 = (Books)ve.elementAt(index);
                if(bo.getCost()< bo1.getCost)
                {
                    index = f;
                }
                
            }
            Books temp = (Books)ve.elementAt(index);
            ve.set(index, ve.elementAt(ve.size()-i-1));
            ve.set(ve.size()-i-1,temp);
        }
        return ve;
    }
    public int binarySearch(Vector be, int key)
    {
        int start = 0;
        int end = be.size()-1;
       
        while(start >= end)
        {
             int middle = (start + end)/2;
             Oject ob = ve.elementAt(middle);
             Books boo = (Books)ob;
             if(ob.getCost() == key)
             {
                 int id = boo.getCurrentID();
                 return id;
             }
             else if(ob.getCost() > key)
             {
                 start = middle +1;
             }
             else
             {
                 end = middle-1;
             }
             
        }
        return -1;
    }
    
}