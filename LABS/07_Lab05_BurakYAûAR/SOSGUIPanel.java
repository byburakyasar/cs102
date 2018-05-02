import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cs101.sosgame.SOS;
/*
 * This class includes an instance of the SOSCanvas class, as well as the other UI components extends JPanel
 * @author Burak YAŞAR
 * @version 06.04.2017
 */
public class SOSGUIPanel extends JPanel
{
   // CONSTANTS
   public final int SIZE_OF_PANEL = 360;
   
   // properties
   private SOS mySOS;
   private SOSCanvas myCanvas;
   private SOSMouseListener sosMouseListener;
   private SOSRadioListener sosRadioListener;
   private String firstPlayer;
   private String secondPlayer;
   private int turn;
   private JLabel firstLabel;
   private JLabel secondLabel;
   private JRadioButton sButton;
   private JRadioButton oButton;
   private char selection = 's';
   private ButtonGroup myButtonGroup;
   
   // constructor
   public SOSGUIPanel( SOS mySOS, String firstPlayer, String secondPlayer )
   {
      this.mySOS = mySOS;
      this.firstPlayer = firstPlayer;
      this.secondPlayer = secondPlayer;
      
      // initializes properties
      myCanvas = new SOSCanvas( mySOS );
      firstLabel = new JLabel( firstPlayer + ": 0");
      secondLabel = new JLabel( secondPlayer + ": 0");
      sButton = new JRadioButton( "S" );
      oButton = new JRadioButton( "O" );
      myButtonGroup = new ButtonGroup();
      
      
      // sets the elements
      myButtonGroup.add( sButton );
      myButtonGroup.add( oButton );
      sosRadioListener = new SOSRadioListener();
      sButton.addActionListener( sosRadioListener );
      sButton.setActionCommand( "s" );
      oButton.setSelected( true );
      oButton.addActionListener( sosRadioListener );
      oButton.setActionCommand( "o" );
      
      firstLabel.setBackground( Color.GREEN );
      firstLabel.setOpaque( true );
      secondLabel.setBackground( Color.WHITE );
      secondLabel.setOpaque( true );
      
      sosMouseListener = new SOSMouseListener();
      myCanvas.addMouseListener( sosMouseListener );
      
      //sets panel properties
      setPreferredSize( new Dimension( SIZE_OF_PANEL, SIZE_OF_PANEL) );
      add( myCanvas );
      add( firstLabel );
      add( sButton );
      add( oButton );
      add( secondLabel );
   }
   
   /**
    * SOSRadioListener is an inner class which implements ActionListener
    */
   private class SOSRadioListener implements ActionListener
   {
      public void actionPerformed( ActionEvent event )
      {
         Object source = event.getSource();
         
         if( source == sButton )
         {
            selection = 's';
         }
         else
         {
            selection = 'o';
         }       
      }
   } 
   
   /**
    * SOSMouseListener is an inner class which extends MouseAdapter
    */
   private class SOSMouseListener extends MouseAdapter
   {
      public void mouseClicked( MouseEvent event )
      {
         // local variables
         Point point = event.getPoint();
         int size = mySOS.getDimension();
         //int box = (myCanvas.SIZE_OF_CANVAS - 10) / size;
         int box = (myCanvas.SIZE_OF_CANVAS - 10) / size;
         int output = -4;
         
         for( int i = 0; i < size; i++ )
         {
            for( int j = 0; j < size; j++ )
            { 
               if( Math.abs( point.getX() - ( box / 2 + i * box)) < box / 2 && Math.abs( point.getY() - ( box / 2 + j * box)) < box / 2 )
               {
                  int row = i + 1;
                  int column = j + 1;
                  
                  if( mySOS.getCellContents( row - 1, column - 1) == '.' )
                  {
                     output = mySOS.play( myButtonGroup.getSelection().getActionCommand().charAt( 0 ), row, column );
                  }
               }
            }
         }
         
         // repaints frame elements
         repaint();
         
         // score updating in the labels
         firstLabel.setText( firstPlayer + ": " + mySOS.getPlayerScore1());
         secondLabel.setText( secondPlayer + ": " + mySOS.getPlayerScore2());
         
         // gets who is playing
         turn = mySOS.getTurn();
         
         // checks whose turn is this and sets background colors of players
         if( turn == 1 ) 
         {
            firstLabel.setBackground( Color.GREEN );
            secondLabel.setBackground( Color.WHITE );
         }
         else 
         {
            firstLabel.setBackground( Color.WHITE );
            secondLabel.setBackground( Color.GREEN );
         }
         
         // checks whether the game is over
         if( mySOS.isGameOver() )
         {
            String result = "";
            
            // checks whose score is bigger
            if( mySOS.getPlayerScore1() > mySOS.getPlayerScore2() )
            {
               result = firstPlayer + " is the winner!";
            }
            else if( mySOS.getPlayerScore1() == mySOS.getPlayerScore2() )
            {
               result = "It's a draw!";
            }
            else
            {
               result = secondPlayer + " is the winner!";
            }
            
            JOptionPane.showMessageDialog( null, result, "Game Over", JOptionPane.INFORMATION_MESSAGE );
            System.exit( 0 );
         }
      }
   }
}