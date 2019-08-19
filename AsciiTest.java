import java.util.Iterator;

public class AsciiTest {

  public static void main(String[] args) {
    System.out.println(runStackTestSuite());

  }

  
  public static boolean testStackPushPeek() {
    boolean fails = false;
    DrawingStack stack = new DrawingStack();
    DrawingStack stack2 = new DrawingStack();
    DrawingChange a = new DrawingChange(1,1,'a','a');
    DrawingChange b = new DrawingChange(1,1,'b','a');
    DrawingChange c = new DrawingChange(1,1,'c','a');
    DrawingChange d = new DrawingChange(1,1,'d','a');
    
    stack.push(a);
    stack.push(b);
    stack.push(c);
    stack.push(d);

    
    Iterator<DrawingChange> it = stack.iterator();
    
    String out = "";
    while(it.hasNext()) {
      out+=it.next().prevChar;

    }
    try {
    if(!out.equals("dcba")) {
      fails = true;
    }
    if(stack.peek().prevChar != 'd') {
      fails = true;
    }
    if(stack.pop().prevChar != 'd') {
      fails = true;
    }
    }
    catch(NullPointerException e) {
      fails = true;
    }
    return !fails;
  }
  
  public static boolean runStackTestSuite() { 
boolean fails = false;

if(!testStackPushPeek()) {
  fails=true;
}
if(!testStackisEmpty()) {
  fails=true;
}
if(!testStackSize()) {
  fails=true;
}


return !fails;    
  }
  
public static boolean testStackisEmpty() { 
  boolean fails = false;
  DrawingStack stack = new DrawingStack();
  if(!stack.isEmpty()) {
    fails = true;
  }
  DrawingChange a = new DrawingChange(1,1,'a','a');
  stack.push(a);
  if(stack.isEmpty()) {
    fails = true;
  }
  stack.pop();
  if(!stack.isEmpty()) {
    fails = true;
  }
  return !fails;
    
  }

public static boolean testStackSize() { 
  boolean fails = false;
  DrawingStack stack = new DrawingStack();
  if(stack.size() != 0) {
    fails = true;
  }
  DrawingChange a = new DrawingChange(1,1,'a','a');
  stack.push(a);
  if(stack.size() != 1) {
    fails = true;
  }
  stack.pop();
  if(stack.size() != 0) {
    fails = true;
  }
  return !fails;
    
  }
  
  

public static boolean testCanvas() { 
  Canvas c = new Canvas(4,4);
  c.draw(0, 0, 'a');
  c.draw(3, 3, 'a');
  System.out.println(c.toString());
  c.printHistory();
  c.undo();
  System.out.println(c.toString());

  c.printHistory();
  
  
  
  return true;
  
  }
  

  
}

