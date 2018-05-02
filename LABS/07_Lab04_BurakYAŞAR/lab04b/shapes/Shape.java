package shapes;
/*
 * A simple abstract class Shape
 * @author Burak YAŞAR
 * @version 23.03.2017
 */
public abstract class Shape implements Locatable
{
   // properties
   int x;
   int y;
   
   // abstract method to calculate area
   public abstract double getArea();
   
   /* it helps to get X coordinate
    * @return int x
    **/
   public int getX()
   {
      return x;
   }
   
   /* it helps to get Y coordinate
    * @return int y
    **/
   public int getY()
   {
      return y;
   }
   
   /* it helps to set x and y coordinates
    * @param int int
    **/
   public void setLocation( int x, int y )
   {
      this.x = x;
      this.y = y;
   }
}