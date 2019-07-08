import java.util.*;
import java.io.*;

public class readData
{
    public readData()
    {

    }
    public Vector<xyplane> readAll()
    {
        Vector <xyplane> points =null;
         try
        {
        System.out.println("Please enter the name of the text file with .txt");
        Scanner file = new Scanner(System.in);
        String filename = file.nextLine();
        File ofile = new File(filename);
        Scanner scan = new Scanner(ofile);
        int counter=0;
        while(scan.hasNextLine())
        {
            scan.nextLine();
            counter ++;
        }
        try
        {
            points= new Vector <xyplane>(counter);
            FileInputStream fis = new FileInputStream(ofile);
            BufferedReader scan1 = new BufferedReader(new InputStreamReader(fis));
        for(int t=0 ;t<counter ;t++)
        {
            String line = scan1.readLine();
            StringTokenizer tok = new StringTokenizer(line, ":,");
            String type = tok.nextToken();
            
            if(type.equals("Q"))
            {
                String x1 = tok.nextToken();
                int x = Integer.parseInt(x1);
                String x2 = tok.nextToken();
                int y = Integer.parseInt(x2);
                String x3 = tok.nextToken();
                double xy = Double.parseDouble(x3);
                pcharge pc = new pcharge(type,x,y,xy);
                points.add(pc);
                
                
            }
            else if(type.equals("P"))
            {
                String x3 = tok.nextToken();
                String x1 = tok.nextToken();
                int x = Integer.parseInt(x1);
                String x2 = tok.nextToken();
                int y = Integer.parseInt(x2);
                echarge pc = new echarge(type,x3,x,y);
                points.add(pc);
                
            }
            else
            {
               throw new notTypeException();
            }
        }
        }
        catch(notTypeException te)
        {
            System.out.println(te.getMessage());
            System.out.println(te.toString());
        }
        
        }
        catch(IOException ioe)
        {
            System.out.println(ioe.toString());
        }
        finally
        {
            return points;
        }
    }
}