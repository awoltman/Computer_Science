import java.util.*;
import java.io.*;

public class sinandcos extends pcharge
{
    public double magnitude;
    public double sin;
    public double cos;
    public double angle;
    public double cos1;
    public double sin1;
    public String point;
    
    public sinandcos()
    {
        
        sin = 0.0;
        cos = 0.0;
        magnitude = 0.0;
        double angle =0.0;
        point = " ";
    }
    public sinandcos(String porQ1,String point1, int l, int t, double e,double x,double y,double mag,double sin2,double cos2)
    {
        super(porQ1,l,t,e);
        sin = x;
        cos = y;
        sin1 = sin2;
        cos1 = cos2;
        magnitude =mag;  
        point = point1;    
    }
    public void setPoint(String r)
    {
        point =r;
    }
    public void setX1(double r)
    {
        cos=r;
    }
    public void setY1(double r)
    {
         sin=r;
    }
    public void setX2(double r)
    {
        cos1=r;
    }
    public void setY2(double r)
    {
         sin1=r;
    }
    public void setMag(double r)
    {
        magnitude=r;
    }
    public String getPoint()
    {
        return point;
    }
    public double getX1()
    {
        return cos;
    }
    public double getY1()
    {
        return sin;
    }
    public double getX2()
    {
        return cos1;
    }
    public double getY2()
    {
        return sin1;
    }
    public double getMag()
    {
        return magnitude;
    }
    public String toString()
    {
        String str = "The magnitude of the Electical field at:"+" "+point+" "+"is:"+" "+magnitude+"\n"+super.toString()+"\n"+"The cos of the Electical field  is:"+cos1+"\n"+"The valure of the x component of the Electical field  is:"+cos+"\n"+"The sin of the Electical field  is:"+sin1+"\n"+"The value of the y component of the Electical field  is:"+sin;
        return str;
    }
    
}