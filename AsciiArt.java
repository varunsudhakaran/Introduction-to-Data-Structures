import java.util.Scanner;

public class AsciiArt {
  
  private static Canvas c;

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    userInterface();
  }

  public static boolean isNumeric(String str) {
    try {
      int x = Integer.parseInt(str);
    }
    catch(NumberFormatException  e) {
      System.out.println("Please enter an Integer");
      return false;
    }
    return true;
  }
  
  public static boolean isChar(String str) {
    if(str.length() == 1) {
      return true;
    }
    else {
      System.out.println("Please Enter a Single Character");
      return false;
    }
      
  }
  
  
  public static void userInterface() {
    
    Scanner scnr = new Scanner(System.in);
    String userInput1;
    char character;
    String widths,heights;
    String rows,cols;
    int width =-1,height =-1;
    int row = -1,col =-1;
    while(true) {
    System.out.println("======== MENU ========");
    System.out.println("[1] Create a new canvas");
    System.out.println("[2] Draw a character");
    System.out.println("[3] Undo drawing");
    System.out.println("[4] Redo drawing");
    System.out.println("[5] Show current canvas");
    System.out.println("[6] Show drawing history");
    System.out.println("[7] Exit");
    System.out.print("> ");
    userInput1 = scnr.nextLine().trim();
    if(userInput1.equals("1")) {
      while(width<=0) {
        System.out.println("Width > ");
        widths = scnr.nextLine().trim();
        if(isNumeric(widths)) {
          width = Integer.parseInt(widths);
          if(width<=0) {
            System.out.println("Please enter a width above 0 ");
          }
        }
        
      }
      
      while(height<=0) {
        System.out.println("Height > ");
        heights = scnr.nextLine().trim();
        if(isNumeric(heights)) {
          height = Integer.parseInt(heights);
          if(height<=0) {
            System.out.println("Please enter a Height above 0 ");
          }
        }
        
        
      }
      
      c = new Canvas(width,height);
      
      
    }
    if(userInput1.equals("2")) {
      while(row<0 || row>=height) {
        System.out.println("Row > ");
        rows = scnr.nextLine().trim();
        if(isNumeric(rows)) {
          row = Integer.parseInt(rows);
          if(row<0 || row>= height) {
            System.out.println("Please enter a Row above 0 and below "+height);
          }
        }
        
        
      }
      
      while(col<0 || col>=width) {
        System.out.println("Col > ");
        cols = scnr.nextLine().trim();
        if(isNumeric(cols)) {
          col = Integer.parseInt(cols);
          if(col<0 || col>=width) {
            System.out.println("Please enter a Height above 0 ");
          }
        }
        
      }
      
      while(true) {
      System.out.println("Character > ");
      String temp = scnr.nextLine();
      if(isChar(temp)) {
        character = temp.charAt(0);
        break;
      }
      
      }
      
      
      c.draw(row, col, character);
      row = -1;
      col = -1;
    }
    if(userInput1.equals("3")) {
      c.undo();

    }
    if(userInput1.equals("4")) {
      c.redo();

    }
    if(userInput1.equals("5")) {
      System.out.println(c);

    }
    if(userInput1.equals("6")) {
     c.printHistory();

    }
    if(userInput1.equals("7")) {
      System.out.println("Bye!");
      break;

     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
  }
}
