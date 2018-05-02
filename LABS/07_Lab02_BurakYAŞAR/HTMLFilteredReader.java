/**
 * This class gets page contents of a HTML file
 * @author Burak Yasar
 * @version 09.03.2017
 */
public class HTMLFilteredReader extends MySimpleURLReader
{
   /**
    * Constructor
    * @param url is an address of web site
    */
   public HTMLFilteredReader ( String url)
   {
      super( url ); // creates the object of parent class
   }
   
   /**
    * Represents page content as String without html tags
    * @return content of this page without html parts
    */
   @Override
   public String getPageContents()
   {
      String result;
      result =  "";
      boolean check;
      check = true;
      String text;
      text = getUnfilteredPageContents();
      for (int i = 0; i<= text.length()-1 ; i++)
      {
         check = true;
         if (text.charAt(i)=='<')
         {
            for (int k = i + 1 ;(k <= text.length() - 1) && check; k++)
            {
               if (text.charAt(k) == '>')
               {
                  i = k;
                  check = false;
               }
            }
         }
         else if( text.charAt(i) == '&' )
         {
            for (int k = i + 1 ;(k <= text.length() - 1) && check; k++)
            {
               if (text.charAt(k) == ';')
               {
                  i = k;
                  check = false;
               }
            }
         }
         else
         {
            result = result + text.charAt(i);
         }
      }
      return result;
   }
   
   /**
    * Represents page content as String provided that super class
    * @return content of this page with html tags "unfiltered"
    */
   public String getUnfilteredPageContents()
   {
      return super.getPageContents();
   }
}