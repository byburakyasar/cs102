/*
 * This class uses SimpleLinkedList object as a list and evaluates simple postfix expressions
 * @author Burak YAŞAR
 * @version 04.05.2017
 */
public class SimpleStack
{
    SimpleLinkedList list;
    
    // Constructor
    public SimpleStack()
    {
        list = new SimpleLinkedList();
    }
    
    // Method to push a value to the list
    public void push( String element )
    {
        list.addToHead( element );
    }
    
    // Method to get and remove the first value of the list
    public String pop()
    {
        return list.removeFromHead();
    }
    
    // Method to check if list is empty
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
}