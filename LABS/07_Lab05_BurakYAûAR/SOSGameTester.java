import javax.swing.*;
import java.awt.*;
import cs101.sosgame.SOS;
/*
 * This class represents Main SOS Game frame that creates a panel of game extends JFrame
 * @author Burak YAŞAR
 * @version 06.04.2017
 */
public class SOSGameTester extends JFrame
{
   // main method
   public static void main( String[] args)
   {
      // variables
      SOS mySOS;
      SOS mySOS2;
      SOSGUIPanel sosPanel;
      SOSGUIPanel sosPanel2;
      SOSGameTester game;
      
      mySOS = new SOS( 5 );
      mySOS2 = new SOS( 3 );
      
      sosPanel = new SOSGUIPanel( mySOS, "Player 1", "Player 2" );
      sosPanel2 = new SOSGUIPanel( mySOS2, "Player 1", "Player 2" );
      
      // program code
      game = new SOSGameTester();
      game.setTitle( "Welcome to SOS Game" );
      game.setDefaultCloseOperation( EXIT_ON_CLOSE );
      
      game.setLayout( new FlowLayout() );
      game.getContentPane().add( sosPanel ); // 5 x 5 game
      game.getContentPane().add( sosPanel2 ); // 3 x 3 game
      game.pack();
      game.setVisible( true );
   }
}