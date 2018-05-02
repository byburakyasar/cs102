package shapes;
/*
 * Locatable Interface
 * @author Burak YAŞAR
 * @version 23.03.2017
 */
public interface Locatable extends Selectable
{
   // declaration of the interface
   int getX();
   int getY();
   void setLocation( int x, int y );
}