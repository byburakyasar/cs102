import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/*
 * A basic number guessing game PlotLuck
 * @author Burak YAÞAR
 * @version 30.03.17
 */
public class PotLuck
{
   // CONSTANTS
   private final static int BUTTON_X = 5;
   private final static int BUTTON_Y = 5;
   
   // properties
   private static Button[] buttons;
   private static Frame f;
   private static Label guessesLabel;
   private static Label luckyNumberLabel;
   private static int noOfGuesses;
   private static int luckyNumber;
   
   // Main method
   public static void main( String[] args)
   {
      initializeFrame();
   }
   
   // Frame initialisation method
   private static void initializeFrame()
   {
      // Initialise variables
      noOfGuesses = 0;
      luckyNumber = (int)(1 + Math.random() * (BUTTON_X * BUTTON_Y));
      System.out.println( luckyNumber);
      guessesLabel = new Label( "Number of guesses: 0");
      luckyNumberLabel = new Label( "Please press a button to give a shot"); 
      f = new Frame();
      
      // Add and set frame elements
      f.setLayout( new FlowLayout());
      f.setTitle( "Pot Luck");
      f.setSize( 49 * (BUTTON_X + 1), 49 * (BUTTON_Y + 2));
      f.setResizable( false);
      f.add( new Label( "Welcome to PotLuck!"));
      //f.add( guessesLabel);
      f.add( luckyNumberLabel);
      // Add windows close event
      f.addWindowListener(new WindowAdapter()
                             {
         public void windowClosing(WindowEvent we)
         {
            f.dispose();
            System.exit( 0);
         }
      });
      
      // Initialise buttons
      initializeButtons();
   }
   
   // Buttons initialisation method
   private static void initializeButtons()
   {
      // Initialise variables
      Panel p = new Panel();
      p.setLayout( new FlowLayout());
      p.setPreferredSize( new Dimension( 49 * BUTTON_X, 49 * (BUTTON_Y + 1)));
      
      buttons = new Button[(BUTTON_X * BUTTON_Y)];
      
      for ( int i = 1; i <= (BUTTON_X * BUTTON_Y); i++ )
         buttons[i - 1] = new Button( i + "");
      
      // Pass for all buttons
      for ( Button b : buttons )
      {
         b.setPreferredSize( new Dimension( 40, 40));
         // Add button click event
         b.addActionListener( new ActionListener() 
                                {
            public void actionPerformed(ActionEvent e)
            {
               buttonClicked( Integer.parseInt( b.getLabel()), b);
            }
         });
         
         p.add( b);
      }
      // Add panel to the frame
      p.add( guessesLabel);
      f.add( p);
      f.setVisible( true);
   }
   
   // Buton clicked method
   private static void buttonClicked( int buttonNumber, Button button)
   {
      noOfGuesses++;
      
      // Check if game is over and luck number found
      if (buttonNumber == luckyNumber)
      {
         for ( Button b : buttons )
            b.setEnabled( false);
         
         guessesLabel.setText( "You got it in " + noOfGuesses + " attempts");
         luckyNumberLabel.setText( "Your lucky number is " + luckyNumber);
         
//            luckyNumberLabel.addMouseListener(new MouseAdapter()
//            {
//                public void mouseClicked(MouseEvent e)
//                {
//                    f.dispose();
//                    initializeFrame();
//                }
//            });
         
         // Open options frame
         int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
         
         if (response == JOptionPane.NO_OPTION) 
         {
            f.dispose();
            System.exit( 0);
         } 
         else if (response == JOptionPane.YES_OPTION) 
         {
            f.dispose();
            initializeFrame();
         } 
         else if (response == JOptionPane.CLOSED_OPTION) 
         {
            f.dispose();
            System.exit( 0);
         }
      }
      
      // Disable button and continue
      else
      {
         button.setEnabled( false);
         guessesLabel.setText( "Number of guesses: " + noOfGuesses);
      }
   }
}