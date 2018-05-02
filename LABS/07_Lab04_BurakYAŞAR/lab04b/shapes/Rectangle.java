package shapes;
/*
 * Rectangle shape class
 * @author Burak YAŞAR
 * @version 23.03.2017
 */
public class Rectangle extends Shape
{
   // properties
   private int width;
   private int height;
   private boolean isSelected;
   
   // constructor
   public Rectangle( int width, int height, int x, int y )
   {
      this.width = width;
      this.height = height;
      this.isSelected = false;
   }
   
   /* Calculates the area of Rectangle
    * @return area
    **/
   public double getArea()
   {
      double area;
      area = width * height;
      
      return area;
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
   
   /* Helps to return Shape if rectangle contains given coodinates
    * @param int int
    * @return Shape
    **/
   public Shape contains( int x, int y )
   {
      Shape shape = null;
      
      if( Math.abs( ( x - getX() ) ) <= ( width / 2 ) && Math.abs( ( y - getY() ) ) <= ( height / 2 ) )
      {
         shape = this;
      }
      
      return shape;
   }
   
   /* Returns string representation of Rectangle
    * @return text
    **/
   public String toString()
   {
      String text;
      text = "Rectangle - " + "Width = " + this.width + " Height = " + this.height;
      text = text + " Area = " + getArea() + " x = " + this.x + " y = " + this.y + "\nisSelected: " + isSelected;
      
      return text;
      
      
   }
}