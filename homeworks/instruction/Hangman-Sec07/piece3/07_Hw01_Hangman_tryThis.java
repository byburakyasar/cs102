/**
 * The method tryThis in the Hangman class does the following:
 * It allows the user to try a letter in the hangman game.
 * If that letter exists in the secretWord, the method will return the number
 * of times it occurs. It also updates the usedLetters with the tried letter.
 * It updates knownSoFar by putting the letter in the appropriate positions in the
 * secretWord if there are any. If the tried letter does not exist in the secretWord
 * the number of incorrect tries will be incremented. The method will return error values
 * if the letter is not valid( -1 ), if the letter was used before( -2 ), and indicate the game is over( -3 ).
 * 
 * @authors Arda Yüksel, Melis Kabasakal, Pelin Baysal, Zelal Ýrem Aldað, Tuðçe Kavakderesi,Koçak Bozdoðan, Emre Dönmez
 * @version 11.02.2017
 */
public class Hangman
{
   /**
    * This method tries a letter.
    * @param letter is the letter to be tried.
    * @return count is the number of time the letter occurs in the secretWord.
    */
   public int tryThis( char letter )
   {
      int count; //Number of times the letter occurs in the secretWord.
      count = 0;
      //for possible errors
      if( allLetters.indexOf( letter ) == -1 )
      {
         return -1;
      }
      else if( usedLetters.indexOf( letter ) > -1 )
      {
         return -2;
      }
      else if( secretWord.equals( knownSoFar ) )
      {
         return -3;
      }
      usedLetters.append( letter );
      
      if( secretWord.indexOf( letter ) == -1 )
      {
         numberOfIncorrectTries++;
      }
      else
      {
         for( int i = 0; i < secretWord.length(); i++ )
         {
            if( secretWord.charAt(i) == letter )
            {
               count++;
               knownSoFar.insert( i, letter );
            }
         }
      }
      return count;
   }
}