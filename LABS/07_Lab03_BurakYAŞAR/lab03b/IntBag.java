package lab03b;

import java.util.Iterator;
import java.util.Arrays;
import java.util.ArrayList;
/*
 * IntBag class to store a reserved size of int's inside a collection
 * @author Burak YAÞAR
 * @version 23.03.2017
 */
public class IntBag
{  
   // variable
   private int[] bag;
   private int valid;
   
   
   /**
    * Default constructor:
    * Constructs IntBag object with empty collection bag
    */
   public IntBag()
   {
      bag = new int[100]; // creates an empty collection (with room for up to 100 elements)
      valid = 0;
   }
   
   /** 
    * Constructor
    * @param desiredNumber is desired maximum number of elements
    */
   public IntBag( int desiredNumber )
   {
      bag = new int[desiredNumber];
      valid = 0;
   }
   
   public int[] getBag()
   {
      return bag;
   }
   
   /**
    * Returns a textual representation of collection bag
    * @return the string representation of collection bag
    **/
   public String toString()
   {
      String result;
      result = "";
      for( int j = 0; j < size(); j++ )
      {
         result = result + bag[j] + " ";
      }
      return result;
      //return Arrays.toString( bag );
   }
   
   /**
    * Tests whether the collection contains a given value or not.
    * @param given is the number which is looked for
    * @return true if the this int is in the collection bag, false otherwise
    **/
   public boolean contains( int given )
   {
      for( int j = 0; j < bag.length; j++ )
      {
         if( bag[j] == given )
         {
            return true;
         }
      }
      return false;
   }
   
   /**
    * Adds a value to the end of the collection
    * @param value is an integer which will be added to the collection 'bag'
    **/
   public void add( int value)
   {
      int i; // for index value
      boolean added; // to control the while loop
      i = 0;
      added = false;
      while( !added ) // when the value is added terminates the loop
      { 
         if( bag[i] == 0 )
         {
            bag[i] = value;
            added = true;
            valid++;
         }
         else
         {
            i++;
         }
      }
   }
   
   /**
    * Adds a value to the i th index of the collection
    * @param value is an integer which will be added to the collection 'bag'
    * @param i is index value and defines where the value will be added
    **/
   public void add( int value, int i )
   {
      for( int j = bag.length - 2; j >= i; j-- )
      {
         bag[j+1] = bag[j];
      }
      bag[i] = value;
      valid++;
   }
   
   /**
    * Removes a value from the i th index of the collection
    * @param value is an integer which will be removed to the collection 'bag'
    * @param i is index value and defines where the value will be removed
    **/
   public void remove( int i )
   {
      for( int j = i; j < bag.length; j++ )
      {
         if( j != bag.length - 1)
         {
            bag[j] = bag[j+1];
         }
      }
      bag[bag.length-1] = 0;
      valid--;
   }
   
   /**
    * Returns the number of values currently in the collection
    * @return how many values were added to the collection
    **/
   public int size()
   {
      return valid;
   }
   
   /**
    * Gets i th element from collection bag
    * @param i is an integer which is index number of collection bag
    * @return i th integer from the collection bag
    **/
   public int get( int i )
   {
      if( i >= 0 && i < size() )
      {
         return bag[i];
      }
      System.out.println( "Invalid index.");
      return -1;
   }
   
   /**
    * Finds indexes of all instances of a given value in the collection
    * @param wantedValue is given value
    * @return the String representation of locations (indexes) of all instances of a given value in the collection
    **/
   public String findAll( int wantedValue )
   {
      IntBag indexes = new IntBag( size() );
      String result;
      
      // collect all indexes within an IntBag object
      indexes = new IntBag();
      for( int j = 0; j < bag.length; j++ )
      {
         if( wantedValue == bag[j] )
         {
            indexes.add(j);
         }
      }
      
      // to represent in String type
      result = "";
      for( int j = 0; j < indexes.size() - 1; j++ )
      {
         result = result + indexes.get(j) + " ";
      }
      
      result = result + indexes.get( indexes.size() - 1 );
      
      return result;
   }
   
   //create an instance of IntBagIterator
   /**
    * Creates an instance of IntBagIterator
    * @return interface IntIterator which extends from Iterator
    **/
   public Iterator iterator()
   {
      return new IntBagIterator( this );
   }
}