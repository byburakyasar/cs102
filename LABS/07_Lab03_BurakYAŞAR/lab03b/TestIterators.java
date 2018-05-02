package lab03b;

import java.util.Iterator;
/*
 * This class tests IntBagIterator and iterates through IntBag
 * @author Burak YAÞAR
 * @version 23.03.2017
 */
public class TestIterators
{
   // main method
   public static void main( String[] args)
   {
      // creates a new IntBag
      IntBag bag;
      bag = new IntBag();
      
      bag.add( 26 );
      bag.add( 13 );
      bag.add( 99 );
      bag.add( 20 );
      bag.add( 15 );
      
      Iterator i, j;
      
      i = new IntBagIterator( bag );
      
      // Iterate through first iterator
      while( i.hasNext() ) 
      {
         System.out.println( i.next() );
         
         // j = new IntBagIterator( bag );
         j = bag.iterator();
         
         // Iterate through second iterator
         while( j.hasNext() )
         {
            System.out.println( "--" + j.next() );
         }
      }
   }
}