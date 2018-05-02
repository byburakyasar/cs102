import java.util.ArrayList;
/**
 * A simple class to get links from a page
 * @author Burak YASAR
 * @version 09.03.2017
 */
public class SuperHTMLFilteredReader extends HTMLFilteredReader
{
   /**
    * Constructor
    * @param url is an address of web site
    */
   public SuperHTMLFilteredReader( String url)
   {
      super( url ); // creates the object of parent class
   }
   
   /**
    * Calculates the percentage increase in size between the html and no-html contents.
    * @return this percentage
    */
   public int computeOverhead()
   {
      double withoutHtml;
      double withHtml;
      withoutHtml = super.getPageContents().length();
      withHtml = super.getUnfilteredPageContents().length();
      
      return (int)( (withHtml - withoutHtml) / withHtml  * 100 ); // cast to integer and return it
   }
   
   /**
    * Returns links as a ArrayList type String
    * @return lists all the links
    */
   public ArrayList<String> getLinks()
   {
      // declare variables and initiliazes
      ArrayList <String> output;
      output = new ArrayList<String>();
      String unfiltered;
      unfiltered = super.getUnfilteredPageContents();
      boolean found;
      int startInt;
      startInt = 0;
      String links;
      links = "";
      
      for( int i = 0; i < unfiltered.length() - 6; i++ )
      {
         found = false;
         if( unfiltered.substring( i,i+6).equals( "href=\"" ) )
         {
            found = true;
         }
         
         if( found )
         {
            startInt = i + 6;
            while( unfiltered.indexOf(unfiltered.substring( startInt,startInt + 1) ) != unfiltered.indexOf("\"") )
            {
               links = links + unfiltered.substring( startInt, startInt + 1 );
               startInt++;
            }
            
            output.add( links + "\n" );
            links = "";
         }
      }
      return output;
   }
}