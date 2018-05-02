/**
 * This program simulates a very basic instance of Hangman game.
 * @author Ali Kemal Özkan
 * @author Cansu Canan Ceyhan
 * @author Mustafa Bay
 * @author Süleyman Taylan Topaloðlu
 * @author Sadýk Yaðýz Yetim
 * @author Ali Cenk Turpculu
 * @version 12.02.2017
 */ 

public class Hangman
   
{
   
   //properties
   
   private StringBuffer secretWord = new StringBuffer();
   private StringBuffer allLetters = new StringBuffer();
   private StringBuffer usedLetters = new StringBuffer(6);
   private StringBuffer knownSoFar = new StringBuffer();
   private int numberOfIncorrectTries; 
   private int maxAllowedIncorrectTries;
   
   //constructor
   
   public Hangman()
   {
      //body
   }
   
   //methods
   
   /**
    * Gets all the letters in the English alphabet.
    * @return all letters in alphabet.
    */ 
   
   public String getAllLetters()
   {
      return allLetters.toString();
   }
   
   /**
    * Gets the letters used for finding the secret word.
    * @return used letters.
    */ 
   
   public String getUsedLetters()
   {
      return usedLetters.toString();
   }
   
   /**
    * Gets the number of incorrect tries.
    * @return the number of incorrect tries.
    */
   
   public int getNumOfIncorrectTries()
   {
      return numberOfIncorrectTries;
   }
   
   /**
    * Gets the maximum incorrect try count.
    * @return the maximum incorrect try count.
    */ 
   
   public int getMaxAllowedIncorrectTries()
   {
      return maxAllowedIncorrectTries;
   }
   
   /**
    * Gets the known letters of the secret word.
    * @return the known letters of the secret word.
    */
   
   public String getKnownSoFar()
   {
      return knownSoFar.toString();
   }
   
   /**
    * Gets whether or not the game is over.
    * @return whether or not the game is over.
    */ 
   
   public boolean isGameOver()
   {
      if(getNumOfIncorrectTries() == maxAllowedIncorrectTries)
      {
         return true;
      }  
      
      else
      {
         return false;
      }
   }
   
   /**
    * Gets if the player has lost.
    * @return true if the player has lost, false otherwise.
    */ 
   
   public boolean hasLost()
   {
      if(isGameOver()) 
      {
         return true;
      }
      
      else
      {  
         return false;
      }
   }
   
   public int tryThis()
   {
      //body
   } 
   
   public void chooseSecretWord()
   {
      //body
   }
   
}