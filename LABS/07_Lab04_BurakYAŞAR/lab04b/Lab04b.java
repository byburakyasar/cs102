import javax.swing.JFrame;
import java.awt.FlowLayout;
/*
 * Lab04b main JFrame class
 * @author Burak YAŞAR
 * @version 30.03.17
 */
public class Lab04b extends JFrame
{
    public Lab04b()
    {
        setTitle( "Lab04b Balloons Game");
        setLayout( new FlowLayout());
        setDefaultCloseOperation( EXIT_ON_CLOSE);
        
        BalloonsGamePanel bgp = new BalloonsGamePanel(); 
        add( bgp );
        
        pack();
        setVisible( true );
    }
    
    public static void main( String[] args)
    {
        System.out.println( "Start the game." );
        new Lab04b();
    }
}