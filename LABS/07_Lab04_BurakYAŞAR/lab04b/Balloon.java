import shapes.Circle;
import shapes.Drawable;
import java.awt.*;
/*
 * Drawable Balloon to create balloons and grow them at a certain rate
 * @author Burak YAŞAR
 * @version 30.03.17
 */
public class Balloon extends Circle implements Drawable
{
   // CONSTANTS
   public static final int SIZE = 25;
   public static final int MAX_SIZE = 100;
   
   // constructor
   public Balloon( int x, int y )
   {
      super( SIZE );
      setLocation( x, y );
   }
   
   /**
    * Draws a balloon
    */
   public void draw( Graphics g )
   {
      int radiusOfBalloon = getRadius();
      g.drawOval( getX() - radiusOfBalloon, getY() - radiusOfBalloon, 2 * radiusOfBalloon, 2 * radiusOfBalloon );
   }
   
   /**
    * Grows the balloon
    */
   public boolean grow()
   {
      setRadius( getRadius() + 1 );
      
      if( MAX_SIZE < getRadius() )
      {
         setRadius( 0 );
         setSelected( true );
      }
      
      return 0 != getRadius();
   }
}