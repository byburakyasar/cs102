package lab03a;
/*
 * Square shape class
 * @author Burak YASAR
 * @version 23.03.2017
 */
public class Square extends Rectangle
{
   // constructor
   public Square( int side, int x, int y )
   {
      super( side, side, x, y );
   }
   
   /* Returns string representation of Square
    * @return text
    **/
   public String toString()
   {
      String text;
      text = "Square" + super.toString().substring( 9 );
      return text;
   }
}