
import java.util.Scanner ;
import java.io.* ;
public class Hangman
{
   private StringBuffer secretWord ;  
   private StringBuffer allLetters = new StringBuffer("abcdefghijklmnopqrstuvwxyz"); 
   private StringBuffer usedLetters = new StringBuffer();
   private int numberOfIncorrectTries = 0 ;
   private int maxAllowedIncorrectTries = 6 ;
   private StringBuffer knownSoFar = new StringBuffer();
   private String[] fixedArrayOfWords = new String[15] = {"one" ,"night", "dream", "pact" ,"with", "devil" ,"soul", "everything" , "desire", "servant" ,"anticipate","wish" ,"idea", "violin", "pretty" }
   public Hangman()
   {
   }
   public String chooseSecretWord()
   {
      return fixedArrayOfWords[(int) ( (Math.random() * fixedArrayOfWords.length) ) ] ;
   }  
   public void tryThis()
   {
   }
   public String getAllLetters()
   {
      return allLetters.toString() ;
   }
   public String getUsedLetters()
   {
      return usedLetters.toString() ;
   }
   public int getNumOfIncorrectTries()
   {
      return numberOfIncorrectTries ;
   }
   public int getMaxAllowedIncorrectTries()
   {
      return maxAllowedIncorrectTries ;
   }
   public String getKnownSoFar()
   {
      return knownSoFar.toString() ;
   }
   public boolean isGameOver()
   {
      return (numberOfIncorrectTries >=  maxAllowedIncorrectTries) ;
   }
   public boolean hasLost()
   {
      return ( this.isGameOver() && !(secretWord.equals(knownSoFar)));
   }
}