import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class stores and reads poems
 * @author Burak YASAR
 * @version 09.03.2017
 */
public class PoemMenu
{
   private static ArrayList<MySimpleURLReader> msuReaderList = new ArrayList<MySimpleURLReader>();
   
   // main method
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      int selection;
      boolean exit;
      
      do
      {
         exit = true;
         System.out.println( "1. Enter the url of poem to add to collection");
         System.out.println( "2. List all poems in the collection");
         System.out.println( "3. Quit");
         System.out.println();
         selection = scan.nextInt();
         
         if( selection == 1 )
         {
            System.out.println( "Please enter URL of the poem:");
            String url;
            MySimpleURLReader poem;
            
            url = scan.next(); // holds url of the poem
            
            if( url.contains( ".htm") || url.contains( ".html") ) // Checks whether this url is a html page or not
            {
               poem = new HTMLFilteredReader( url);
            }
            else
            {
               poem = new MySimpleURLReader( url);
            }
            
            msuReaderList.add( poem ); // Add poem to the collection
            System.out.println( "A new poem is added to your collection");
            System.out.println();
         }
         else if( selection == 2 )
         {
            System.out.println( "Poems: ");
            
            // List poems
            int i;
            for( i = 0; i < msuReaderList.size(); i++ )
            {
               System.out.println( "index of the poem: " + i + " , name of the poem: " + msuReaderList.get( i).getName());
            }
            if( msuReaderList.size() != 0 )
            {
               boolean flag;
               flag = true;
               do
               {
                  System.out.println( "Type the poem index as you see from above to view the poem (Or type " + i + " to exit):");
                  selection = scan.nextInt();
                  
                  // Wait for user input of poem index
                  if( selection >= 0 && selection < msuReaderList.size() )
                  {
                     System.out.println();
                     System.out.println( msuReaderList.get(selection).getPageContents());
                  }
                  else if( selection == msuReaderList.size() )
                  {
                     flag = false;
                  }
                  else
                  {
                     System.out.println( "Error, enter a valid index!");
                  }
               } while( flag );
            }
            else
            {
               System.out.println( "List is empty.");
            }
         }
         // Exit from user menu
         else if( selection == 3 )
         {
            exit = false;
         }
         else
         {
            System.out.println( "Error, you must enter between 1-3");
         }
      } while( exit );
      System.out.println( "Bye..");
   }
}