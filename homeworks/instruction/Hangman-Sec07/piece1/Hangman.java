/**
 * A non-functional Hangman class to fool the compiler.
 * CS102 - Hangman - Sec07 - piece1
 */
public class Hangman
{
	// properties
	
	// constructors
	public Hangman()
	{
		//
	}
	
	// methods
	public String getAllLetters()
	{
		return "abc";
	}
	
	public String getUsedLetters()
	{
		return "xyz";
	}
	
	public int getNumOfIncorrectTries()
	{
		return 0;
	}
	
	public int getMaxAllowedIncorrectTries()
	{
		return 6;
	}
	
	public String getKnownSoFar()
	{
		return "**A**A**";
	}
	
	public int tryThis( char letter)
	{
		return 0;
	}
	
	public boolean isGameOver()
	{
		if ( Math.random() < 0.3 )
		{
			return true;
		}
		
		return false;
	}
	
	public boolean hasLost()
	{
		if ( Math.random() < 0.5 )
		{
			return true;
		}
		
		return false;
	}
}
