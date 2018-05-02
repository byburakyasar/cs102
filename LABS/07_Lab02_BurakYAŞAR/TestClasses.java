import cs1.SimpleURLReader;
/**
 * This class tests other classes
 * @author Burak YASAR
 * @version 09.03.2017
 */
public class TestClasses
{
   // CONSTANTS
   public static final String SEPERATOR = "--------------------------------------";
   
   // main method
   public static void main( String[] args )
   {
      // Tests part a
      System.out.println( SEPERATOR );
      SimpleURLReader suReader;
      suReader = new SimpleURLReader( "http://www.cs.bilkent.edu.tr/~david/housman.txt" );
      System.out.println( "Page content:\n" + suReader.getPageContents() );
      System.out.println( "Number of lines: " + suReader.getLineCount() );
      System.out.println( SEPERATOR );
      
      // Tests part b
      System.out.println( "\n" + SEPERATOR );
      MySimpleURLReader msuReader;
      msuReader = new MySimpleURLReader( "http://www.cs.bilkent.edu.tr/~david/housman.txt" );
      System.out.println( "URL name: " + msuReader.getURL() );
      System.out.println( "File name: " + msuReader.getName() );
      System.out.println( "Number of lines: " + msuReader.getLineCount() );
      System.out.println( "Page contents: ");
      System.out.println( msuReader.getPageContents() );
      System.out.println( SEPERATOR );
      
      // Tests part c
      System.out.println( "\n" + SEPERATOR );
      HTMLFilteredReader hfReader;
      hfReader = new HTMLFilteredReader( "http://www.cs.bilkent.edu.tr/~david/housman.htm" );
      System.out.println( "Unfiltered page contents: " );
      System.out.println( hfReader.getUnfilteredPageContents() );
      System.out.println();
      System.out.println( "Filtered page contents: " );
      System.out.println( hfReader.getPageContents() );
      System.out.println( SEPERATOR );
      
      // Tests Part d
      System.out.println( "\n" + SEPERATOR );
      SuperHTMLFilteredReader shfReader;
      shfReader = new SuperHTMLFilteredReader( "http://www.cs.bilkent.edu.tr/~david/index.html" );
      System.out.println( "Links:" );
      System.out.println( shfReader.getLinks() );
      System.out.print( "Percentage increase in size between the html and no-html contents: " );
      System.out.println( "Overhead percentage: " + shfReader.computeOverhead() );
   }
}