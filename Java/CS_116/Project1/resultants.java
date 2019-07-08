import java.util.*;
import java.io.*;

public class resultants
{
	public resultants()
	{
		
	}
public void  resultant(Vector point)
    {
       Vector <sinandcos> results= point;
        String filename = "resultants.ser";
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
        
		try
		{
			fos = new FileOutputStream(filename, true);
			out = new ObjectOutputStream(fos);
            
			for(int x = 0;x<results.size(); x++ )
			{
				out.writeObject(results.get(x));
			}
			out.close();
			fos.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
        System.out.println("If you want to read the ser file type read");
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        if(str.equals("read"))
        {
            try
            {
                FileInputStream fIn = new FileInputStream("resultants.ser");
				ObjectInputStream o = new ObjectInputStream(fIn);
                while(true)
                {
                    try
                    {
                    	sinandcos some = (sinandcos)o.readObject();
						sinandcos something = (sinandcos)o.readObject();
						double resultx = some.getX1()+something.getX1();
						double resulty = some.getY1()+something.getY1();
						double result = Math.sqrt(Math.pow(resultx,2)+Math.pow(resulty,2));
                    	System.out.println(some.toString());
						System.out.println(something.toString());
						System.out.println(" ");
						System.out.println("The magnitude of the resultant field is: "+" "+result+" "+"at:" +" "+ some.getPoint());
						System.out.println(" ");
                    }
                    catch(EOFException eof)
                    {
                        System.out.println(eof.getMessage());
						fIn.close();
						o.close();
                        break;
                    }
                }
            }
            catch(ClassNotFoundException fnf)
			{
				System.out.println("The class was not found");
			}
            catch(IOException ioe)
			{
				System.out.println(ioe.getMessage());
			}
        }
        
    }
}