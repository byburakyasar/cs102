import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * This class solves the problems with recursive methods
 * @author Burak YAŞAR
 * @version 27.04.2017
 */
public class Lab06
{
   // main method
   public static void main( String[] args )
   {
      // variables
      String word;
      int number;
      int base;
      
      Scanner scan = new Scanner( System.in );
      System.out.println("-----Part a-----");
      
      System.out.println( "Please type a word." );
      word = scan.next();
      System.out.println( "count of e in the word: " + occurrenceOfE( word, 0) );
      //System.out.println( occurrenceOfE( "ebelemece", 0) );
      
      System.out.println("-----Part b-----");
      System.out.println( "Please enter a number." );
      number = scan.nextInt();
      convertDecimalToBinary( number );
      System.out.println();
      
      System.out.println("-----Part c-----");
      ArrayList<String> words = new ArrayList<String>();
      words.add( "Aynur" );
      words.add( "Aytek" );
      words.add( "Burak" );
      words.add( "Fuat" );
      words.add( "Vedat" );
      words.add( "Beren" ); // when this line is deleted lexicographic order will be true
      System.out.println( "Is wordlist ordered? : " + isLexicographic( words, 0 ));
      
      System.out.println("-----Part d-----");
      System.out.println( "Please enter a number." );
      number = scan.nextInt();
      System.out.println( "Please enter a number for digit number." );
      base = scan.nextInt();
      //enumerateEven( 1234, 4 );
      enumerateNumbers( number, base );
   }
   
   /* part-a
    * counts occurence of a in a text
    * @return the number of occurrences of the character "e" in a string
    */
   public static int occurrenceOfE( String text, int index )
   {
      if( text.length() > 0 && index < text.length() )
      {  
         if( text.charAt( index ) == ( 'e' ) )
         {
            return occurrenceOfE( text, index + 1 ) + 1;
         }
         
         else
         {
            return occurrenceOfE( text, index + 1 );
         }
      }
      return 0;
   }
   
   /* part-b 
    * converts a decimal number to binary
    */
   public static void convertDecimalToBinary( int value )
   {
      if( value >= 2 )
      {
         convertDecimalToBinary( value / 2 );
         //System.out.print( value % 2 );
      }
      
      else
      {
         System.out.print( value );
      }
   }
   
   /* part-c 
    * checks if number is lexicographic
    * @return true if the words are ordered lexicographically, false otherwise
    */
   public static boolean isLexicographic( ArrayList<String> words, int index )
   {
      if( index < words.size() - 1 )
      {
         return (words.get( index ).compareTo( words.get( index + 1 )) < 0) && isLexicographic( words, index + 1);   
      }
      return true;
   }
   
   /* part-d
    * enumerates all n-digit even numbers with respect to
    * from its most-significant to least-significant digits, is greater than the previous one
    */
   public static void enumerateNumbers( int number, int digit )
   {
      String evenNumber = "" + number;
      
      if( evenNumber.length() <= digit )
      {
         if( meetCriteria( evenNumber ) )
         {
            System.out.println( number );
         }
         enumerateNumbers( number + 2, digit );
      }
   }
   
   /** helper method
     * checks whether the number is valid according to criteria which states that
     * a number from its most-significant to least-significant digits, is greater than the previous one
     * @return the number of occurrences of the character "e" in a string
     */
   private static boolean meetCriteria( String number )
   {  
      if( number.length() <= 1 )
      {
         return true;
      }
      
      else
      {
         int firstIndex = Integer.parseInt( number.substring(0,1) );
         int secondIndex = Integer.parseInt( number.substring(1,2) );
         
         return ( firstIndex < secondIndex ) && meetCriteria( number.substring( 1 ) );
      }
   }
}