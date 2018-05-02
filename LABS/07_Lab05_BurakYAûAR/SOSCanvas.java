import javax.swing.*;
import java.awt.*;
import cs101.sosgame.SOS;
import java.awt.geom.Rectangle2D;

/**
 * This class displays the SOS game as a grid extends JPanel
 * @author Burak YAŞAR
 * @version 06.04.2017
 */
public class SOSCanvas extends JPanel
{
   // CONSTANTS
   public final int SIZE_OF_CANVAS = 310;
   
   // properties
   private SOS mySOS;
   
   public SOSCanvas( SOS mySos )
   {
      this.mySOS = mySos;
      setPreferredSize( new Dimension( SIZE_OF_CANVAS, SIZE_OF_CANVAS ) );
   }
   
   /* @override
    * Draws the grid
    * @param grap object of Graphics class
    */
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );
      
      int size = mySOS.getDimension();
      int box = (SIZE_OF_CANVAS - 10) / size;

      
      int      x = 0;
      int      y = 0;
      char     c;
      String[] chars = new String[size * size];
      
      // sets up the grid
      for( int i = 0; i < size; i++ )
      {
         for( int j = 0; j < size; j++ )
         {
            c =  mySOS.getCellContents( i, j );
            chars[x] =  "" + c ;
            x++;
         }
      }
      
      // fills the grid
      for( int i = 5; i <= SIZE_OF_CANVAS - 10; i = i + box )
      {
         for( int j = 5; j <= SIZE_OF_CANVAS - 10; j = j + box )
         {
            g.drawRect( i, j, box, box );
            Font font = new Font( "Calibri", Font.PLAIN, 22 );
            setFont(font);
            FontMetrics fm = g.getFontMetrics( font );
            Rectangle2D bounds = fm.getStringBounds( chars[y], g );
            int Ilength = (int) bounds.getWidth();
            int Iheight = (int) bounds.getHeight();
            
            g.drawString( chars[y], i + ( box / 2), j + ( box / 2) );
            y++;
         }
      }
   }
}