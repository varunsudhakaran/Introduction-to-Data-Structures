import java.util.Iterator;

public class Canvas {

  
  private final int width;  // width of the canvas
  private final int height; // height of the canvas
   
  private char [][] drawingArray; // 2D character array to store the drawing
   
  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Canvas c = new Canvas(5,5);
    c.draw(1, 2, 'y');
    
    System.out.println(c.toString());

  }
  
  public Canvas(int width, int height) { 
    if(width<0 || height<0) {
      throw new IllegalArgumentException();
    }
    
    this.width = width;
    this.height = height;
    drawingArray = new char[this.height][this.width];
    undoStack = new DrawingStack();
    redoStack = new DrawingStack();
    
    
  } // Constructor. Throws IllegalArgumentException if width or height is 0 or negative
  // A Canvas is initially blank (use the space ' ' character)
  
public DrawingStack getundoStack() {
  return undoStack;
}
public void draw(int row, int col, char c) { 
 
  char temp;
  if(row<0 || row>=height || col<0 || col>=width) {
    throw new IllegalArgumentException();
  }
  temp =  drawingArray[row][col];
  drawingArray[row][col] = c;
  
  undoStack.push(new DrawingChange(col,row,temp,c));
  while(!redoStack.isEmpty()) {
    redoStack.pop();
  }
  
} // Draw a character at the given position
  // This method should throw an IllegalArgumentException if the drawing position is outside the canvas
  // If that position is already marked with a different character, overwrite it.
  // After making a new change, add a matching DrawingChange to the undoStack so that we can undo if needed.
  // After making a new change, the redoStack should be empty.

public boolean undo() { 
  
  if(undoStack.isEmpty()) {
    return false;
  }
  else {
    DrawingChange temp = undoStack.pop();
    drawingArray[temp.y][temp.x] = temp.prevChar;
    redoStack.push(temp);
    
    
    
    return true;
  }

} // Undo the most recent drawing change. Return true if successful. False otherwise.
  // An undone DrawingChange should be added to the redoStack so that we can redo if needed.

public boolean redo() { 
  if(redoStack.isEmpty()) {
    System.out.println("Point");
    return false;
  }
  else {
    DrawingChange temp = redoStack.pop();
    drawingArray[temp.y][temp.x] = temp.newChar;
    undoStack.push(temp);
    return true;
  }

} // Redo the most recent undone drawing change. Return true if successful. False otherwise.
  // A redone DrawingChange should be added (back) to the undoStack so that we can undo again if needed.

public String toString() {
  String s = System.lineSeparator();
  String drawing = "";
  for(int i=0;i<drawingArray.length;i++) {
    String a = new String(drawingArray[i]);
    drawing+=a;
    if(i != drawingArray.length-1) {
      drawing+=s;
    }
    
    }
return drawing;
  } // Return a printable string version of the Canvas.
/* Format example: [_ is blank. Use System.lineSeparator() to put a newline character between rows]
* X___X
* _X_X_
* __X__
* _X_X_
* X___X
*/

public void printHistory() {
  Iterator<DrawingChange> it = undoStack.iterator();
  int counter = undoStack.size();
  while(it.hasNext()) {
    DrawingChange temp = it.next();
    System.out.println(counter + ". draw '" +temp.newChar+
        "' on ("+temp.x+","+temp.y+")");
    counter--;
  }
  
  
}

}
