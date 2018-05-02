package lab03a;
/*
 * Selectable Interface
 * @author Burak YASAR
 * @version 23.03.2017
 */
public interface Selectable
{
   // declaration of the interface
   boolean getSelected();
   void setSelected( boolean isSelected );
   Shape contains( int x, int y );
}