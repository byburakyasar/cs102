import java.util.Arrays;
/**
 * This class calculates first 100 prime number and print them
 * @author Burak YASAR
 * @version 23/02/2017
 */ 
public class PrimeIntBag
{
   public static void main( String[] args )
   {
      // properties
      IntBag primes;
      int nextPrime;
      int primeDivisor;
      
      // instance of IntBag class
      primes = new IntBag();
      primes.add( 2 );
      
      nextPrime = 0;
      for( int j = primes.getIntFromBag( primes.size() - 1 ) + 1; primes.size() <= 99; j++ )
      {
         primeDivisor = 0;
         for(int index = 0; index < primes.size() ; index++)
         {
            if( j % primes.getIntFromBag( index ) != 0 ) // checks whether the number can be divided by prime numbers which all come before this number
            {
               primeDivisor++; // if not divided increase the number of primeDivisor that all cannot divide this number
            }
         }
         if( primeDivisor == primes.size() ) // checks the number of primes that cannot divide this number is equal to all of primes which come before this number
         {
            nextPrime = j; // if the number cannot be divided by prime numbers which all come before this number
            primes.add( nextPrime ); // add it as nextPrime
         }
      }
      System.out.println( "First 100 prime numbers are\n" + primes.toString() );
   }
}
