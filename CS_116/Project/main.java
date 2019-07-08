import java.util.*;
import java.io.*;

public class main
{
    public static void main(String[]args)
    {
        readData rd = new readData();
        Vector<xyplane> allpoints = rd.readAll();
        /*for(int i = 0; i<allpoints.size(); i++)
        {
            System.out.println(allpoints.get(i).toString());
        }
        */
        calculate calc = new calculate();
        Vector<Double> dis = calc.distance(allpoints);
        //System.out.println(dis.size());
        for(int l = 0; l<dis.size(); l++)
        {
            System.out.println(dis.get(l));
        }
        
        Vector<Double> mag = calc.magnitude(allpoints,dis);
        /* for(int t = 0; t<mag.size(); t++)
        {
            System.out.println(mag.get(t));
        }
        */
        System.out.println(mag.size());
        Vector<sinandcos> tes = calc.charge(allpoints,mag);
        for(int r = 0; r<tes.size(); r++)
        {
           //System.out.println(tes.get(r).toString());
        }
        
    }
    
}