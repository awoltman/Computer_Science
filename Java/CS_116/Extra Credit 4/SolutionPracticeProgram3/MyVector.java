package Driverclass1;
import Driverclass1.DriversClient;
import Driverclass1.Driverclass2.Drivers;
import Driverclass1.Driverclass2.DriverType;
import java.util.*;
import java.io.*;
import java.text.*;
public class MyVector
{
    public static void main(String[]args)
    {
        Vector v = new Vector();
        Drivers d1 = new Drivers();
        d1.setName("John");
        d1.setAge(24);
        d1.setLicenses(345);
        d1.setYears(5.5);
        DriverType rt = DriverType.valueOf("Adult_Male_Driver");
        d1.setDriverType(rt);
        Drivers d2 = new Drivers();
        d2.setName("Mary");
        d2.setAge(18);
        d2.setLicenses(945);
        d2.setYears(2.5);
        DriverType bt = DriverType.valueOf("Teenager_Female_Driver");
        d2.setDriverType(bt);
        Drivers d3 = new Drivers();
        d3.setName("John");
        d3.setAge(44);
        d3.setLicenses(345);
        d3.setYears(15.5);
        DriverType lt = DriverType.valueOf("Adult_Male_Driver");
        d3.setDriverType(lt);
        v.addElement(d1);
        v.addElement(d2);
        v.addElement(d3);
        System.out.println("FIRST OUTPUT");
        for(int i = 0; i <v.size(); i++)
        {
            System.out.println(v.get(i).toString());
        }
        Drivers d4 = new Drivers();
        d4.setName("John");
        d4.setAge(24);
        d4.setLicenses(345);
        d4.setYears(55.5);
        DriverType bett = DriverType.valueOf("Adult_Male_Driver");
        d4.setDriverType(bett);
        Integer inter = new Integer(15);
        v.add(1,d4);
        v.addElement(inter);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("SECOND OUTPUT");
        for(int i = 0; i <v.size(); i++)
        {
            System.out.println(v.get(i).toString());
        }
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("THIRD OUTPUT");
        int k =0;
        
        for(int i=1; i<v.size()-1; i++)
		{
           Object o1 = v.elementAt(k);
           Drivers dc1 = (Drivers)o1;
		   Object o2= v.elementAt(i);
		   Drivers dc2= (Drivers)o2;
           if(dc1.equals(dc2))
			{
				System.out.println("Object with id= "+dc1.getPresentID()+" is equal with Object of id = "+dc2.getPresentID());
			}
            if(i == v.size()-2)
            {
                k++;
                i=k;
            }
		}
        v.clear();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("FORTH OUTPUT");
        System.out.println("The size of the vector is:"+" "+v.size());
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        int [][] bobs = {{9,8,7,6},{10,20,20,40}};
        System.out.println("Part B");
        int minInt = 9999;
        for(int m = 0;m <bobs.length;m++)
        {
            for(int z = 0; z< bobs[m].length;z++)
            {
                
                if(bobs[m][z] <minInt)
                {
                    minInt = bobs[m][z];
                }
            }
        }
        System.out.println("The minimum is:"+" "+minInt);
    }
}