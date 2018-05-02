package lab03b;
/*
 * IntBagIterator class that iterates through IntBag objects
 * @author Burak YA�AR
 * @version 23.03.2017
 */
public class IntBagIterator extends IntBag implements IntIterator
{
   // properties
   private IntBag aBag;
   private int index;
   
   // constructor
   public IntBagIterator( IntBag aBag )
   {
      this.aBag = aBag;
      index = 0;
   }
   
   /* Helps us to get Integer object
    * @return Integer intObj inherited from Object class( cosmic super class )
    **/
   public Object next()
   {
      Integer intObj;
      intObj = new Integer( aBag.get( index ) );
      index++;
      
      return intObj;
   }
   
   /* Helps us to get int
    * @return int integer
    **/
   public int nextInt()
   {
      int integer;
      integer = aBag.get( index );
      index++;
      
      return integer;
   }
   
   /* Helps us to determine whether index is in size of aBag
    * @return boolean
    **/
   public boolean hasNext()
   {
      return index < aBag.size();
   }
}