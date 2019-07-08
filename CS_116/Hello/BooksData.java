//George Koutsogiannakis
//package ClientClass.ServiceClasses;
import java.util.*;
import java.io.*;
public class BooksData
{
	public Vector vectorBooks()
	{
		BookType et=null;
		Vector v=new Vector();
		try
		{
			File file=new File("books.txt");
			Scanner scan=new Scanner(file);
			while(scan.hasNextLine())
			{
				String line=scan.nextLine();
				StringTokenizer strtok=new StringTokenizer(line, ",");
				String str1=strtok.nextToken();
				double ex=Double.parseDouble(str1);
				String str2=strtok.nextToken();
				String str3=strtok.nextToken();
				if(str3.equals("FICTION"))
				   et=BookType.FICTION;
				else if(str3.equals("NONFICTION"))
				   et=BookType.NONFICTION;
				else if(str3.equals("HISTORY"))
				   et=BookType.HISTORY;
				else if(str3.equals("SHORTSTORIES"))
				   et=BookType.SHORTSTORIES;
				
				else if(str3.equals("RELIGION"))
				   et=BookType.RELIGION;
				else if(str3.equals("NONE"))
				   et=BookType.NONE;
				
				Books books=new Books(ex,str2,et);
				v.addElement(books);
			}
		}
		catch(IOException  ioe)
		{
			System.out.println("Something is wrong with the text file");
		}
		
		
			return v;


	}


		public Vector sortVector(Vector mv)
		{
					
					Books temp;
					
					System.out.println("The size of vector passed is:"+mv.size());
					int subarraylength=0;
						for(int d=0; d<=mv.size()-1; d++)
						{
							subarraylength=mv.size()-d;
							int index=0;
							for(int f=1; f<subarraylength; f++)
							{
								Object obj=mv.elementAt(f);
								Books e=(Books)obj;
								Object obj1=mv.elementAt(index);
								Books e1=(Books)obj1;
								
								if(e.getCost()<e1.getCost())
								{
										index=f;
								}
							}
								//do the swap now
								Object obj2=mv.elementAt(index);
								//temp=newArray[index];//equivalent array code
								temp=(Books)obj2;
								//newArray[index]=newArray[newArray.length-d-1]; //equivelant array code
								mv.set(index, mv.elementAt(mv.size()-d-1));
								
								//newArray[newArray.length-d-1]=temp;//equivalent array code
								mv.set(mv.size()-d-1, temp);

							}//end of passes
							
					
					
					return mv;
			}

			public int binarySearchVector(Vector vec, double key)
		{
			String str="";

		
			 
			  int index=0; 
			  
			  
			  int start = 0, end=vec.size()-1;
			  int middle=0;
			  while(end>=start)
			  {
					//System.out.println("inside while loop");
					middle=(start+end)/2;  
					//System.out.println("middle="+middle);
					Object ex=vec.elementAt(middle);
					Books bo=(Books)ex;
					if(bo.getCost()==key)
					{
					   index= middle;   // key found
					   return index;
					}
					else if(bo.getCost()<key )
						end=middle-1; // search left  
					else
						start=middle+1; // search right 
					
			  }
			      return -1;
		


		}//end binarySearch method


			
		
}
