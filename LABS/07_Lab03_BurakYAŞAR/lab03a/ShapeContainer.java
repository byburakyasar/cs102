package lab03a;
/*
 * ShapeContainer class that can contain any type of Shape object
 * @author Burak YASAR
 * @version 23.03.2017
 */
import java.util.ArrayList;

public class ShapeContainer
{
   // properties
   private ArrayList<Shape> shapeList;
   
   // constructor
   public ShapeContainer()
   {
      shapeList = new ArrayList<Shape>();
   }
   
   /* Helps to add shape to container
    * @param Shape
    **/
   public void add( Shape s )
   {
      if( s instanceof Selectable )
      {
         shapeList.add( s );
      }
      else
      {
         System.out.println( "Error! Object is not selectable" );
      }
   }
   
   /* it helps to get Total area
    * @return double totalArea
    * */
   public double getArea()
   {
      double totalArea = 0;
      
//      for( int i = 0; i < shapeList.size(); i++ )
//      {
//         totalArea = totalArea + shapeList.get(i).getArea();
//      }
      for( Shape shape: shapeList )
      {
         totalArea = totalArea + shape.getArea();
      }
      return totalArea;
   }
   
   /* it helps to find the shape with given coordinates
    * @return Shape
    * @param int int
    * */
   public void findTheShape( int x, int y )
   {
      for( int i = 0; i < shapeList.size(); i++ )
      {
         if( shapeList.get(i).contains( x, y ) != null )
         {
            if( shapeList.get(i).getSelected() )
            {
               shapeList.get(i).setSelected( false );
            }
            else
            {
               shapeList.get(i).setSelected( true );
            }
            System.out.println( "Shape is found: " + shapeList.get(i) );
         }
         else
         {
            System.out.println( "Shape is not found" );
         }
      }
   }
   
   /* Helps to  remove selectedshape
    * @return Shape
    * @param int int
    **/
   public void removeSelectedShapes()
   {
      ArrayList<Shape> shapeListAfterRemoved = new ArrayList<Shape>();

      for( int i = 0; i < shapeList.size(); i++ )
      {
         if (shapeList.get(i).getSelected() == false && ( (Selectable) shapeList.get(i) ).getSelected() )
         {
            shapeListAfterRemoved.add( shapeList.get(i) );
            i--;
         }
         else if( ( (Selectable) shapeList.get(i) ).getSelected() )
         {
            System.out.println( "Shape is removed: " + shapeList.get(i) );
         }
         else
         {
            System.out.println( "Shape cannot be removed" );
         }
      }
      shapeList = shapeListAfterRemoved;
   }
   
   /* Returns string representation of ShapeContainer
    * @return str
    **/
   public String toString()
   {
      String str = "";
      
      for( int i = 0; i < shapeList.size(); i++ )
      {
         str = str + shapeList.get(i) + "\n";
      }
      
      return str;
   }
}