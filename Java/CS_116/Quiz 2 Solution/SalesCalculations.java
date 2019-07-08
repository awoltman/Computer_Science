//George Koutsogiannakis
package Compiled;
import java.util.*;
import java.io.*;
public class SalesCalculations implements Sales 
{
	//static double totalBroomsSales=0.0;
	//static double totalShovelsSales=0.0;
	public ArrayList<Manufacturing> dataReader() 
	{      
			ArrayList<Manufacturing> list=new ArrayList<Manufacturing>();
			try{
						File file=new File("data.txt");
						Scanner scan=new Scanner(file);
						
						String reading=" ";
						 
						
						while(scan.hasNextLine()) 
						{
							
						    
							Locations ga=null;
							int q=0;
							String weath=" ";
							reading=scan.nextLine();
							System.out.println(reading);
							StringTokenizer strtok=new StringTokenizer(reading,",");
							String name=strtok.nextToken();
							
							if(name.equals("consumer product"))
							{
								
									weath=strtok.nextToken();
									String quant=strtok.nextToken();
									q=Integer.parseInt(quant);
									String ar=strtok.nextToken();
									ga=Locations.valueOf(ar);
								    String i=strtok.nextToken();
									int in=Integer.parseInt(i);
								    ConsumerProducts br=new ConsumerProducts(name,q,ga,weath,in);
									list.add(br);
							}
							else if(name.equals("industrial product"))
							{
								
									String quant=strtok.nextToken();
									int q1=Integer.parseInt(quant);
									String ar1=strtok.nextToken();
									ga=Locations.valueOf(ar1);
								    
									int sf=Integer.parseInt(strtok.nextToken());
									IndustrialProducts com=new IndustrialProducts(name,q1,ga,sf);
									//System.out.println(com.toString());
									list.add(com);
								
								
							}
							
							
							
						}
						
						
						
					}//   end of try
					catch(IOException ioe)
					{
							System.out.println(ioe.toString()); 
					}
					
				
					return list;
		}

	public double totalConsumerSales(ArrayList<Manufacturing> al)
	{
		double up=0.0;
		double total=0.0;
		for(Manufacturing p: al)
		{ 
			if(p.getProductName().equals("consumer product"))
			{
				try
				{
					up=p.unitPrice();
				}
				catch (HighPriceException hp)
				{
				
					System.out.println("The exception was thrown again in total sales calculations for consumer products");
				
				}
				finally
				{
				    //System.out.println("The total="+total);
					total=total+up*p.getQuantitySold();
				}
			}
			
		}
		//System.out.println(totalComputerSales);
		return total;

	}

	public double totalIndustrialSales(ArrayList<Manufacturing> al)
	{
		double up=0.0;
		double total=0.0;
		for(Manufacturing p: al)
		{
			if(p.getProductName().equals("industrial product"))
			{
			   try
			   {
			   		up=p.unitPrice();
					System.out.println(up);
			   }
			   catch (HighPriceException hp)
				{
				
					System.out.println("The exception was thrown again in total sales calculations for industrial products");
				    
				}
			   finally
				{
			        
				     total=total+up*p.getQuantitySold();
						 System.out.println(total);
			    }
			}
			//System.out.println(totalTelevisionSales);
		}
		//System.out.println(totalComputerSales);
		return total;

	}
}
