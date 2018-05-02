import java.util.Arrays;
import java.util.Scanner;
/**
 * This class tests IntBag class.
 * @author Burak YASAR
 * @version 23/02/2017
 */ 
public class IntBagTest
{
   private static final int MAX = 100;
   private static int testValue;
   private static IntBag myBag;
   
   public static void main( String[] args )
   {
      Scanner scan = new Scanner( System.in);
      
      int option;
      
      do
      {
         System.out.println( "Welcome to menu\n");
         System.out.println( "1. Create a new empty collection with a specified maximum capacity (any previous values are lost!");
         System.out.println( "2. Read a set of positive values into the collection (use a negative value to indicate all the values have been entered.");
         System.out.println( "3. Print the collection of values.");
         System.out.println( "4. Add a value to the collection of values at a specified location.");
         System.out.println( "5. Remove the value at a specified location from the collection of values.");
         System.out.println( "6. Read a single test value.");
         System.out.println( "7. Compute the set of locations of the test value within the collection");
         System.out.println( "8. Print the set of locations.");
         System.out.println( "9. Quit the program.\n");
         
         System.out.println( "Please select an operation with typing 1-9");
         option = scan.nextInt();
         
         if( option == 1 )
         {
            myBag = new IntBag( MAX );
         }
         
         else if( option == 2 )
         {
            int values;
            int number;
            
            //myBag = new IntBag();
            
            System.out.println( "Enter values and enter negative value to stop." );
            values = scan.nextInt();
            
            while( values > 0 )
            {
               myBag.add( values ); 
               values = scan.nextInt();       
            }
            
//            myBag = new IntBag( myBag.size() );
//            
//            for( int j = 0; j < myBag.size(); j++ )
//            {
//               myBag[j]
//            }
         }
         
         else if( option == 3 )
         {
            System.out.println( myBag.toString() );
         }
         
         else if( option == 4 )
         {
            int valueToAdd;
            int i;
            
            System.out.println( "Enter a value will be added.");
            valueToAdd = scan.nextInt();
            
            System.out.println( "Enter an index of a value will be added."); 
            i = scan.nextInt();
            myBag.add( valueToAdd, i );
         }
         
         else if( option == 5 )
         {
            int i;
            
            System.out.println( "Enter an index of a value will be removed."); 
            i = scan.nextInt();
            myBag.remove( i );
         }
         
         else if( option == 6 )
         {
            
            System.out.println( "Enter a test value.");
            testValue = scan.nextInt();
         }
         
         else if( option == 7 )
         {
            myBag.findAll( testValue );
         }
         
         else if( option == 8 )
         {
            System.out.println( "Indexes of this instance are: \n" + myBag.findAll( testValue ) );
         }
      } while ( option != 9 );
      System.out.println( "Thank you for using. Bye.." );
   }
}
