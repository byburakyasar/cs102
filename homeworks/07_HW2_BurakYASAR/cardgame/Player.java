package cardgame;

/**
 * Player -  Simple card game player with name and hand of cards
 * @author:  Burak YAŞAR
 * @version: 05.03.17
 */
public class Player
{
    // properties
    String name;
    Cards hand;
    
    // constructors
    /**
     * @param name is the name of player
     */
    public Player( String name)
    {
        this.name = name;
        hand = new Cards( false );
    }
    
    // methods
    /**
     * @return the name of the player
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * @param c is the given Card that will be added
     */
    public void add( Card c)
    {
        hand.addTopCard( c );
    }
    
    /**
     * @return top card from cards object hand
     */
    public Card playCard()
    {
        return hand.getTopCard();
    }
    
} // end class Player
