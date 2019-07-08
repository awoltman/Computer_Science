import java.util.*;
import java.io.*;

public class calculate extends pcharge
{
    public calculate()
    {
        
    }
    public Vector<Double> distance(Vector point)
    {
        Vector <xyplane> points = point;
        Vector <xyplane> ps = new Vector();
        Vector <xyplane> qs = new Vector();
        Vector <Double> dists = new Vector() ; 
        for(int x = 0; x<points.size();x++)
        {
            if(points.get(x).getType().equals("Q"))
            {
                ps.add(points.get(x));
            }
            else if(points.get(x).getType().equals("P"))
            {
                qs.add(points.get(x));
            }
        }
        double distance;
        for(int z= 0; z< qs.size();z++)
        {
        for(int t = 0; t < ps.size();t++)
        {
            int x = ps.get(t).getX();
            int y = ps.get(t).getY();
            int x1 = qs.get(z).getX();
            int y1 = qs.get(z).getY();
            int l = x-x1;
            int l1 = y-y1;
            distance = Math.sqrt((Math.pow((x-x1),2))+(Math.pow((y-y1),2)));

            dists.add(distance);
        }
        }
        return dists;
    }
    public Vector<Double> magnitude(Vector point,Vector re)
    {
        Vector<Double> mags = new Vector();
        Vector<Double> fe = re;
        Vector<xyplane> points = point;
        double e = 0;
        int counter = 0;
        for(int x = 0; x<points.size();x++)
        {
            if(points.get(x).getType().equals("Q"))
            {
                counter++;
            }
            else if(points.get(x).getType().equals("P"))
            {
                
            }
        }
        for(int r =0; r<counter;r++)
        {
            pcharge the = (pcharge)(points.get(r));
        for(int x = 0; x<fe.size(); x+=2)
        {
            
            e= (k*the.getQ())/(Math.pow(fe.get(x),2));
            System.out.println("The mag is:"+e);
            mags.add(e);
        }
        }
        return mags;
        
    }
    public Vector<sinandcos> charge(Vector point ,Vector v)
    {
         Vector <xyplane> points = point;
         Vector <Double> dists =v; 
         Vector <sinandcos> totals = new Vector();
         Vector <echarge> epoints = new Vector();
         Vector <pcharge> cpoints = new Vector();
         int counter = 0;
         int counter1 = 0;
         
        for(int x = 0; x<points.size();x++)
        {
            if(points.get(x).getType().equals("Q"))
            {
                
            }
            else if(points.get(x).getType().equals("P"))
            {
                echarge te = (echarge)points.get(x);
                epoints.add(te);
            }
        }
        for(int x = 0; x<points.size();x++)
        {
            if(points.get(x).getType().equals("Q"))
            {
                pcharge we = (pcharge)points.get(x);
                cpoints.add(we);
            }
            else if(points.get(x).getType().equals("P"))
            {
                
            }
        } 
        System.out.println(epoints.size());
        for(int w =0; w<epoints.size();w++)
        {
         for(int r = 0; r<cpoints.size();r++)
         {
         for(int x =0; x< dists.size(); x++)
         {
             
             pcharge the = (pcharge)(cpoints.get(r));
             double l = dists.get(x);
                 echarge the1 = (echarge)(epoints.get(w));

            // System.out.println(the1.toString());
             double s = the.getX()-the1.getX();
             double s1 = the.getY()-the1.getY();
             double angle = Math.atan(s1/s);
             double sin = Math.sin(angle)*l;
             double cos = Math.cos(angle)*l;
             sinandcos re = new sinandcos(the.getType(),the.getX(),the.getY(),the.getQ(),sin,cos,l,Math.sin(angle),Math.cos(angle));
             
             /*System.out.println(" ");
             System.out.println("The value of w ="+w);
             System.out.println(" ");
             System.out.println(" ");
             System.out.println("The value of r ="+r);
             System.out.println(" ");
             System.out.println(" ");
             System.out.println("The value of x ="+x);
             System.out.println(" ");
             System.out.println(re.toString());*/
             
             
             
             if((r==0 && x==1) || (r==1 && x==0))
             {
                 totals.add(re);
             }
             
         } 
         } 
        }       
         return totals;
    }
    
}