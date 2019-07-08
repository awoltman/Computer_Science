import java.util.*;
import java.io.*;

public class echarge extends xyplane
{
    public int r;
    public String point;
       
    public echarge()
    {
        x = 0;
        y = 0;
        point = " ";
        
    }
    public echarge(String porQ1, String str, int l, int t)
    {
        super(porQ1,l,t);
        point = str;    
    }
    public String getPoint()
    {
        return point;
    }
    public void setQ(String s)
    {
        point=s;
    }
    
    public String toString()
    {
        String st ="This is point:"+ point + super.toString();
        return st;
    }
    public void distance()
    {
        
    }
    public void magnitude()
    {

    }
    public void charge()
    {

    }
}
    
