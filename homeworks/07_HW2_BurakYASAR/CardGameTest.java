import java.util.Scanner;
import cardgame.*;

/**
 * CardGameTest
 * @author       Burak YAŞAR
 * @version      05.03.17
 */
public class CardGameTest
{
   // main method
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of CardGameTest\n");
        
        // CONSTANTS
        
        // VARIABLES
        Card       c;
        Cards      cards;
        ScoreCard  scores;
        Player     p;
        Player     p1, p2, p3, p4;
        CardGame   game;
        
        // PROGRAM CODE
        
        // test Card class
        c = new Card( 1);
        System.out.println( c);
        System.out.println();
        
        // test Cards class
        cards = new Cards( true);
        cards.addTopCard( c);
        cards.shuffle();
    
        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update( 3, 1);
        scores.update( 1, 2);
        System.out.println( "\n" + scores );
        
        // test Player class
        p1 = new Player( "Aynur");
        p1.add( c);
        System.out.println( p1.getName() );
        p2 = new Player( "Leonard");
        p3 = new Player( "Aytek");
        p4 = new Player( "David");
        
        // test CardGame class too?
        game = new CardGame( p1, p2, p3, p4);
        System.out.println( game.getRoundNo() );
        System.out.println( game.getTurnOfPlayerNo() );
        System.out.println( game.showScoreCard() );
        System.out.println( game.getName(1) + " win, others lose." );
        
        System.out.println( "\nEnd of CardGameTest\n" );
    }
    
} // end of class CardGameTest
