import java.util.*;
/**
 * This program simulates a Hangman game by creating an instance of Hangman Class 
 * @authors Ceyhun Emre Öztürk, Utku Türkbey, Artun Saday, Burak Can Biner, Kaan Akar, Osman Guluzade
 * @version 11/02/2017
 */
public class PlayHangMan
{
   public static void main(String[] args)
   {
      Scanner scan = new Scanner( System.in);  
      // Variables 
      Hangman cs102;
      int tryThisOutput;
      
      cs102 = new Hangman();
      
      // program code
      do
      {
         System.out.println( cs102.getKnownSoFar() );
         System.out.println();
         System.out.println( "Available Letters: " );
         System.out.println( cs102.getAllLetters() );
         System.out.println();
         System.out.println( "Used Letters " );
         System.out.println( cs102.getUsedLetters() );
         System.out.println();
         System.out.println( "Number of incorrect tries: " + cs102.getNumOfIncorrectTries() );
         System.out.println();
         do
         {
            System.out.print( "Enter an available letter from list above: ");
            tryThisOutput = cs102.tryThis( scan.next().charAt( 0 ) );
            System.out.println();
         } while( tryThisOutput == -1 || tryThisOutput ==  -2 );
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println();
      } while ( !cs102.isGameOver() );
      
      if ( cs102.hasLost())
      {
         System.out.println( "You suck!");
      }
      else
      {
         System.out.println( "You don't suck!"); 
      }
      System.out.println( "SECRET WORD: " + cs102.getKnownSoFar() );
   }
}



