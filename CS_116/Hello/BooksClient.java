//George Koutsogiannakis
//package ClientClass;
import java.util.*;
//import ClientClass.ServiceClasses.*;
public class BooksClient
{
	public static void main(String[] args) 
	{
		BooksData bd=new BooksData();
		Vector v=bd.vectorBooks();
		Books b1=new Books(22,"Hard Cover", BookType.HISTORY);
		v.set(4,b1);
		Vector sorted=bd.sortVector(v);
		for(int i=0; i<sorted.size(); i++)
		 System.out.println(sorted.get(i).toString());
	    int index=bd.binarySearchVector(sorted, 33.6);
		if(index!=-1)
	    {
			System.out.println("The book was found:"+" "+sorted.get(index).toString());
		    System.out.println("The book was at index:"+" "+index);
		}
		else
			System.out.println("The book was not found");
	}
}
/* OUTPUT

C:\CS116\FALL2012\EXAMS\MIDTERM\MidTermSolution\Question1>java ClientClass.BooksClient
The size of vector passed is:7
The cost of the book is: 50.0 The cover type is: Hard Cover The book type is: HISTORY
The cost of the book is: 44.5 The cover type is: Hard Cover The book type is: SHORTSTORIES
The cost of the book is: 22.0 The cover type is: Hard Cover The book type is: HISTORY
The cost of the book is: 20.23 The cover type is: Soft Cover The book type is: FICTION
The cost of the book is: 20.0 The cover type is: Soft Cover The book type is: NONFICTION
The cost of the book is: 15.0 The cover type is: Hard Cover The book type is: NONFICTION
The cost of the book is: 13.5 The cover type is: Soft Cover The book type is: FICTION
The book was not found 
*/