import java.util.*;
import java.io.*;

public class main
{
    public static void main(String[]args)
    {
        readData rd = new readData();
        Vector<xyplane> allpoints = rd.readAll();

        calculate calc = new calculate();
        Vector<Double> dis = calc.distance(allpoints);

        Vector<Double> mag = calc.magnitude(allpoints,dis);
        
        Vector<sinandcos> tes = calc.charge(allpoints,mag);
        resultants re = new resultants();
        re.resultant(tes);
        
    }
    
}