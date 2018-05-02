package cardgame;
import java.util.Arrays;
import java.util.ArrayList;

/**
 * ScoreCard - Maintains one integer score per player, for any number of players
 *             Caution: invalid playernumbers result in run-time exception!
 * @author:    Burak YAŞAR
 * @version:   05.03.17
 */
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    /**
     * @param noOfPlayers is the number of player who will play the game
     */
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods
    /**
     * @param playerNo is the turn number of player
     * @return score of the player with number playerNo
     */
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    
    /**
     * @param playerNo is the turn number of player
     * @param amount determines how much the score will be increased
     */
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    /* (non-Javadoc)
     * returns String representation of int collection scores
     */
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    
    /**
     * @return winner scores which are maximum
     */
    public int[] getWinners()
    {
       int max;
       int[] winners;
       ArrayList<Integer> winnerList;
       
       max = 0;
       for( int i = 0; i < scores.length; i++ )
       {
          if( scores[i] > max )
          {
             max = scores[i];
          }
       }
       
       winnerList = new ArrayList<Integer>();
       for( int i = 0; i < scores.length; i++ )
       {
          if( scores[i] == max )
          {
             winnerList.add(i);
          }
       }
       
       winners = new int[winnerList.size()];
       for( int i = 0; i < winnerList.size(); i++ )
       {
          winners[i] = winnerList.get(i);
       }
       
       return winners;
    }
    
} // end class ScoreCard
