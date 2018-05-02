/*
 * This class tests SimpleLinkedList class.
 * @author Burak YAŞAR
 * @version 04.05.2017
 */
public class SimpleLinkedListTest
{
    public static void main( String[] args)
    {
        // creates new SimpleLinkedList object
        SimpleLinkedList linkedList = new SimpleLinkedList();
        
        // Add a number of strings to it
        linkedList.addToHead( "Berat" );
        linkedList.addToHead( "Burak" );
        linkedList.addToHead( "Safa" );
        linkedList.addToHead( "Vedat" );
        linkedList.addToHead( "Yağız" );
        
        // prints all items in the list
        System.out.println( linkedList.toString() );
        
        // gets items within the list according to index location that they have
        System.out.println( "3. Item: " + linkedList.get( 2 ));
        System.out.println( "33. Item: " + linkedList.get( 32 ));
        
        // removes items from the head and prints the remaining list
        System.out.println( linkedList.removeFromHead() + " removed" );
        System.out.println( "Current list:\n" + linkedList.toString() );
        System.out.println( linkedList.removeFromHead() + " removed" );
        System.out.println( "Current list:\n" + linkedList.toString() );
        System.out.println( linkedList.removeFromHead() + " removed" );
        System.out.println( "Current list:\n" + linkedList.toString() );
        System.out.println( linkedList.removeFromHead() + " removed" );
        System.out.println( "Current list:\n" + linkedList.toString() );
        System.out.println( linkedList.removeFromHead() + " removed" );
        System.out.println( "Current list:\n" + linkedList.toString() );
    }
}