package cardgame;

import java.util.ArrayList;
/**
 * Cardgame  represents simple card game
 * @author:  Burak YAŞAR
 * @version: 05.03.17
 */
public class CardGame
{
   // properties
   Cards             fullPack;
   ArrayList<Player> players;
   ScoreCard         scoreCard;
   Cards[]           cardsOnTable;
   int               roundNo;
   int               turnOfPlayer;
   
   // constructor
   /**
    * @param p1 is first player
    * @param p2 is second player
    * @param p3 is third player
    * @param p4 is fourth player
    */
   public CardGame( Player p1, Player p2, Player p3, Player p4)
   {  
      fullPack = new Cards( true );
      fullPack.shuffle();
      
      players = new ArrayList<Player>();
      players.add(p1);
      players.add(p2);
      players.add(p3);
      players.add(p4);
      
      cardsOnTable = new Cards[players.size()];
      for( int j = 0; j < players.size(); j++)
      {
         for( int i = 0; i < 13; i++ )
         {
            players.get(j).add( fullPack.getTopCard() );
         }
      }
      
      cardsOnTable[0] = p1.hand;
      cardsOnTable[1] = p2.hand;
      cardsOnTable[2] = p3.hand;
      cardsOnTable[3] = p4.hand;
      
      scoreCard = new ScoreCard( players.size() );
      
      roundNo = 0;
      turnOfPlayer = 0;
   }
   
   // methods
   
   /**
    * @param p player who will play
    * @param c card which will be played by the player
    * @return false if game is over or if not p's turn, if p's turn return true
    */
   public boolean playTurn( Player p, Card c)
   {
      int playerNo;
      int maxCard;
      
      playerNo = players.indexOf( p);
      
      if( isGameOver() )
      {
         return false;
      }
      
      else if( !isTurnOf(p) )
      {
         return false;
      }
      
      else //playTurn //******
      { 
         cardsOnTable[playerNo].addTopCard( p.playCard() );
         //cardsOnTable[playerNo].getTopCard();
         maxCard = 0;
         for (int i = 0; i < players.size(); i++)
         {
            if (cardsOnTable[i].getTopCard().getFaceValue() > maxCard)
            {
               maxCard = cardsOnTable[i].getTopCard().getFaceValue();
            }
         }
         for (int i = 0; i < players.size(); i++)
         {
            if (cardsOnTable[i].getTopCard().getFaceValue() == maxCard)
            {
               scoreCard.update(i,1);
            }
         }
         
         if(isGameOver() == false && isTurnOf( players.get(3) ) )
         {
            roundNo++; //end of the round
         }
         turnOfPlayer++; //nextPlayer
         return true;
      } 
   }
   
   /**
    * @param p player object
    * @return true if it is p's turn, false otherwise
    */
   public boolean isTurnOf( Player p)
   {
      int playerNo;
      playerNo = players.indexOf( p);
      if( playerNo == this.turnOfPlayer)
      {
         return true;
      }
      return false;
   }
   
   /**
    * @return true if the game is over otherwise false
    */
   public boolean isGameOver()
   {
      if( getRoundNo() == 13 )
      {
         return true;
      }
      return false;
   }
   
   /**
    * @param playerNumber is turn no of player
    * @return score of the player with given playerNumber if not valid return -1
    */
   public int getScore( int playerNumber)
   {
      if( playerNumber >= 1 && playerNumber < players.size() )
      {
         return scoreCard.getScore( playerNumber );
      }
      else
      {
         return -1;
      }
   }
   
   /**
    * @param playerNumber is turn no of player
    * @return name of the player
    */
   public String getName( int playerNumber)
   {
      return players.get(playerNumber).getName();
   }
   
   /**
    * @return number of played round
    */
   public int getRoundNo()
   {
      return roundNo;
   }
   
   /**
    * @return the number of player who has the turn
    */
   public int getTurnOfPlayerNo()
   {
      return turnOfPlayer % 4;
   }
   
   /**
    * @return player array, which represents winner players
    */
   public Player[] getWinners()
   {      
      //winner list
      Player[] winners;
      winners = new Player[scoreCard.getWinners().length];
      for (int i = 0; i < winners.length; i++){
         winners[i] = players.get(scoreCard.getWinners()[i]);
      }
      return winners;  
   }
   
   /**
    * @return score array(type int[]) which is scores of the players
    */
   public String showScoreCard()
   {
      return scoreCard.toString();
   }
}