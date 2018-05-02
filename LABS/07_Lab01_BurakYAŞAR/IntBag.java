import java.util.Arrays;
import java.util.ArrayList;
/**
 * This class allows a variable sized collection of integer values to be stored proving with its methods.
 * @author Burak YASAR
 * @version 23/02/2017
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
   
   /**
    * Returns a textual representation of collection bag
    * @return the string representation of collection bag
    **/
   public String toString()
   {
      return Arrays.toString( bag );
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
      for( int j = i; j < bag.length - 1; j++ )
      {
         bag[j] = bag[j+1];
         bag[bag.length-1] = 0;
      }
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
   public int getIntFromBag( int i )
   {
      return bag[i];
   }
   
   /**
    * Finds indexes of all instances of a given value in the collection
    * @wantedValue is given value
    * @return the String representation of locations (indexes) of all instances of a given value in the collection
    **/
   public String findAll( int wantedValue )
   {
      ArrayList<Integer> indexes;
      String result;
      
      // collect all indexes within an ArrayList
      indexes = new ArrayList<Integer>();
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
}