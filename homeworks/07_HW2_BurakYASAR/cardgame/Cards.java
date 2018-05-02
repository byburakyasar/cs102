package cardgame;

/**
 * Cards - Maintains a collection of zero or more playing cards.
 *         Provides facilities to create a full pack of 52 cards
 *         and to shuffle the cards
 * @author: Burak YAŞAR
 * @version: 05.03.17
 */
public class Cards
{
    final int NOOFCARDSINFULLPACK = 52;
    
    // properties
    Card[] cards;
    int    valid;  // number of cards currently in collection
    
    // constructors
    /**
     * @param fullPack either true or false when it is true full pack of cards(size 52) will be created
     */
    public Cards( boolean fullPack)
    {
        cards = new Card[ NOOFCARDSINFULLPACK ];
        valid = 0;
        
        if ( fullPack)
            createFullPackOfCards();
    }
    
    // methods
    /**
     * @return the top card from Card collection "cards", if it is not available return null
     */
    public Card getTopCard()
    {
        Card tmp;

        if ( valid <= 0)
            return null;
        else
        {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    
    /**
     * @param c is the given Card that will be added
     * @return true if there exist available location in cards(Card array), false otherwise
     */
    public boolean addTopCard( Card c)
    {
        if ( valid < cards.length)
        {
            cards[valid] = c;   // should this be cloned? --- NO
            valid++;
            return true;
        }
        return false;
    }
    
    /**
     * Creates full pack of cards
     */
    private void createFullPackOfCards()
    {
        for( int i = 0; i < NOOFCARDSINFULLPACK; i++ )
        {
           addTopCard( new Card(i) );
        }
    }
    
    /**
     * Shuffles the card pack
     */
    public void shuffle()
    {
       int index;
       Card temp;
       temp = cards[0];
       for( int i = 0; i < cards.length; i++ )
       {  
          index = (int) ( Math.random() * NOOFCARDSINFULLPACK );
          temp = cards[index];
          cards[index] = cards[i];
          cards[i] = temp;
       }
    }
    
    
    // For testOnly... remove from production version!
    public void testOnlyPrint()
    {
        for ( int i = 0; i < valid; i++)
        {
            System.out.println( cards[i] );
        }
    }
    
} // end class Cards
