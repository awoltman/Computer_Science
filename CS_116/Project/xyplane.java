import java.util.*;
import java.io.*;

public abstract class xyplane implements Basics,Serializable
{
    public String type;
    public int x;
    public int y;
    public double k= 8.99*Math.pow(10,9);
    
    public xyplane()
    {
        type = " ";
        x = 0;
        y = 0;
        
    }
    public xyplane(String s,int l, int t)
    {
        type = s;
        x=l;
        y=t;
    }
    public String getType()
    {
        return type;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setType(String d)
    {
        type = d;
    }
    public void setX(int r)
    {
        x=r;
    }
    public void setY(int r)
    {
        y=r;
    }
    public String toString()
    {
        String st = " ";
        return st;
    }    
   
    public abstract void distance();
    public abstract void magnitude();
    public abstract void charge();
}