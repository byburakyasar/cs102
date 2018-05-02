import cs1.SimpleURLReader;
/**
 * This class reads files from URL
 * @author Burak YASAR
 * @version 09.03.2017
 */
public class MySimpleURLReader extends SimpleURLReader
{
   // properties
   private String url = "";
   
   /**
    * Constructor
    * @param url is an address of web site
    */
   public MySimpleURLReader( String url )
   {
      super( url ); // creates the object of parent class
      this.url = url;
   }
   
   /**
    * gets the instance url
    * @return url is an address of web site
    */
   public String getURL()
   {
      return url;
   }
   
   /**
    * Represents name of the file as String
    * @return result is the name of file name
    */
   public String getName()
   {
      String result;
      int lastIndex;
      
      result = "";
      lastIndex = url.lastIndexOf('/');
      result = result + url.substring( lastIndex + 1);
      return result;
   }
   
   /**
    * Represents page content as String
    * @return content of this page
    */
   @Override
   public String getPageContents()
   {
      if( super.getPageContents().substring(0,4).equals("null") )
      {
         return super.getPageContents().substring(4); // fixes the null problem at the beginning
      }
      return super.getPageContents();
   }
}