import java.util.Scanner;
/*
 * This class tests SimpleStack class.
 * @author Burak YAŞAR
 * @version 04.05.2017
 */
public class SimpleStackTest
{
   // main method
   public static void main( String[] args ) 
   {
      Scanner scan = new Scanner( System.in );
      SimpleStack stack = new SimpleStack();
      
      System.out.println( "Enter a new expression(+-0123456789)" );
      String expression = scan.nextLine();
      
      // Run for the all chars of the input
      for( int i = 0; i < expression.length(); i++ )
      {
         String letter = "" + expression.charAt(i);
         
         // processes the valuesCheck if letter is a number or an operator
         if( letter.equals( "+" ) || letter.equals( "-" ) )
         {
            int firstNumber = Integer.parseInt( ( stack.pop() ));
            int secondNumber = Integer.parseInt( ( stack.pop() ));
            int result;
            
            if( letter.equals( "-" ) )
            {
               result = secondNumber - firstNumber;
            }
            
            else
            {
               result = firstNumber + secondNumber;
            }
            
            stack.push( "" + result );
         }
         
         // If it's an operator process the values
         else
         {
            stack.push( letter );
         }
      }
      System.out.println( "Result: " + stack.pop() );
   }
}