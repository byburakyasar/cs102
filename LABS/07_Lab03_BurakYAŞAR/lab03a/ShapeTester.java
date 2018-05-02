package lab03a;
/*
 * A simple class to test ShapeContainer object
 * @author Burak YASAR
 * @version 23.03.2017
 */
import java.util.Scanner;

public class ShapeTester
{
   // main method
   public static void main( String[] args)
   {
      // CONSTANTS
      final int CREATE_SHAPE = 1;
      final int ADD_SHAPE = 2;
      final int GET_TOTAL_AREA = 3;
      final int PRINT_SHAPES = 4;
      final int FIND_SHAPE = 5;
      final int REMOVE_SHAPE = 6;
      final int EXIT = 7;
      
      // variables
      ShapeContainer setOfShapes = null;
      Scanner scan = new Scanner( System.in );
      boolean valid;
      
      do
      {
         valid = true;
         // display main menu
         displayMainMenu();
         
         int selection;
         selection = scan.nextInt();
         
         // Choice to reate new ShapeContainer
         if( selection == CREATE_SHAPE )
         {
            setOfShapes = new ShapeContainer();
            
            System.out.println( "ShapeContainer object has been created successfully!");
         }
         
         // Choice to create new Shape
         else if( selection == ADD_SHAPE )
         {
            displayAddShapeMenu();
            
            selection = scan.nextInt();
            
            // Choice to create new Rectangle
            if( selection == 1 )
            {
               System.out.println( "Enter rectangle's width:");
               int width;
               width = scan.nextInt();
               
               System.out.println( "Enter rectangle's height:");
               int height;
               height = scan.nextInt();
               
               System.out.println( "Enter x coordinate:");
               int x;
               x = scan.nextInt();
               
               System.out.println( "Enter y coordinate:");
               int y;
               y = scan.nextInt();
               
               setOfShapes.add( new Rectangle( width, height, x, y));
            }
            
            // Choice to create new Circle
            else if( selection == 2 )
            {
               System.out.println( "Enter radius:");
               int radius;
               radius = scan.nextInt();
               
               System.out.println( "Enter x coordinate:");
               int x;
               x = scan.nextInt();
               
               System.out.println( "Enter y coordinate:");
               int y;
               y = scan.nextInt();
               
               setOfShapes.add( new Circle( radius, x, y) );
            }
            
            // Choice to create new Square
            else if( selection == 3 )
            {
               System.out.println( "Enter the length of the side of the square:");
               int side;
               side = scan.nextInt();
               
               System.out.println( "Enter x coordinate:");
               int x;
               x = scan.nextInt();
               
               System.out.println( "Enter y coordinate:");
               int y;
               y = scan.nextInt();
               
               setOfShapes.add( new Square( side, x, y ) );
            }
         }
         
         // Choice to calculate total area
         else if( selection == GET_TOTAL_AREA )
         {
            System.out.println( "Total Area is: " + setOfShapes.getArea());
         }
         
         // Choice to print String representation of ShapeContainer
         else if( selection == PRINT_SHAPES )
         {
            System.out.println( setOfShapes );
         }
         
         // Choice to find and select
         else if( selection == FIND_SHAPE )
         {
            System.out.println( "Enter x coordinate:");
            int x;
            x = scan.nextInt();
            
            System.out.println( "Enter y coordinate:");
            int y;
            y = scan.nextInt();
            
            setOfShapes.findTheShape( x, y );
         }
         
         // choice to remove all selected
         else if( selection == REMOVE_SHAPE )
         {
            setOfShapes.removeSelectedShapes();
         }
         
         // choice to exit
         else if( selection == EXIT )
         {
            valid = false;
         }
         else
         {
            System.out.println( "You must enter between 1-7 inclusive!");
         }
      } while( valid );
      
      
      System.out.println( "Bye..");
   }
   
   // helper method to show main menu
   public static void displayMainMenu()
   {
      System.out.println();
      System.out.println( "Select an option between 1-7 inclusive.");
      System.out.println( "1. Create a new ShapeContainer object.");
      System.out.println( "2. Add a new shape.");
      System.out.println( "3. Show total area of the shapes.");
      System.out.println( "4. Show container information.");
      System.out.println( "5. Find and select.");
      System.out.println( "6. Remove all selected.");
      System.out.println( "7. Exit.");
      System.out.println();
      System.out.println();
   }
   
   // helper method to show add shape menu
   public static void displayAddShapeMenu()
   {
      System.out.println();
      System.out.println( "Select an option between 1-3 inclusive:");
      System.out.println( "1. Rectangle");
      System.out.println( "2. Circle");
      System.out.println( "3. Square");
      System.out.println();
   }
}