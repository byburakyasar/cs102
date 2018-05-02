/**
 * Faruk ÞÝMÞEKLÝ
 * Hatim ZAHÝD
 * Khotai ALÝYEV
 */
public Hangman(){
   allLetters = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
   maxAllowedIncorrectTries = 6;
   numberOfIncorrectTries = 0;
   usedLetters = new StringBuffer("");
   secretWord = new StringBuffer( chooseSecretWord() );
   knownSoFar = new StringBuffer("");
   for(int i = 0; i < secretWord.length(); i++){
      knownSoFar.append("*");
   }
}
