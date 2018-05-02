package cardgame;

/**
 * Card -   a single playing card
 * @author  Burak YAŞAR
 * @version 05.03.17
 */
public class Card
{
   final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
   final String[] FACES = { "A", "2", "3", "4", "5",
      "6", "7", "8", "9", "10",
      "J", "Q", "K"};
   
   final int NOOFCARDSINSUIT = 13;
   
   // properties
   int  cardNo;
   
   // constructors
   /**
    * @param faceValue is the face value of the card
    * @param suit is the suit of the card
    */
   public Card( int faceValue, int suit )
   {
      cardNo = faceValue + suit * NOOFCARDSINSUIT;
   }
   
   /**
    * @param cardNumber is the number of the card in ordered pack
    */
   public Card( int cardNumber)
   {
      cardNo = cardNumber;
   }
   
   /**
    * @return face value of the card
    */
   public int getFaceValue()
   {
      return cardNo % NOOFCARDSINSUIT;
   }
   
   /**
    * @return suit number
    */
   public int getSuit()
   {
      return cardNo / NOOFCARDSINSUIT;
   }
   
   /* (non-Javadoc)
    * @return String representation of Card object
    */
   public String toString()
   {
      return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
   }
   
   /**
    * @param c is another Card object
    * @return true if the Cards are equivalent, false otherwise
    */
   public boolean equals( Card c)
   {
      if( this.getFaceValue() == c.getFaceValue() )
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /**
    * @param c is another Card object
    * @return 1 if this card is bigger, -1 if this card is samller, 0 if they are equal
    */
   public int compareTo( Card c)
   {
      if( this.getFaceValue() > c.getFaceValue() )
      {
         return 1;
      }
      
      else if( this.getFaceValue() < c.getFaceValue() )
      {
         return -1;
      }
      return 0;
   }
}