package shapes;
/*
 * ShapeContainer class that can contain any type of Shape object
 * @author Burak YAŞAR
 * @version 23.03.2017
 */
import java.util.ArrayList;
import java.util.Iterator;

public class ShapeContainer implements Iterable
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
      shapeList.add( s );
      
   }
   
   /* it helps to get Total area
    * @return double totalArea
    * */
   public double getArea()
   {
      double totalArea = 0;
      
      for( int i = 0; i < shapeList.size(); i++ )
      {
         totalArea = totalArea + shapeList.get(i).getArea();
      }
      return totalArea;
   }
   
   /* it helps to find the shape with given coordinates
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
         if( !shapeList.get(i).getSelected() )
         {
            shapeListAfterRemoved.add( shapeList.get(i) );
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
   
   /* Helps using iterator interface
    * @return Iterator interface
    **/
   public Iterator<Shape> iterator()
   {
      return shapeList.iterator();
   }
   
   /* Returns size of thw collection shapeList
    * @return size whose type is int
    **/
   public int size()
   {
      return shapeList.size();
   }
   
   /* Selects all the shapes which contains the given point (x,y) 
    * and if the shape is circle, other circles which intersects with the clicked one are also selected 
    * @return count, count of selected shapes
    **/
   public int selectAllAt( int x, int y )
   {
      int count = 0;
      
      for( int i = 0; i < shapeList.size(); i++ )
      {
         double distance = Math.pow( x - shapeList.get(i).getX(), 2 ) + Math.pow( y - shapeList.get(i).getY(), 2 );
         
         if( shapeList.get(i).contains( x, y ) != null || distance <= Math.pow( ( (Circle)shapeList.get(i) ).getDiameter(), 2 ) )
         {
            shapeList.get(i).setSelected( true );
            count++;
         }
      }
      
      return count;
      
//      for( int i = 0; i < shapeList.size(); i++ )
//      {
//         if( shapeList.get(i).contains( x, y ) != null )
//         {
//            shapeList.get(i).setSelected( true );
//            count++;
//         }
//      }
   }
}