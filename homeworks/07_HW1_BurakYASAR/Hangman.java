/**
 * This class represents a simple version of Hangman game.
 * @author Burak YAÞAR
 * @version 17.02.2017
 */
import java.util.Scanner ;
import java.io.* ;
public class Hangman
{
   // global variables
   private static StringBuffer secretWord;  
   private static StringBuffer allLetters; 
   private static StringBuffer usedLetters;
   private static StringBuffer knownSoFar;
   private static int numberOfIncorrectTries;
   private static int maxAllowedIncorrectTries;
   private static String[] fixedArrayOfWords = {"one" ,"night", "dream", "pact" ,"with", "devil" ,"soul", "everything" 
      , "desire", "servant" ,"anticipate","wish" ,"idea", "violin", "pretty" } ;
   
   // constructor
   public Hangman()
   {
      secretWord = new StringBuffer( chooseSecretWord() );
      allLetters = new StringBuffer( "abcdefghijklmnopqrstuvwxyz");
      usedLetters = new StringBuffer( "");
      knownSoFar = new StringBuffer( "");
      // this part prints the stars.
      for ( int i = 0 ; i < secretWord.length() ; i++ )
      {
         knownSoFar.append( "*");  
      }
      numberOfIncorrectTries = 0;
      maxAllowedIncorrectTries = 6;
   }
   
   // methods
   public static String chooseSecretWord()
   {
      return fixedArrayOfWords[(int) ( ( Math.random() * fixedArrayOfWords.length) ) ];
   }
   
   public static int tryThis( char letter)
   {
      int occurrenceNumber;
      // if the letter not in alphabet
      if( getAllLetters().indexOf( letter ) == -1 )
      {
         numberOfIncorrectTries++;
         return -1;
      }
      
      // if the letter used before
      else if( getUsedLetters().indexOf( letter ) != -1 )
      {
         numberOfIncorrectTries++;
         return -2;
      }
      else
      {
         occurrenceNumber = 0;
         
         for( int i = 0 ; i < secretWord.length() ; i++)
         {
            if( Character.toLowerCase( secretWord.charAt(i) ) == letter)
            {
               knownSoFar.setCharAt( i, secretWord.charAt(i) );
               occurrenceNumber++;
            }
         }
         
         // adds letters to usedLetters
         usedLetters.append( letter );
         
         // if the letter is not used in the secret word
         if( occurrenceNumber == 0)
         {
            numberOfIncorrectTries++;
            System.out.println( "Missed it! The letter was not in the word.");
            System.out.println();
         }
         
         // if has no more possibilities
         if( isGameOver() )
         {
            return -3;
         }
         
         return occurrenceNumber;
      }
   }
   
   /**
    * Gets all the letters in the English alphabet.
    * @return all letters in alphabet.
    */ 
   public static String getAllLetters()
   {
      return allLetters.toString();
   }
   
   /**
    * Gets the letters used for finding the secret word.
    * @return used letters.
    */ 
   public static String getUsedLetters()
   {
      return usedLetters.toString();
   }
   
   /**
    * Gets the number of incorrect tries.
    * @return the number of incorrect tries.
    */
   public static int getNumOfIncorrectTries()
   {
      return numberOfIncorrectTries;
   }
   
   /**
    * Gets the maximum incorrect try count.
    * @return the maximum incorrect try count.
    */
   public static int getMaxAllowedIncorrectTries()
   {
      return maxAllowedIncorrectTries;
   }
   
   /**
    * Gets the known letters of the secret word.
    * @return the known letters of the secret word.
    */
   public static String getKnownSoFar()
   {
      return knownSoFar.toString();
   }
   
   /**
    * Gets whether or not the game is over.
    * @return whether or not the game is over.
    */
   public static boolean isGameOver()
   {
      return ( numberOfIncorrectTries >= maxAllowedIncorrectTries || secretWord.toString().equals( knownSoFar.toString() )  );
   }
   
   /**
    * Gets if the player has lost.
    * @return true if the player has lost, false otherwise.
    */
   public static boolean hasLost()
   {
      return ( isGameOver() && !(secretWord.toString().equals( knownSoFar.toString() ) ) );
   }
   
   // main method
   public static void main( String[] args )
   {
      Scanner scan = new Scanner( System.in);  
      // variables 
      Hangman hangman;
      int tryThisOutput;
      
      hangman = new Hangman(); // creates an instance of Hangman class.
      
      // program code
      do
      {
         System.out.println( "Secret word: " + hangman.getKnownSoFar() );
         System.out.println();
         System.out.print( "Available Letters: " );
         System.out.println( hangman.getAllLetters() );
         System.out.print( "Used Letters: " );
         System.out.println( hangman.getUsedLetters() );
         System.out.println( "Number of incorrect tries: " + hangman.getNumOfIncorrectTries() );
         System.out.print( "Enter an available letter from list above: ");
         tryThisOutput = hangman.tryThis( scan.next().charAt( 0 ) );
         if( tryThisOutput == -1 )
         {
            System.out.println( "This letter is not in the alphabet!" );
            System.out.println();
         }
         if( tryThisOutput == -2 )
         {
            System.out.println( "This letter was already used!" );
            System.out.println();
         }
      } while ( !hangman.isGameOver() );
      
      if ( hangman.hasLost())
      {
         System.out.println( "You LOSE!");
      }
      else
      {
         System.out.println( "You WIN!"); 
      }
      System.out.println( "Secret word was: " + secretWord );
   }
}