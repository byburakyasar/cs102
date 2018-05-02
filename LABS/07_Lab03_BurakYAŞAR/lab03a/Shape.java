package lab03a;
/*
 * A simple abstract class Shape
 * @author Burak YASAR
 * @version 23.03.2017
 */
public abstract class Shape implements Locatable
{
   // properties
   int x;
   int y;
   private boolean isSelected;
   
   public Shape( int x, int y )
   {
      setLocation( x, y );
   }
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
   
    /* Determines whether it is selected or not
    * @return isSelected
    **/
   public boolean getSelected()
   {
      return isSelected;
   }
   
   /* Helps to set isSelected 
    * @param boolean isSelected
    **/
   public void setSelected( boolean isSelected )
   {
      this.isSelected = isSelected;
   }
}