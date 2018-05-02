package lab03a;
/*
 * Circle shape class
 * @author Burak YASAR
 * @version 23.03.2017
 */
public class Circle extends Shape
{
   // properties
   private int radius;
   private boolean isSelected;
   
   // constructor
   public Circle( int radius, int x, int y )
   {
      super( x, y );
      this.radius = radius;
      this.isSelected = false;
   }
   
   /* Calculates the area of Circle
    * @return area
    **/
   public double getArea()
   {
      double area = Math.PI * Math.pow( radius, 2 );
      
      return area;
   }
   
   /* Determines whether it is selected or not
    * @return isSelected
    **/
   
//   public boolean getSelected()
//   {
//      return isSelected;
//   }
//   
//   /* Helps to set isSelected 
//    * @param boolean isSelected
//    **/
//   public void setSelected( boolean isSelected )
//   {
//      this.isSelected = isSelected;
//   }
   
   /* Helps to return Shape if circle contains given coodinates
    * @param int int
    * @return Shape
    **/
   public Shape contains( int x, int y )
   {
      double distanceSquared = ( Math.pow( getX() - x, 2 ) + Math.pow( getY() - y, 2 ) );
      
      if( Math.pow( radius, 2 ) >= distanceSquared )
      {
         return this;
      }
      
      return null;
   }
   
   /* Returns string representation of Circle
    * @return text
    **/
   public String toString()
   {
      String text;
      text = "Circle - Location of Center: (" + this.x + "," + this.y + ") Radius: " + radius;
      text = text + "\nArea: " + getArea() + "\nisSelected: " + isSelected;
      
      return text;
   }
}