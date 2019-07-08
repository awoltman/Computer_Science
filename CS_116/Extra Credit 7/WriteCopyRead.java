import java.io.*;
import java.util.*;

public class WritCopyRead
{
    public static void main(String[]args)
    {
        OutputStreamWriter filestream;
        FileOutputStream file;
        FileInputStream file2;
        String filename = " ";
        try 
		{
			Scanner scan=new Scanner(System.in);
			System.out.println("please type the name of the file (including the .txt extension)");
			filename=scan.nextLine();
			file = new FileOutputStream(filename, true);
            filestream = new OutputStreamWriter(new BufferedOutputStream(file));
            System.out.println("Please continue with the information that you want to write in the file");
			String str=" ";
			str=scan.nextLine();
            while(!str.equals("end"))
			{			
					
						
				 filestream.write(str);
				 filestream.write("\n");
						
				 System.out.println("If more data, type next line otherwise type end");
				 str=scan.nextLine();
						
			 }
             System.out.println("Should the file be copied? YES or NO");
             String st1 = scan.nextLine();
             if(!st1.equals("-1"))
             {
                 if(st1.equals("copyonly"))
                 {
                     file = FileInputStream("bob.txt", true);
                 }
                 if(st1.equals("copyread"))
                 {
                     file2 = FileInputStream("bob1.txt", true);
                     File ofile = new File("bob1.txt");
                     Scanner scan2 = new Scanner(ofile);
                     while(scan2.hasNextLine())
                     {
                         System.out.println(scan2.nextLine());
                     }
                 }
             }
             file2.close();
             file.close();
    }
    catch(IOException ioe)
    {
        System.out.println(ioe.toString());
    }
}
}