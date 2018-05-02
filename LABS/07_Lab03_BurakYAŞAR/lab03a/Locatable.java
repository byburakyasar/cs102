package lab03a;
/*
 * Locatable Interface
 * @author Burak YASAR
 * @version 23.03.2017
 */
public interface Locatable extends Selectable
{
   // declaration of the interface
   int getX();
   int getY();
   void setLocation( int x, int y );
}