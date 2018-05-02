import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Random;
import shapes.Drawable;
import shapes.ShapeContainer;
/*
 * BalloonsGamePanel class, extends JPanel class including listeners, inner classes and playing of the game
 * @author Burak YAŞAR
 * @version 30.03.17
 */
public class BalloonsGamePanel extends JPanel
{
    // CONSTANTS
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;
    private static final int NUMBER_OF_BALLOONS = 25;
    private static final int MIN_NUMBER_OF_BALLOONS = 15;
    private static final int GAME_TIME = 250; // In seconds
    
    // properties
    private ShapeContainer balloons;
    private JLabel scoreLabel;
    private Timer myTimer;
    private MouseListener mouseListener;
    private int elapsedTime;
    private int points;
    
    // constructor
    public BalloonsGamePanel()
    {
        // panel properties
        scoreLabel = new JLabel();
        mouseListener = new BalloonGameMouseListener();
        myTimer = new Timer( 100, new BalloonGameListener() );
        
        // sets panel components
        setBackground( Color.YELLOW );
        setPreferredSize( new Dimension( WIDTH, HEIGHT) );
        add( scoreLabel );
        initializeGame();
    }
    
    // Method to start a new game
    private void initializeGame()
    {
        // sets panel variables
        elapsedTime = 0;
        points = 0;
        balloons = new ShapeContainer();
        
        // sets panel components
        paintBalloons( NUMBER_OF_BALLOONS, WIDTH, HEIGHT );
        scoreLabel.setText( "Points: 0" );
        addMouseListener( mouseListener );
        myTimer.start();
    }
    
    // paints the balloons arbitrarily
    private void paintBalloons( int number, int width, int height )
    {
        for( int i = 0; i < number; i++ )
        {
            balloons.add( new Balloon( (int)(Math.random() * width), (int)(Math.random() * height)) );
        }
    }
    
    // paints panel components
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );
        
        Iterator iterator = balloons.iterator();
        
        while( iterator.hasNext() )
        {
            ( (Drawable)iterator.next() ).draw( g );
        }
    }
    
    // BalloonGameMouseListener is an inner class which extends MouseAdapter
    private class BalloonGameMouseListener extends MouseAdapter
    {
        public void mousePressed( MouseEvent e )
        {
            int popBalloon = balloons.selectAllAt( e.getX(), e.getY() );
            
            if( popBalloon >= 2 )
            {
                points = points + popBalloon;
                
                scoreLabel.setText( "Points: " + points );
            }
        }
        
//        public void helper( MouseEvent e )
//        {
//           balloons.contains( e.getX(), e.getY() );
//        }
    }
    
    // BalloonGameListener is an inner class which implements ActionListener interface
    private class BalloonGameListener implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            Iterator it = balloons.iterator();
            
            while( it.hasNext() )
            { 
                ( (Balloon)it.next() ).grow();
            }
            
            // pops the balloons
            balloons.removeSelectedShapes();
            
            // in case there isn't enough balloons, creates new ones
            if( balloons.size() < MIN_NUMBER_OF_BALLOONS )
            {
                paintBalloons( 1, getWidth(), getHeight() );
            }
            
            if( elapsedTime % 10 == 0 )
            {
                Random random = new Random();
                float red = random.nextFloat();
                float green = random.nextFloat();
                float blue = random.nextFloat();
                Color color = new Color( red, green, blue );
            }
            
            repaint();
            elapsedTime++;
            
            // checks the game is over
            if( elapsedTime > GAME_TIME )
            {
                myTimer.stop();
                removeMouseListener( mouseListener );
                
                // asks user whether he wants to play again
                int answer = JOptionPane.showConfirmDialog( null, "Play again?", "Game over", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE );
                            
                if( answer == JOptionPane.YES_OPTION )
                {
                    initializeGame();
                }
                else
                {
                    System.exit( 0 );
                }
            }
        }
    }
}