import java.util.Scanner;

/**
 * This is the main method for the hangman game. 
 * CS102 - Hangman - Sec07 - piece1
 * 
 * @author Semih Erdogan, Omer Musa Battal, Enes Emre Erdem, 
 * Ahmet Emin Sahingoz, Sara Sina, Almir Leka
 * @version 12.02.2017
 */
public class HangmanMain
{
	public static void main( String[] args)
	{
		// constants
		final String SEPARATOR = "##########";
		
		// variables
		char input;
		char decision;
		int errorValue;
		String display;
		Hangman newGame;
		
		// program code
		Scanner scan = new Scanner( System.in);
		// start a new game until user wants to quit
		do
		{
			newGame = new Hangman();
			
			System.out.println( "Welcome to the Hangman game.\n");
			// while the game is not over; give current status info,
			// prompt the user, get input, use the tryThis method
			do
			{
				display = SEPARATOR + "\n" + newGame.getKnownSoFar() + "\n\n" + "Number of incorrect tries: "
					+ newGame.getNumOfIncorrectTries() + "\n" + "Number of allowed incorrect tries left: "
					+ ( newGame.getMaxAllowedIncorrectTries() - newGame.getNumOfIncorrectTries() ) + "\n\n"
					+ "All letters:  " + newGame.getAllLetters() + "\n" + "Used letters: " + newGame.getUsedLetters() + "\n";
				// print useful game information
				System.out.println( display);
				// prompt the user and get input
				System.out.print( "Please guess a letter: ");
				input = scan.next().toUpperCase().charAt( 0);
				// use the input on tryThis method
				errorValue = newGame.tryThis( input);
				// indicate error situations if they occur
				if ( errorValue == -1 )
				{
					System.out.println( "The letter is not valid.");
				}
				else if ( errorValue == -2 )
				{
					System.out.println( "The letter was already used.");
				}
				else if ( errorValue == -3 )
				{
					System.out.println( "The game is over.");
				}
				
			} while ( !newGame.isGameOver() );
			
			// announce the game result
			if ( newGame.hasLost() )
			{
				System.out.println( "\nYOU LOSE!\n");
			}
			else
			{
				System.out.println( "\nYOU WIN!\n");
			}
			// prompt the user for a new game
			System.out.print( SEPARATOR + "\nDo you want to play again?(enter 'y' for yes, any other character for no): ");
			decision = scan.next().toLowerCase().charAt( 0);
		} while ( decision == 'y' );
		
		System.out.println( "\nEnd of session.");
	}
}
