/*
 * This class create a list, add a number of strings to it, print the entire list, get items at various index locations
 * within the list, and remove items from it one-by-one, each time printing it out again.
 * @author Burak YAŞAR
 * @version 04.05.2017
 */
public class SimpleLinkedList
{
   // properties
   private Node first;
   
   // constructor
   public SimpleLinkedList()
   {
      first = null;
   }
   
   // adds a new element to the head of the list
   public void addToHead( String element )
   {
      Node newNode = new Node( element );
      newNode.data = element;
      newNode.next = first;
      first = newNode;
   }
   
   // removes an element from the head of the list
   public String removeFromHead()
   {
      String result ;
      
      if( first == null )
      {
         return null;
      }
      
      else
      {
         result = first.data;
         first = first.next;
      }
      
      return result;
   }
   
   // Method to check if list is empty
   public boolean isEmpty()
   {
      return (first == null);
   }
   
   // Method to get an item from a certain index
   public String get( int index )
   {
      String result;
      Node current = first;
      
      if( index < 0 )
      {
         return null;
      }
      
      for( int i = 0; i < index; i++ )
      {
         if( current == null )
         {
            return null;
         }
         current = current.next;
      }
      result = current.data;
      
      return result;
   }
   
   // Method to get String representation of list
   public String toString()
   {
      String result = "";
      Node current = first;
      
      while( current != null )
      {
         result = result + current.data + "\n";
         current = current.next;
      }
      
      return result;
   }
   
   // inner class Node
   class Node
   {
      public Node next;
      public String data;
      
      // constructor
      public Node( String data )
      {
         this.data = data;
      }
      
      public String toString()
      {
         return data;
      }
   }
}